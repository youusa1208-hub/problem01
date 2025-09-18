package test1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Srv03_Param2
 */
@WebServlet("/Srv03_Param2")
public class Srv03_Param2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv03_Param2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		受信ページの文字化け対策
//		response.setContentType("text/html; charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		送信データを受け取る
		String t1 = request.getParameter("t1");
		String t2 = request.getParameter("t2");
		String cb1 = request.getParameter("cb1");
		String cb2 = request.getParameter("cb2");
		String r1 = request.getParameter("r1");
		String r2 = request.getParameter("r2");
		String sel1 = request.getParameter("sel1");
		String sel2 = request.getParameter("sel2");
		String ta1 = request.getParameter("ta1");
		String sub1 = request.getParameter("sub1");
		String sub2 = request.getParameter("sub2");
		PrintWriter out = response.getWriter();
		String html1 = "<!DOCTYPE html>"
					+"<html><head>"
					+"<meta Charset='utf-8'>"					
					+"<title>Srv03_Param2</title>"
					+"</head><body>"
					+"<table border='1'>";
		out.println(html1);
//		t1がnullではない、かつ0文字の文字列ではない場合
		if(t1!=null &&!t1.equals("")){
				out.println("<tr><td>t1</td><td>"+t1+"</td></tr>");
			}
//	t1以降の送信データの出力はメソッドにて実施
		disptbl(t2,"t2",out);
		disptbl(cb1,"cb1",out);
		disptbl(cb2,"cb2",out);
		disptbl(r1,"r1",out);
		disptbl(r2,"r2",out);
		disptbl(sel1,"sel1",out);
		disptbl(sel2,"sel2",out);
		disptbl(ta1,"ta1",out);
		disptbl(sub1,"sub1",out);
		disptbl(sub2,"sub2",out);
		
		out.println("</table>");
		out.println("</body></html>");
	}
		public void disptbl(String obj,String nm,PrintWriter out){
//			objがnullではない、かつobjが0文字の文字列ではない場合
//			if(obj!=null &&!obj.equals("")){
//				out.println("<tr><td>"+nm+"</td><td>"+obj+"</td></tr>");
//			}
			out.print("<tr><td>"+nm+"</td><td>");
//			objがnullの場合
			if(obj==null){
				out.print("NULL");
			}else if(obj.equals("")){ //objが0文字の文字列の場合
				out.println("0文字");
			}else{
				out.println(obj);
			}
			out.println("</tb></tr>");
			}
			}

