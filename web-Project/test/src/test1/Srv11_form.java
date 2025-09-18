package test1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Srv11_form
 */
@WebServlet("/Srv11_form")
public class Srv11_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv11_form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//送信データを受け取った後、加工
		String fnm = request.getParameter("fname");
		String pnm = request.getParameter("pname");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String tel = request.getParameter("tel");
		String bld = request.getParameter("bld");
		String job = request.getParameter("job");
//	//名前
//		request.setAttribute("nm", fnm+pnm);
//	//住所
//		request.setAttribute("adrr", addr1+addr2);
//	//電話番号(「-」は取り除く)
//		String t = tel.replace("-","");
//		request.setAttribute("tel", t);
//	//血液型
//		if(!bld.equals("不明")){
//			//「型」を後ろにつける
//			bld+="型";
//		}
//	//職業
//		if(!bld.equals("バイト")){
//			job="パート";
//		}
//		request.setAttribute("bd", bld);
//		request.setAttribute("jb", job);
		
//		PersonBeanのインスタンスを生成
		beans.PersonBean pb = new beans.PersonBean();
//		setterで値を設定
		pb.setName(fnm+pnm);
		pb.setAddr(addr1+addr2);
		pb.setTel(tel);
		pb.setBld(bld);
		pb.setJob(job);
//		データの確認(加工)
		pb.checkDate();
//		JavaBeans()インスタンスに対して属性名を付与
//		転送先で受け取れるようにする
		request.setAttribute("pb1", pb);
		
		
		//転送先の指定
		String url ="Srv11_fwd.jsp";
				//転送処理
		request.getRequestDispatcher(url).forward(request,response);
	}

}
