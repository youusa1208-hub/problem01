package test1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemBean;
/**
 * Servlet implementation class Srv11a_form
 */
@WebServlet("/Srv11a_form")
public class Srv11a_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv11a_form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    formから送信されたデータを格納するためにItemBeanのインスタンスを生成
    	ItemBean ib = new ItemBean();
//    setterで値を設定
    	ib.setName(request.getParameter("name"));
    	ib.setType(request.getParameter("type"));
//    request.getParameter()の戻り値の型はStringなので
//    int型の引数にするために、整数値変換を行う
//    	request.getParameter()の戻り値の型はStringなので
//    	int型の引数にするために、整数値変換を行う
//    	浮動小数点数:0.111 15.2→double型
//    	Double.parseDouble(s)
    	String pricestr = request.getParameter("price");
    	int price = Integer.parseInt(pricestr);
    	ib.setPrice(price);
    	String quantitystr = request.getParameter("quantity");
    	int quantity = Integer.parseInt(quantitystr);  

    	ib.setQuantity(quantity);
//    	ItemBeanのインスタンスに属性名を付与
    	request.setAttribute("ib1",ib);
//    	転送先の指定
    	String url = "Srv11a_fwd.jsp";
    	request.getRequestDispatcher(url).forward(request,response);
	}

}
