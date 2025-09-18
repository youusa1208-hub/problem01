package test1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Srv02_Param
 */
@WebServlet("/Srv02_Param")
public class Srv02_Param extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv02_Param() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stu		response.getWriter().append("Served at: ").append(request.getContextPath());
//		表示ページの文字化け対策
		response.setCharacterEncoding("UTF-8");
//		受信ページの文字化け対策
//		全角データをPOST送信した場合にのみ文字化けが発生
//		request.getParameter()やrequest.getParameterValues()の前に行う
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
	/*
	 	送信データを取得する方式について
	 	送信データを取得する際に必要な名前:name属性に設定
	 		name属性→<input type='～'name='～'>
	 		name='設定値'		→設定値==名前
	 	
	 	送信データ==クエリ文字列と呼ばれる
	 	http://localhost:8080/test/Srv02_param?p1=入力値＆p2=入力値
	 											～～～～～～～～～～
	 											クエリ文字列
		送信データを受け取る処理
		request.getParameter("送信名")
		例:<nput type="text" name="pp">	で送信したデータを受け取る際
			String val =request.getParameter("pp")
			
	 */
		String p1 = request.getParameter("p1");
//		データは複数送信可能
		String[] arr = request.getParameterValues("p2");
//		複数送信したデータをgetParameter（）で受け取った場合
		String p2 = request.getParameter("p2");
		
		/*
		 データの送信方法について
		 1.Get（初期値） :送信データをクエリ文字列に追加
		 2.POSｔ		 :送信データをクエリ文字列に追加しない
		 送信方法の指定は<form method="送信方法">で行う
		 
		 */
		String form = "<form action='Srv02_Param' method='POST'>"
				+ "p1:<input tyoe='text'name='p1'><br>"
				+ "p2_a:<input tyoe='text'name='p2'><br>"
				+ "p2_b:<input tyoe='text'name='p2'><br>"
				+ "p2_c:<input tyoe='text'name='p2'><br>"
				+ "<input type='submit' value='送信'>"
				+ "</form>";
		
		String html1 ="<!DOCTYPE html>"
				+ "<html><head>"
				+ "<meta charset='utf-8'>"
				+ "<title>Srv02_Param</title>"
				+ "</head><body>";
		String html2 ="</body></html>";
		
		out.print(html1);
		out.println(form);
//		送信データの出力
//		nullの場合は出力しない(nullではない場合に出力する)
		if(p1!=null){
			out.println("p1:"+p1);
			out.println("<br>");
			for(String dt:arr){
				out.print(dt+" ");
			}
			out.println("<br>");
			out.println("p2:"+p2+"<br>");
		}
		out.println(html2);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
