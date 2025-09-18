package db;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import beans.PokeBean;
import dao.PokeDao;

/**
 * Servlet implementation class Srv24_PokeSel
 */
@WebServlet("/Srv24_PokeSel")
public class Srv24_PokeSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv24_PokeSel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try(PokeDao pd = new PokeDao()){
			List<PokeBean> list = pd.select();
					
				request.setAttribute("li", list);
		}catch(Exception e){
			throw new ServletException(e);
		}
		String url="Srv24_PokeList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
