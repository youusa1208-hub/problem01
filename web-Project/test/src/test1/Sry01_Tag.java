package test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sry01_Tag
 */
@WebServlet("/Sry01_Tag")
public class Sry01_Tag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sry01_Tag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stu//		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		 HTMlタグの記述を追加
		 HTMLタグでは大文字/小文字は同じ扱いになる
		 ページの先頭に記述するたぐ<!DOCTYPE　html>
		 Webページの記述タグのバージョン指定になる（上記はHTML５）
		 
		 全体を囲むタグ<html></html>
		 Webページ内の設定のタグをまとめる<head></head>
		 Webページ内の設定の内容をまとめる<body></body>
		 <!DOCTYPE　html>
		 <html>
		 	<head></head>
		 	<body></body>
		 </html>
		 ***************************
		 <head>内のタグ
		 	<meta>ページ内の設定を記述
		 	<link>　ページに取り込むリソースの指定
		 	<title></title>　Webブラウザのタグに表示する見出し
		 	<style></style>ページ、タグのデザインを決める
				<head>内のタグの中でWebブラウザ上で
					内容を確認できるのは<title>　のみ
		 */
		//サーブレットで変換する際の文字コードを指定
		response.setCharacterEncoding("UTF-8");
		
		//PrintWriterはimport java.io.PrintWrter;の記述が必要
		//自動的にimportの追加をする方法→ctrl+shift+O
		PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE　html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>Srv01_Tag</title>");
			out.println("</head>");
		
		/*
			 	<BODY>内のタグ
			 	種類が多いため、一部抜粋
			 	表形式で表示
			 	<title></title>	表示式の内容全体を囲む
			 	<ｔｒ></tr>	行を囲むtable　Row
			 	<tb></tb>	セル（データ）を囲む（<tb>内に記述）table　data
			 	<ｔｈ></ｔｈ>	セル（見出し）を囲む<tb>内に記述）table　head
			 	<caption></caption>	表全体の見出しを囲む（<table>内き記述）
			 	
			 	【タグの記述と呼び方について】
			 	＜タグ名＞内容＜/タグ名＞	←～タグ
			 	　　　↑　　　　↑　　　　↑
			 	　開始タグ	↑  　　終了タグ
			 		　タグの内容
			 		
			 	<title>Srv01_Tag</title>←titleタグ
			 		↑　　　　　　↑　　　　　　　↑
	　　titleタグの開始開始タグ	　　	↑  　　　titleタグの終了タグ
			 		　　　　titleタグの内容
			 	***************************
			 table
			 	┣caption
			 	┣tr
			 	┃	┣th
			 	┃	┣th
			 	┃	┣・・・
			 	┣tr
			 	┃	┣td
			 	┃	┣td
			 	┃	┣・・・
			 	┣tr
			 	┣・・・
			 */
			//ワークスペースでテキストファイルエンコードの設定：
			//	ファイルを作成、保存時のファイルの文字コード設定
			//<meta charset='utf-8'>の設定
			//	Webブラウザで表示する際の文字コード設定
			//		↓これらを行ってサーブレットで文字化け
			//	Webサーバーで全角文字を変換する際の
			//		文字コード設定が更に必要
			//		↓
			//	PrintWriter out = response.getWriter();の前に
			//	response.setCharacterEncoding('UTF-8');が必要
			
	        // CSSを追加してcaptionを下に表示する
