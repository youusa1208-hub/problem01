package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import beans.PtypeBean;
import dao.PtypeDao;

/**
 * Servlet implementation class Srv23_PtypeSel
 */
@WebServlet("/Srv23_PtypeSel")
public class Srv23_PtypeSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv23_PtypeSel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try(PtypeDao pb = new PtypeDao()){
		List<PtypeBean> list = pb.select();
		request.setAttribute("li", list);
	}catch(Exception e){
		throw new ServletException(e);
	}
	String url = "Srv23_PtypeList.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}

}
