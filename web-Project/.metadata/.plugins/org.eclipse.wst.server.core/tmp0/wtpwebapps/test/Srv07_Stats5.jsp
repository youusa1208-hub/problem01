<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv07_Stats5</title>
</head>
<body>

	<%--　requestScopeは保持されないことを確認　 --%>
	requestScope.s1:${requestScope.s1}<br>
	<%--　requestScopeは保持されることを確認	　--%>
	sessionScope.ss1:${sessionScope.ss1}<br>
	
</body>
</html>