<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv07_Stats4</title>
</head>
<body>

<%
	//転送先のページでも同じ属性名(s1)を設定
		String st = "BBB";
		pageContext.setAttribute("s1",st);
%>
	<%-- El式でs1を出力 --%>
	s1:${s1}<br>
	requestScope.s1:${requestScope.s1}<br>
	pageScope.s1:${pageScope.s1}<br>
	sessionScope.ss1:${sessionScope.ss1}<br>
	<a href="Srv07_Stats5.jsp">Srv07_Stats5</a><br>
</body>
</html>