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

import beans.DeptBean;
/**
 * Servlet implementation class Srv12a_DeptSel
 */
@WebServlet("/Srv12a_DeptSel")
public class Srv12a_DeptSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv12a_DeptSel() {
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
			String sql = "SELECT * FROM dept ORDER BY deptno";
			PreparedStatement stmt = conn.prepareStatement(sql);
//		SQL文を実行し、結果を取得
			ResultSet rs = stmt.executeQuery();
//		rsに格納したデータをレコード毎に処理→Listコレクションに格納
			List<DeptBean> list = new ArrayList<>();
//		取得したecu数分繰り返す
		while(rs.next()){
//			JavBeansののインスタンスを生成
			DeptBean db = new DeptBean();
			db.setDeptno(rs.getInt("deptno"));
			db.setDname(rs.getString("dname"));
			db.setLoc(rs.getString("loc"));
//			listに追加
			list.add(db);
		}
//			属性名を付与
			request.setAttribute("li", list);
		}catch(SQLException e){
			throw new ServletException(e);
		}
//		転送先の指定
		String url = "Srv12a_DeptSel.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}