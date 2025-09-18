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
 * Servlet implementation class Srv22_PtypeUpd1
 */
@WebServlet("/Srv22_PtypeUpd1")
public class Srv22_PtypeUpd1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv22_PtypeUpd1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//	送信データをJavaBeansのインスタンスに格納
	PtypeBean pb = new PtypeBean();
	pb.setPtid(Integer.parseInt(request.getParameter("ptid")));
	pb.setPtname(request.getParameter("ptname"));
	pb.setPtimg(request.getParameter("ptimg"));
//	DBの処理のためにPtypeDaoのメソッドを実行
	try(PtypeDao pd = new PtypeDao()){
		pd.update(pb);
		
		List<PtypeBean> list = pd.select();
		request.setAttribute("li", list);
	}catch(Exception e){
		throw new ServletException(e);
	}
	String url = "Srv22_PtypeList.jsp";
	request.getRequestDispatcher(url).forward(request, response);
	}

	}

