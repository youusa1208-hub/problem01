<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv07_Stats3</title>
</head>
<body>
<%
	//転送するデータを格納する変数を宣言
	String str = "AAAA";
	//転送するために属性名を付与
	request.setAttribute("s1",str);
	//　セッション情報を格納
	session.setAttribute("ss1",str);
%>
	<%-- アクションタグで転送 --%>
	<jsp:forward page="Srv07_Stats4.jsp"/>
	
</body>
</html>