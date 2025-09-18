package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.*;

import beans.PtypeBean;

/**
 * Servlet implementation class Srv15_PtypeIns
 */
@WebServlet("/Srv15_PtypeIns")
public class Srv15_PtypeIns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv15_PtypeIns() {
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
			//どく=poison
			String sql = "INSERT INTO ptype(ptid,ptname,ptimg)"+"VALUES(13,'どく','img/poison_t.png')";
//			SQL実行用ツールの生成
			PreparedStatement stmt = conn.prepareStatement(sql);
//		DML文を実行する場合:executeUpdate()
//		戻り値:int(実行件数)	
			int num = stmt.executeUpdate();
//			属性名を付与
			request.setAttribute("n", num);
		}catch(SQLException e){
			throw new ServletException(e);
		}
//		転送先の指定
		String url = "Srv15_PtypeIns.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}