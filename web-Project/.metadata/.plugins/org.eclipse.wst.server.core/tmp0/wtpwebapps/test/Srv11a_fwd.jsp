<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv11a_fwd</title>
</head>
<body>

	<h1>商品情報</h1>
		<table border="1">
		<tr>
			<th>商品名</th>
			<td><c:out value="${ib1.name}"/></td>
		</tr>
		<tr>
			<th>商品種別</th>
			<td><c:out value="${ib1.type}"/></td>
		</tr>
		<tr>
			<th>価格</th>
			<td><fmt:formatNumber type="currency" value="${ib1.price}"/></td> 
		</tr>	
		<tr>
			<th>内容量</th>
			<td><fmt:formatNumber value="${ib1.quantity}"/></td>
		</tr>
	</table>
</body>
</html>