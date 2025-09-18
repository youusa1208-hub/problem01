package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;
import beans.PtypeBean;

/**
 * Servlet implementation class Sry19_PtypeDel
 */
@WebServlet("/Sry19_PtypeDel")
public class Sry19_PtypeDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sry19_PtypeDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DataSource ds = null;
		
		try{
			InitialContext initCtx = new InitialContext();
			ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/Servlet");
			
	}catch(NamingException e){
		throw new ServletException(e);
	}
		try(Connection conn = ds.getConnection()){
//			DELETE文の指定
			String sql = "DELETE FROM ptype WHERE ptid=?";
//			SQL実行用ツールの生成
			PreparedStatement stmt = conn.prepareStatement(sql);
//			送信データを受け取れる
			String ptidstr = request.getParameter("ptid");
//			整数型に変換
			int ptid = Integer.parseInt(ptidstr);
//			バインド
			stmt.setInt(1, ptid);
//			Delete文の実行
			stmt.executeUpdate();
//			実行後の一覧データを取得するため、SELECT文を指定
			String sql1 = "SELECT　*　FROM　ptype ORDER BY ptid";
//			一覧データを取得し、Listコレクションのインスタンスに格納
			stmt = conn.prepareStatement(sql1);
//			SQL文を実行し、結果を取得
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
//			作成済みのJSPを指定
			String url = "Srv16_PtypeIns.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	}