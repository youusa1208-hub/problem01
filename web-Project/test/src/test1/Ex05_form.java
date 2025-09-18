package test1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex05_form
 */
@WebServlet("/Ex05_form")
public class Ex05_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex05_form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 送信データを受け取った後、加工
	    String fnm = request.getParameter("fname");
	    String pnm = request.getParameter("pname");
	    String addr1 = request.getParameter("addr1");
	    String addr2 = request.getParameter("addr2");
	    String tel = request.getParameter("tel");
	    String bld = request.getParameter("bld");
	    String job = request.getParameter("job");

	    // PersonBeanのインスタンスを生成
	    beans.PersonBean pb = new beans.PersonBean();
	    
	    // setterで値を設定
	    pb.setName(fnm + pnm);  
	    pb.setAddr(addr1 + addr2);  
	    pb.setTel(tel);  
	    pb.setBld(bld);  
	    pb.setJob(job);  
	    
	    // データの確認(加工)
	    pb.checkDate(); 
	    
	    // JavaBeansインスタンスに対して属性名を付与
	    // 転送先で受け取れるようにする
	    request.setAttribute("pb1", pb);

	    // 転送先の指定
	    String url = "Ex05_fwd.jsp";
	    
	    // 転送処理
	    request.getRequestDispatcher(url).forward(request, response);
		
	}

}
