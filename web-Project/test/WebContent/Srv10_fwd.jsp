<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv10_fwd</title>
</head>
<body>
	<%-- 転送データもtableに出力 --%>
	<table border="1">
		<tr>
			<th>名前</th>
			<td><c:out value="${param.name}"/></td>
		</tr>
		<tr>
			<th>住所</th>
			<td><c:out value="${param.adrr}"/></td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td><c:out value="${param.tel}"/></td>
		</tr>	
		<tr>
			<th>血液型</th>
			<td><c:out value="${bd}"/></td>
		</tr>
		<tr>
			<th>職業</th>
			<td><c:out value="${param.job}"/></td>
		</tr>
	</table>
</body>
</html>