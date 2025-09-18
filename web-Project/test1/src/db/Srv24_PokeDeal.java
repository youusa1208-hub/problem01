package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.PokeBean;
import beans.PtypeBean;
import dao.PokeDao;
import dao.PtypeDao;
import java.util.*;

/**
 * Servlet implementation class Srv24_PokeDeal
 */
@WebServlet("/Srv24_PokeDeal")
public class Srv24_PokeDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv24_PokeDeal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//	削除対象一覧のために一覧データを取得
		try(PokeDao pd = new PokeDao()){
			List<PokeBean> list = pd.select();
			request.setAttribute("li", list);
//		削除の文字列と削除対象選択後の送信先に属性名を付与(type,send)
			request.setAttribute("type", "削除");
			request.setAttribute("send", "Srv24_PokeDeal");
			
		}catch(Exception e){
			throw new ServletException(e);
		}
		String url ="Srv24_PokeList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try(PokeDao pd = new PokeDao()){
			int pid = Integer.parseInt(request.getParameter("pid"));
			pd.delete(pid);
			
			List<PokeBean> list = pd.select();
			request.setAttribute("li", list);
		}catch(Exception e){
			throw new ServletException(e);
		}
		String url ="Srv24_PokeList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
