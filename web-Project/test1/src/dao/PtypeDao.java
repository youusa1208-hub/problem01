package dao;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import beans.PtypeBean;

public class PtypeDao extends Dao {
//	SELECT文（全データ）
	public List<PtypeBean> select()
			throws NamingException,SQLException{
//		Listコレクションに格納
		List<PtypeBean> list = new  ArrayList<>();
		String sql = "SELECT * FROM ptype ORDER BY ptid";
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
	
//	SELECT文(1レコード)
	public PtypeBean select(int ptid)
			throws NamingException,SQLException{
			PtypeBean pb = new PtypeBean();
			String sql = "SELECT * FROM ptype WHERE ptid=?";
			PreparedStatement stmt = prepareStatement(sql);
			stmt.setInt(1, ptid);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				pb.setPtid(rs.getInt("ptid"));
				pb.setPtname(rs.getString("ptname"));
				pb.setPtimg(rs.getString("ptimg"));
			}
			return pb;
		}

//	INSERT文
	public void insert(PtypeBean pb)
			throws NamingException,SQLException{
//		副問合せ
		String sql1 = "(SELECT MAX(ptid)+1 FROM ptype)";
		String sql = "INSERT INTO ptype(ptid,ptname,ptimg)"+"VALUES("+sql1+",?,?）";
		PreparedStatement stmt = prepareStatement(sql);
//		引数をバインド
		stmt.setString(1, pb.getPtname());
		stmt.setString(2, pb.getPtimg());
		stmt.executeUpdate();
	}
	
//	DELETE文
	public void delete(int ptid)
			throws NamingException,SQLException{
		String sql = "DELETE FROM ptype WHERE ptid=?";
		PreparedStatement stmt = prepareStatement(sql);
//		バインド
		stmt.setInt(1, ptid);
		stmt.executeUpdate();
	}
	
//	update文
	public void update(PtypeBean pb)
			throws NamingException,SQLException{
		String sql = "UPDATE ptype SET ptname=?,ptimg=?"+"WHERE ptid=?";
		PreparedStatement stmt = prepareStatement(sql);
//		バインド
		stmt.setString(1, pb.getPtname());
		stmt.setString(2, pb.getPtimg());
		stmt.setInt(3, pb.getPtid());
		stmt.executeUpdate();
	}
}