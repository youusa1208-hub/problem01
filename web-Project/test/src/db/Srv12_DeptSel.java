package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;
import java.util.*;

/**
 * Servlet implementation class Srv12_DeptSel
 */
@WebServlet("/Srv12_DeptSel")
public class Srv12_DeptSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv12_DeptSel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;
		
		try{
			InitialContext initCtx = new InitialContext();
			ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/Servlet");
			
	}catch(NamingException e){
		throw new ServletException(e);
	}
		
//		接続情報の取得(=接続)
		try(Connection conn = ds.getConnection()){
//		接続後、SQL実行用のツールを生成
			String sql = "SELECT * FROM dept ORDER BY dname";
			PreparedStatement stmt = conn.prepareStatement(sql);
//		SQL文を実行し、結果を取得
			ResultSet rs = stmt.executeQuery();
//		rsに格納したデータをレコード毎に処理→Listコレクションに格納
			List<String> list = new ArrayList<>();
//		re.next()で1レコードずつ取得するポインタを移動
//			true:ポインタが移動できた(次のレコードがある)
//			false:ポインタが移動できなかった(次のレコードがない)
//		全てのレコードを処理するまで繰り返す
		while(rs.next()){
//				rs.getInt(列名)　→指定した列の値をint型で取得
			int deptno = rs.getInt("deptno");
//				rs.deptno(列名)　→指定した列の値をString型で取得
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			list.add(deptno+":"+dname+":"+loc);
			}
//			属性名を付与
			request.setAttribute("li", list);
		}catch(SQLException e){
			throw new ServletException(e);
		}
//		転送先の指定
		String url = "Srv12_DeptSel.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
