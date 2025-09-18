package test1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemBean;
/**
 * Servlet implementation class Srv11b_form
 */
@WebServlet("/Srv11b_form")
public class Srv11b_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv11b_form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ItemBean ib = new ItemBean();
      	ib.setName(request.getParameter("name"));
      	ib.setType(request.getParameter("type"));
      	String pricestr = request.getParameter("price");
      	int price = Integer.parseInt(pricestr);
      	ib.setPrice(price);
//      整数型に変換した結果をそのままsetterの引数に指定可能
      	String quantitystr = request.getParameter("quantity");
      	ib.setQuantity(Integer.parseInt(quantitystr));  
//      属性名を付与
      	request.setAttribute("ib1",ib);
//      	転送先の指定
      	String url = "Srv11b_fwd.jsp";
      	request.getRequestDispatcher(url).forward(request,response);
	}

}
