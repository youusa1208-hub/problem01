<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv22_PtypeUpd</title>
</head>
<link rel="stylesheet" href="style.css">
<body>

	<h2>更新対象のタイプidを選択</h2>
	<form action="Srv22_PtypeUpd" method="POST">
	<table>
		<tr>
			<th>タイプID</th><th>タイプ名</th><th>画像</th><th>選択</th>
		</tr>
	<c:forEach items="${li}" var="pb">
	<tr>
		<td><c:out value="${pb.ptid}"/></td>
		<td><c:out value="${pb.ptname}"/></td>
		<td><img src="${pb.ptimg}"/></td>
		<td>
			<input type="radio" name="ptid" value="${pb.ptid}">
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="4" align="right">
			<input type="submit" value="送信">
		</td>
	</tr>
	</table>
	</form>

</body>
</html>