<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv24_pokeList</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="Srv24_PokeMenu.jsp"/>
<%-- typeが転送された場合 --%>
<c:if test="${!empty type}">
	<h2>${type}対象を選択</h2>
	<form action="${send}" method="POST">
</c:if>
<table>
	<tr>
		<th>ポケモンID</th><th>ポケモン名</th><th>画像</th>
		<th>タイプID</th><th>タイプ名</th><th>タイプ画像</th>
	<c:if test="${!empty type}">
		<th>選択</th>
	</c:if>	
	</tr>
	<c:forEach items="${li}" var="dt">
	<tr>
		<td><c:out value="${dt.pid}"/></td>
		<td><c:out value="${dt.pname}"/></td>
		<td><img src="${dt.pimg}" class="icon"/></td>
		<td><c:out value="${dt.ptid}"/></td>
		<td><c:out value="${dt.ptname}"/></td>
		<td><img src="${dt.ptimg}" class="icon"/></td>
	<c:if test="${!empty type}">
		<td><input type="radio" name="pid" value="${dt.pid}"></td>
	</c:if>
	</tr>
	</c:forEach>
	<c:if test="${!empty type}">
	<tr>
		<td colspan="7" align="right">
			<input type="submit" value="送信">
		</td>
	</tr>
	</c:if>
</table>
<c:if test="${!empty type}">
    </form>
</c:if>

</body>
</html>