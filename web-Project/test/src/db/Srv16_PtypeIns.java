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
 * Servlet implementation class Srv16_PtypeIns
 */
@WebServlet("/Srv16_PtypeIns")
public class Srv16_PtypeIns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv16_PtypeIns() {
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
		
		try(Connection conn = ds.getConnection()){
			//SQl文の指定　ドラゴン=drangon
			String sql = "INSERT INTO ptype(ptid,ptname,ptimg)"+"VALUES(14,'ドラゴン','img/dragon_t.png')";
//			SQL実行用ツールの生成
			PreparedStatement stmt = conn.prepareStatement(sql);
//			SQL文(INSERT文)の実行
			stmt.executeUpdate();
//			SQL実行用ツールの生成
			String sql2 = "SELECT * FROM ptype ORDER BY ptid";
//			SQL実行用ツールの生成
			stmt = conn.prepareStatement(sql2);
//			SQL文を実行し、結果を取得
			ResultSet rs = stmt.executeQuery();
//			rsに格納したデータをレコード毎に処理→Listコレクションに格納
			List<PtypeBean> list = new ArrayList<>();
//			取得したecu数分繰り返す
			while(rs.next()){
//				JavBeansののインスタンスを生成
				PtypeBean pb = new PtypeBean();
				pb.setPtid(rs.getInt("ptid"));
				pb.setPtname(rs.getString("ptname"));
				pb.setPtimg(rs.getString("ptimg"));
//				listに追加
				list.add(pb);
			}
//				属性名を付与
				request.setAttribute("li", list);
			}catch(SQLException e){
				throw new ServletException(e);
			}
//			転送先の指定
		String url = "Srv16_PtypeIns.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}