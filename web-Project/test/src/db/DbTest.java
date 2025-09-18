package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class DbTest
 */
@WebServlet("/DbTest")
public class DbTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbTest() {
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
//			接続用の設定を取得、dsに格納
//				(context.xmlの<Resource>タグのname属性の値と一致した情報を取得している)
			ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/Servlet");
			
	}catch(NamingException e){
		throw new ServletException(e);
	}
		
//		try-with-resource
//		リソース:資源、今回はデータベースを指す
//			try-with-resourceではtry{}と()の中で例外が発生した場合
//			()内で生成したインスタンスのclose()メソッドを実施し、リソースと切断(終了処理を実施)するようになっている
//		正常に終了した場合もclose()メソッドが実施される
		try(Connection conn = ds.getConnection()){
			log("接続成功");
		}catch(SQLException e){
			throw new ServletException(e);
		}
		request.getRequestDispatcher("complete.html").forward(request, response);
	}
}