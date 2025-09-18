package db;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.util.*;
import beans.PtypeBean;

/**
 * Servlet implementation class Srv22_PtypeUpd
 */
@WebServlet("/Srv22_PtypeUpd")
public class Srv22_PtypeUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv22_PtypeUpd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PtypeDao pd = new PtypeDao()){
			List<PtypeBean> list = pd.select();
			request.setAttribute("li", list);
		}catch(Exception e){
			throw new ServletException(e);
		}
		String url = "Srv22_PtypeUpd.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//	1レコード分を取得し、転送
//	(更新処理はSrv22_PtypeUpd1で行う)
	try(PtypeDao pd = new PtypeDao()){	
		int ptid = Integer.parseInt(request.getParameter("ptid"));
		PtypeBean pb = pd.select(ptid);
		request.setAttribute("pb", pb);
	}catch(Exception e){
		throw new ServletException(e);
	}
	String url = "Srv22_PtypeUpd1.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}
}
