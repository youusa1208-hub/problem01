package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.PokeBean;
import dao.PokeDao;
import java.util.*;

/**
 * Servlet implementation class Srv25_SelPokeList
 */
@WebServlet("/Srv25_SelPokeList")
public class Srv25_SelPokeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv25_SelPokeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//	ゲットするポケモンを選択する画面のため、pokemonテーブルの一覧データを取得
	try(PokeDao pd = new PokeDao()){
		List<PokeBean> list = pd.select();
		request.setAttribute("li", list);
	}catch (Exception e) {
		throw new ServletException(e);
	}
	String url ="Srv25_SelPokeList.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try(PokeDao pd = new PokeDao()){
		int pid = Integer.parseInt(request.getParameter("pid"));
		PokeBean pb = pd.select(pid);
		request.setAttribute("pb", pb);
		
	}catch(Exception e){
		throw new ServletException(e);
	}
	String url ="Srv25_pokeStats.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}

}
