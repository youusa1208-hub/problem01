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
<title>Ex02_jstl</title>
</head>
<body>

	値の設定<br>
		<c:set var="j1" value="ABC"/>
	値の出力<br>
		<c:out value="${j1}"/><br>
		
</body>
</html>