//	        out.println("<style>");
//	        out.println("caption { caption-side: bottom; font-weight: bold; }"); // captionを下部に表示
//	        out.println("</style>");
//
//	        out.println("</head>");
//	        out.println("<body>");
	        
			// out.println()の出力対象は文字列として変数に格納しても良い
			String tbl1 = "<table border='1'>"
		              + "<caption>tdタグでA,Bを囲む</caption>"
		              + "<tr><td>A</td><td>B</td></tr>"
		              + "<tr><td>CCC</td><td>DDD</td></tr>"
		              + "</table>";
			String tbl2 = "<table border='1'>"
		              //thタグは太字、中央揃えで表示する
		              + "<caption>thタグでA,Bを囲む</caption>"
		              + "<tr><th>A</th><th>B</th></tr>"
		              + "<tr><td>CCC</td><td>DDD</td></tr>"
		              + "</table>";
			out.println("<body>");
			out.println(tbl1);
			out.println(tbl2);
			/*
			 	リスト形式で表示
			 	<ol></ol>順序付きリストOrdered List
			 	<ul></ul>順不同リストUnOrdered List
			 	<li></li>　リスト項目（<ol>,<ul>の内容として記述）List
			 */
			String li1 = "<ol>"
		              + "<li>りんご</li>"
		              + "<li>みかん</li>"
		              + "<li>バナナ</li>"
		              + "</ol>";
			String li2 = "<ul>"
		              + "<li>りんご</li>"
		              + "<li>みかん</li>"
		              + "<li>バナナ</li>"
		              + "</ul>";	
			out.println(li1);
			out.println(li2);
			
			//文字列を段落にまとめる（段落の前後に空白行を表示）
			//＜ｐ＞＜/ｐ＞　Paragraph
			
			String p1 = "<p>"
		              + "ああああああああああああああああああああああああああああ1<br>"
		              + "ああああああああああああああああああああああああああああ1<br>"
		              + "ああああああああああああああああああああああああああああ1<br>"
		              + "ああああああああああああああああああああああああああああ1<br>"
		              + "ああああああああああああああああああああああああああああ1<br>"
		              + "ああああああああああああああああああああああああああああ1<br>"
		              + "ああああああああああああああああああああああああああああ1<br>"
		              + "ああああああああああああああああああああああああああああ1<br>"
		              + "</p>";
			String p2 = "<p>"
		              + "ああああああああああああああああああああああああああああ2<br>"
		              + "ああああああああああああああああああああああああああああ2<br>"
		              + "ああああああああああああああああああああああああああああ2<br>"
		              + "ああああああああああああああああああああああああああああ2<br>"
		              + "ああああああああああああああああああああああああああああ2<br>"
		              + "ああああああああああああああああああああああああああああ2<br>"
		              + "ああああああああああああああああああああああああああああ2<br>"
		              + "ああああああああああああああああああああああああああああ2<br>"
		              + "</p>";
			out.println(p1);
			out.println(p2);
			
			/*
			 	内容を見出しとして扱う
			 	<h1></h1>,<h2></h2>,・・・<h6></h6>Header1
			 */
			
			String hd = "<h1>見出し1</h1>,<h2>見出し2</h2>"
					+ "<h3>見出し3</h3>,<h4>見出し4</h4>"
					+ "<h5>見出し5</h5>,<h6>見出し6</h6>";
			out.println(hd);

			/*
			  リンクを設定する
			  <a></a>内容をクリックすると他のページやサイトに遷移できるリンクを設定
			  Anchor:錨（いかり）遷移先はhref属性に設定
			 */
			
			String link = "<a href='HelloServlet'>リンク文字列</a>"
						+"<br>"
						+"<a href='https://www.youtube.com/'>youtube</a>";
			out.println(link);
			//String img ="<br><img src ='Image20250107174915.jpg'>";
//			String img = "<br><img src='file:///C:/202501java/back2/dog.jpg'>";
//			out.println(img);
			
			/*
			 　画像を表示する
			 	<img> src属性で表示画像を指定
			 		（絶対パス/相対パスのどちらでも指定可）　IMaGe
			 		
			 	ファイル名のみ指定した場合、同じファルダにある画像を表示
			 			↓
			 	test/src/test1/Srv01_Tag サーブレット
			 	WebContent/Image20250107174915.jpg  表示画像
			 	
			 	フォルダが異なるが、同じフォルダに格納されている扱いになっている
			 	
			 	表示画像が以下の位置にある場合
			 	WebContent/img/Image20250107174915.jpg
			 		src属性に設定する値は'img/WebContent/Image20250107174915.jpg'になる			 
			 			↑
			 		imgファルダがSrv01_Tagと同じフォルダに格納されている扱い
			 		　その中にあるファルダは「/」の後に記述する
			 	～～～～～～ここまで相対パスの説明～～～～～～～～～～～
			 	
			 */
			out.println("<br>");
			String img1 ="<br><img src ='dog.jpg'>";
			out.println(img1);
			
			out.println("<br>");
			String img2 ="<br><img src ='img/dogg.jpg'>";
			out.println(img2);
			
					
					/*
			 　絶対パスについて
			 	表示するサーブレットファイルの位置に関係なく
			 	表示対象の画像ファイルがどこに存在するかを指定する方式
			 	今回のdog.jpgの場合
			 		ｈｔｔｐ://localhost:8080/test/dog.jpg
			 		dogg.jpgの場合
			 		ｈｔｔｐ://localhost:8080/test/img/dog.jpg
			 
			 どのWebサーバーのどのファルダに格納されているか、という情報を全てsrc属性の値として設定する
			 　　	→パスが長くなりやすいが、サーブレットなどの格納場所が変更されても、パスの変更が不要
			 
			 */
			
			String img3 = "<br><img src ='data:image/jpeg;base64,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'>";
			out.println("<br>");
			out.println(img3);
			
			
