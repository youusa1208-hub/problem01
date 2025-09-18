<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv07_Stats2</title>
</head>
<body>
<%
	//転送された属性名を取得
	String adds = (String)request.getAttribute("addstr");
	if(adds!=null){
%>
	adds:<%=adds %><br>
<% } %>
<% 
	//送信されたデータを取得
	String sendp1 = request.getParameter("p1");
	//属性名を付与
	pageContext.setAttribute("sp1",sendp1);
%>	
	取得した送信データに属性名を付与し、出力<br>
	sp1:${sp1}<br><br>
	転送前のJSPで付与した属性名を指定<br>
	addstr:${addstr}<br>
<hr>
	送信データをそのまま受け取る<br>
	param.p1:${param.p1}<br>
	Srv07_Stars.jspで属性名を付与した値はparam.属性名で取得できるか確認<br>
	param.addstr:${param.addstr}<br>	
<hr>
<%
	//Srv07_Stars.jspで属性名付与、転送した場合は
	//getParameter()で取得できるか確認
	String addstr = request.getParameter("addstr");
	pageContext.setAttribute("addst",addstr);
%>
	addst:${addst}<br>
</body>
</html>