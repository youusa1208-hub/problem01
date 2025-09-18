package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import beans.*;
import dao.*;

/**
 * Servlet implementation class Srv24_PokeUpd
 */
@WebServlet("/Srv24_PokeUpd")
public class Srv24_PokeUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv24_PokeUpd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try(PokeDao pd = new PokeDao()){
//	更新対象の一覧データを取得
		List<PokeBean> list = pd.select();
		request.setAttribute("li", list);
//	[更新]の文字列と更新対象選択後の送信先の文字列に属性名を付与(type,send)
		request.setAttribute("type", "更新");
		request.setAttribute("send", "Srv24_PokeUpd");
	}catch(Exception e){
		throw new ServletException(e);
	}
	String url="Srv24_PokeList.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try(PokeDao pkd = new PokeDao();
		PtypeDao ptd = new PtypeDao()){
//	1レコード分を取得するため送信されたpidを基にselect()を実行
		int pid = Integer.parseInt(request.getParameter("pid"));
		PokeBean pb = pkd.select(pid);
//	Ptypeテーブルの一覧データを取得
		List<PtypeBean> list = ptd.select();
		request.setAttribute("pb", pb);
		request.setAttribute("li", list);
	}catch(Exception e){
		throw new ServletException(e);
	}
	String url="Srv24_PokeUpd.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}
}
