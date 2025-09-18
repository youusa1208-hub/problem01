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
<title>Insert title here</title>
</head>
<body>

<%
    String sc1 = "ファイルでスクリプトレットを利用して!";
	pageContext.setAttribute("sc1", sc1);
%>

<p>sc1の値: <c:out value="${sc1}" /></p>


</body>
</html>