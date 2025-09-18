<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv12a_DeptSel</title>
</head>
<body>

	<h2>Deptテーブル</h2>
	<table border="1">
		<tr>
			<th>部署電話</th><th>部署名</th><th>所在地</th>
		</tr>
	<c:forEach items="${li}" var="dt">
		<%-- srv12aの場合、<c:forTokens>は不要 --%>
		<tr>
			<td><c:out value="${dt.deptno}"/>
			<td><c:out value="${dt.dname}"/>
			<td><c:out value="${dt.loc}"/>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>