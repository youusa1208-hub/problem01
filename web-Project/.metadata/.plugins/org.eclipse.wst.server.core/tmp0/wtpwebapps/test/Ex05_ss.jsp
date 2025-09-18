<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Ex05_ss</title>
</head>
<body>

	<p>送信されたデータ: <c:out value="${param.s1}" /></p>

	<hr>

		<c:set var="j1" value="ABC"/>
	値の出力:<c:out value="${j1}"/><br>
		
	<hr>
	
	<p>出力する文字列: <c:out value="JSPファイルで文字列を出力！" /></p>
	<hr>
	
	<%
    String sc1 = "ファイルでスクリプトレットを利用して!";
	pageContext.setAttribute("sc1", sc1);
	%>

	<p>sc1の値: <c:out value="${sc1}" /></p>
	
	<hr><br>
	
	



</body>
</html>