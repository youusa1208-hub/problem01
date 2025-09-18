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
 * Servlet implementation class Srv17_PtypeIns
 */
@WebServlet("/Srv17_PtypeIns")
public class Srv17_PtypeIns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv17_PtypeIns() {
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
//		SQｌ文の指定1(副問合せで現在登録中のptidの最大値+1の値を取得)
		String sql1 = "(SELECT MAX(ptid)+1 FROM ptype)";
//		ＳＱＬ文の指定(主):入力値を設定する部分に?を仮置きする
		String sql = "INSERT INTO ptype(ptid, ptname, ptimg) VALUES ("+sql1+",?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
//		仮置きした？(プレースホルダー)に、送信値を設定(バインド)
//		バインドでは、設定する値の型によって異なるメソッドを使用する
//		setString(),setInt(),setDouble(),setDate()
//		setString(設定するプレースホルダー(1~),設定値)
		stmt.setString(1,request.getParameter("ptname"));
		stmt.setString(2,request.getParameter("ptimg"));
//		SQL文の実行
		stmt.executeUpdate();
//		SQL実行結果取得用のSQL文を指定
		String sql2 = "SELECT * FROM ptype ORDER BY ptid";
		stmt = conn.prepareStatement(sql2);
//		SQL文を実行し、結果を取得
		ResultSet rs = stmt.executeQuery();
//		Listコレクションに格納
		List<PtypeBean> list = new ArrayList<>();
//		取得したecu数分繰り返す
		while(rs.next()){
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
//		作成済みのJSPを指定
		String url = "Srv16_PtypeIns.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}