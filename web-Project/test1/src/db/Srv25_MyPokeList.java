package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import beans.PmBean;
import beans.PmgetBean;
import dao.PmgetDao;


/**
 * Servlet implementation class Srv25_MyPokeList
 */
@WebServlet("/Srv25_MyPokeList")
public class Srv25_MyPokeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv25_MyPokeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try(PmgetDao pd = new PmgetDao()){
//		ログイン中のユーザー名、パスワードの情報を取得
		HttpSession session = request.getSession();
		PmBean pb = (PmBean)session.getAttribute("pm");
		List<PmgetBean> list = pd.select(pb);
		request.setAttribute("li", list);
		
	}catch(Exception e){
		throw new ServletException(e);
	}
	String url="Srv25_MyPokeList.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try(PmgetDao pd = new PmgetDao()){
		int pid= Integer.parseInt(request.getParameter("pid"));
		PmgetBean pgb = new PmgetBean();
		pgb.setPid(pid);
		pgb.setNickname(request.getParameter("nickname"));
		pgb.setGen(request.getParameter("gen"));
//		ログイン中のポケモンマスター情報を取得
		HttpSession session = request.getSession();
		PmBean pb = (PmBean)session.getAttribute("pm");
//		入力したゲットポケモンの情報とログイン中のポケモンマスターの情報を引数にしてinsert()を実行
		pd.insert(pgb, pb);
//		追加後の一覧データを取得
		List<PmgetBean> list =pd.select(pb);
		request.setAttribute("li", list);
	}catch(Exception e){
		throw new ServletException(e);
	}
	String url="Srv25_MyPokeList.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}

}
