package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import beans.PtypeBean;

/**
 * Servlet implementation class Srv20_PtypeDel
 */
@WebServlet("/Srv20_PtypeDel")
public class Srv20_PtypeDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv20_PtypeDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//	SELECT文を実行し、現在のテーブルのデータを取得
	DataSource ds = null;	
	try{
		InitialContext initCtx = new InitialContext();
		ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/Servlet");
			
	}catch(NamingException e){
		throw new ServletException(e);
	}
	
		try(Connection conn = ds.getConnection()){	
			String sql = "SELECT　*　FROM　ptype ORDER BY ptid";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
//			Listコレクションに格納
			List<PtypeBean> list = new ArrayList<>();
//			取得したecu数分繰り返す
			while(rs.next()){
//				JavBeansののインスタンスを生成			
				PtypeBean pb = new PtypeBean();
				pb.setPtid(rs.getInt("ptid"));
				pb.setPtname(rs.getString("ptname"));
				pb.setPtimg(rs.getString("ptimg"));
				list.add(pb);
			}
				request.setAttribute("li", list);
			}catch(SQLException e){
				throw new ServletException(e);
			}
			String url = "Srv20_PtypeDel.jsp";
			request.getRequestDispatcher(url).forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		削除処理+処理後のデータ取得
		DataSource ds = null;	
		try{
			InitialContext initCtx = new InitialContext();
			ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/Servlet");
				
		}catch(NamingException e){
			throw new ServletException(e);
		}
		
		try(Connection conn = ds.getConnection()){	
			String sql = "DELETE FROM ptype WHERE ptid=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
//			送信データを受け取る
			int ptid = Integer.parseInt(request.getParameter("ptid"));
//			バインド
			stmt.setInt(1, ptid);
//			削除処理実行
			stmt.executeUpdate();
//			実行後の一覧データを取得するため、SELECT文を指定
			String sql1 = "SELECT　*　FROM　ptype ORDER BY ptid";
//			一覧データを取得し、Listコレクションのインスタンスに格納
			stmt = conn.prepareStatement(sql1);
			ResultSet rs = stmt.executeQuery();
//			Listコレクションに格納
			List<PtypeBean> list = new ArrayList<>();
//			取得したecu数分繰り返す
			while(rs.next()){
//				JavBeansののインスタンスを生成			
				PtypeBean pb = new PtypeBean();
				pb.setPtid(rs.getInt("ptid"));
				pb.setPtname(rs.getString("ptname"));
				pb.setPtimg(rs.getString("ptimg"));
				list.add(pb);
			}
				request.setAttribute("li", list);
			}catch(SQLException e){
				throw new ServletException(e);
			}
		String url = "Srv16_PtypeIns.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
