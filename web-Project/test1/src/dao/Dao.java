package dao;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class Dao implements AutoCloseable {

//	フィールドの定義
	private static Connection conn;
	
//	DBとの接続を取得
	public Connection getConn() throws NamingException, SQLException {
		try{
//			未接続時に接続処理を実行
			if(conn==null){
				InitialContext initCtx = new InitialContext();
				DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/Servlet");
				conn = ds.getConnection();
			}
//			二つの例外クラスをキャッチする記述
		}catch(NamingException | SQLException e){
			conn = null;
			throw e;
		}
		return conn;
	}
//	SQL実行用ツールを返す
	public PreparedStatement prepareStatement(String sql)
		throws NamingException,SQLException{
//		接続処理を実行、戻り値の接続情報からprepareStatement()を直接呼び出す
		return getConn().prepareStatement(sql);
	}
	
	@Override
	public void close() throws Exception {
		try{
//			接続情報がある場合
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
//			切断失敗時も必ず接続情報を初期値する
			conn=null;
		}

	}

}
