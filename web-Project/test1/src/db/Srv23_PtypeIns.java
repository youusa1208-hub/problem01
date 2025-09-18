package db;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.PtypeBean;
import dao.PtypeDao;

/**
 * Servlet implementation class Srv23_PtypeIns
 */
@WebServlet("/Srv23_PtypeIns")
public class Srv23_PtypeIns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv23_PtypeIns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try(PtypeDao pd = new PtypeDao()){
		PtypeBean pb = new PtypeBean();
		pb.setPtname(request.getParameter("ptname"));
		pb.setPtimg(request.getParameter("ptimg"));
		pd.insert(pb);
		
		List<PtypeBean> list = pd.select();
		request.setAttribute("li", list);
		
	}catch(Exception e){
		throw new ServletException(e);
	}
//	転送先の指定
	String url = "Srv23_PtypeList.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}

}
