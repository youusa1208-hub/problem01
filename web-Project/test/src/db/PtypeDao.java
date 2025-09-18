package db;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import beans.PtypeBean;

public class PtypeDao extends Dao {
	
//	SELECT文用
	public List<PtypeBean> select()
		throws NamingException,SQLException{
//		Listコレクションに格納
		List<PtypeBean> list = new  ArrayList<>();
		String sql = "SELECT * FROM ptype ORDER BY ptid";
//		親クラスのメソッドを呼び出す
		PreparedStatement stmt = prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){			
			PtypeBean pb = new PtypeBean();
			pb.setPtid(rs.getInt("ptid"));
			pb.setPtname(rs.getString("ptname"));
			pb.setPtimg(rs.getString("ptimg"));
			list.add(pb);
		}
		return list;
	}
//	1レコード分のデータを取得
	public PtypeBean select(int ptid)
		throws NamingException,SQLException{
		PtypeBean pb = new PtypeBean();
		String sql = "SELECT * FROM ptype WHERE ptid=?";
		PreparedStatement stmt = prepareStatement(sql);
//		引数をバインド
		stmt.setInt(1, ptid);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			pb.setPtid(rs.getInt("ptid"));
			pb.setPtname(rs.getString("ptname"));
			pb.setPtimg(rs.getString("ptimg"));
		}
		return pb;
	}
//	データ追加
	public void insert(PtypeBean pb)
			throws NamingException,SQLException{
		String sql1 = "(SELECT MAX(ptid)+1 FROM ptype)";
		String sql = "INSERT INTO ptype(ptid,ptname,ptimg)"+"VALUES("+sql1+",?,?）";
		PreparedStatement stmt = prepareStatement(sql);
//		引数をバインド
		stmt.setString(1, pb.getPtname());
		stmt.setString(2, pb.getPtimg());
		stmt.executeUpdate();
	}
//		データ削除
	public void delete(int ptid)
		throws NamingException,SQLException{
		String sql = "DELETE FROM ptype WHERE ptid=?";
		PreparedStatement stmt = prepareStatement(sql);
//		引数をバインド
		stmt.setInt(1, ptid);
		stmt.executeUpdate();
	}
//		データ更新
	public void update(PtypeBean pb)
		throws NamingException,SQLException{
		String sql = "UPDATE ptype SET ptname=?,ptimg=?"+"WHERE ptid=?";
		PreparedStatement stmt = prepareStatement(sql);
//		引数をバインド
		stmt.setString(1, pb.getPtname());
		stmt.setString(2, pb.getPtimg());
		stmt.setInt(3, pb.getPtid());
		stmt.executeUpdate();
	}
}
