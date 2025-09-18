<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--pageディレクティブ
	ディレクティブの構文	<%@～～属性名="値"%>
	
	pageディレクティブではimport属性を使って、javaのライブラリのimportが可能
		<%@　page page ~ pageEncoding="UTF-8" import="java.util.*"%>	
		
		<%@　page import="java.util.*"%>
		import属性用に２つ目のpageディレクティブを記述してもよい
--%>
<%--
	スクリプト:JSP内のJavaプログラムの記述
		スクリプトレットの記述中で出力をする場合
		out.println(出力対象);と記述
--%>
<%!	//宣言部の記述
	int cnt = 0;

	//スクリプトレット内でメソッドを宣言しても、定義として扱われない
	//	→実施も出来ない
	String checkCnt(){
		String str = "";
		if(cnt < 5){
			str = "cntは5未満です";
		}else{
			str = "cntが5以上になりました！";
		}
		return str;
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Srv05_Jsp</title>
</head>
<body>
<%
	// cntを１つずつ追加
	cnt++;
	int cnt1 = 0;
	cnt1++;
%>
	現在のcntの値は<%=cnt %><br>
	現在のcnt1の値は<%=cnt1 %><br>
	<%=checkCnt() %><br>
	<%=10+20 %><br>
	<%="A"+"B" %><br>
	<%=10>cnt %><br>
	<h<%= cnt %>>見出し</h<%= cnt %>>
	<hr>
	<select>
		<option>リスト1</option>
		<option>リスト2</option>
		<option>リスト3</option>
		<option>リスト4</option>
	</select>
	<hr>
	<select>
	<%for(int i=1;i<5;i++){ %>
		<option>リスト<%=i %></option>
	<% } %>
	</select>
	<br>
	↓includeディレクティブの使用↓
	<%@ include file="Srv05_inc.jsp" %>
	↑includeディレクティブの使用→移動↑
	<table border="1">
		<tr>
			<td>AAA</td>
			<td>bbb</td>
		</tr>
	<!-- 繰り返す -->
	<!-- ↓　スクリプトレット内にはJavaと同じ処理を記述可能-->
<% 
	for(int i=0;i<3;i++){ 
%>
	<tr>
			<td>CCC</td>
			<td>DDD</td>
	</tr>
<% 
} 
%>
	</table>
	<h1>見出し</h1>
	<h2>見出し</h2>
<% 		for(int i=3;i<6;i++){ 
		out.println("<h"+i+">見出し</h"+i+">");
	}
%>
<%
	for(int i=0;i<5;i++){
		 if(i%2==0){
%>
		<img src="dog.jpg"><br>
<% 		}else{ 
%> 		
		<img src="img/dogg.jpg"><br> 
<%
		}
	}
%>
	

</body>
</html>