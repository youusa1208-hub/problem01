package test1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Srv10_form
 */
@WebServlet("/Srv10_form")
public class Srv10_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv10_form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//送信データを受け取り、加工後属性名を付与して転送
		String bld = request.getParameter("bld");
		//血液型が「不明」以外の場合	
			if(!bld.equals("不明")){
				//「型」を後ろにつける
				bld+="型";
			}
		//加工後、属性名を付与
		request.setAttribute("bd", bld);
		//転送先の指定
		String url ="Srv10_fwd.jsp";
		//転送処理
		request.getRequestDispatcher(url).forward(request,response);
	}

}
