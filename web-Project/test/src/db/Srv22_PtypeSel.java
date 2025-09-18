package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import beans.PtypeBean;

/**
 * Servlet implementation class Srv22_PtypeSel
 */
@WebServlet("/Srv22_PtypeSel")
public class Srv22_PtypeSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv22_PtypeSel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//	PtypeDaoのインスタンスを生成
	try(PtypeDao pb = new PtypeDao()){
		List<PtypeBean> list = pb.select();
		request.setAttribute("li", list);
	}catch(Exception e){
		throw new ServletException(e);
	}
	String url = "Srv22_PtypeList.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}

}