//			 体裁を整える
//			 <hr>　　水平線を表示HoRizontal（水平）　　ホライゾン
//			 		垂直（Vertical）にかんするタグは存在しない
			out.println("<hr>");
			out.println("<br>水平線<br>");
//			<br>	記述位置で改行BReak
//			********hr,brは開始タグのみ********
			
//			<div></div>主に修飾目的で使用する
//						他のタグをまとめるDivide
			String div = "<div>"+p1+"</div>";
			out.println(div);
			out.println(p1);
			
//			divのように、内容を囲むだけのタグ
//			<span></span>主に修飾目的で使用する
//						他のタグや1行分の内容をまとめる
//			<div>や<span>は修飾目的で使用
//				修飾方式→CSS,<style>で指定
			
//			ページの内容をまとめる
//			<main></main>	ページ内の主要な内容をまとめる
//			<header></header>	ページ上部の内容(見出し、ロゴ、メニュー)
//			<footer></footer>	ページ下部の内容(グループ企業リンク、企業理念、サイト責任者ページ)
//			<aside></aside>		ページ内の補助内容をまとめる（カテゴリ表示など）
//			<menu></menu>	メニュー項目をまとめる
//			まとめるタグの目的について
//			→囲んでも<h1><p>のように表示形式の変化はない
//			→インターネットの色々なページの情報を収集して回るプログラムが存在する
//				（クロウラーWebクロウラー(crowler)）
//			→クロウラーの情報収集時に有効なのがまとめるタグ
			
//				～～～～～以下は記述不要～～～～～～
//				まとめるタグの目的:SEO(Search Engine Optimization)
//					クロウラーが収集した情報はGoogle等の検索結果に利用される
//					→検索結果の上位に表示するために必要な内容
//						・ページ内に適切な語句を複数記述
//						・被リンク数の増加/質の向上
//						・リンク数の増加
//						・<meta>タグによる検索語句の指定など
//				SEOを行うことで検索結果の上位に表示される
//				→その効果は
//					・販売サイトの場合、集客力が上がる→売上が上がる
//					・販売サイトではない場合も、公告を設置することで
//						広告収入を得ることが可能(PPV:Pay Per View)
//					・告知サイトの場合、告知が多くの人間に知れ渡ることで
//						広く知ってもらうことが可能
			
//			クライアント（ユーザー）が操作/入力可能なタグ
			/*
			 <form></form>以下の入力要素をまとめる
			 <input>	入力欄、type属性の値によって色々な入力方式に変更
			 <select></select>	ドロップダウンリスト
			 <option></option>	リスト項目（<select>内に記述）
			 <button></button>	クリック可能なボタンを表示
			 <textarea></textarea>	 文字列の入力欄（複数行入力可）
			 			
			 */
			
			/*
			 <input type='submit'>の役割
			 	入力したデータを送信する→どこに？
			 	<form action='送信先'>←action属性の設定場所に送信
			 */
			String form1 = "<form>"
				+ "text:<input type='text'><br>"
				+ "checkbox:<input type='checkbox'><br>"
				+ "radio:<input type='radio'name='r1'>"
				+ "<input type='radio'name='r1'>"
				+ "<input type='radio'name='r1'>"
				+ "<input type='radio'name='r2'>"
				+ "<input type='radio'name='r2'><br>"
				+ "password:<input type='password'><br>"
				+ "button:<input type='button'value='ボタン'><br>"
				+ "reset:<input type='reset'><br>"
				+ "submit:<input type='submit'><br>"
				+ "</form>";
			String sel = "<select>"
				+ "<option>項目1</option>"
				+ "<option>項目1</option>"
				+ "<option>項目1</option>"
				+ "</select>";
			String tarea = "<textarea cols='30' rows='6'>"
						+ "</textarea>";
			String form2 = "<form>"
						+ sel
						+ tarea
						+ "</form>";
			out.println(form1);
			out.println(form2);
			
//			<head><body>	どちらにも記述可能なタグ
//			<script></script>	ＪａｖａScriptの処理を記述
//								ＪＳファイルの読み込み
					
			
			out.println("</body></html>");		
	}
}
