<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv21_ptyoeUpd</title>
<style>
	table,th,td{
		border:1px solid black;
	}
	table{
		border-collapse:collapse;
	}
	th{
		background-color:silver;
	}
	img{
		height:60px;
	}
</style>
</head>
<body>

	<h2>更新対象のタイプidを選択</h2>
	<form action="Srv21_PtypeUpd">
	<table>
		<tr>
			<th>タイプID</th><th>タイプ名</th><th>画像</th><th>選択</th>
		</tr>
	<c:forEach items="${li}" var="dt">
	<tr>
		<td><c:out value="${dt.ptid}"/></td>
		<td><c:out value="${dt.ptname}"/></td>
		<td><img src="${dt.ptimg}"/></td>
		<td>
			<input type="radio" name="ptid" value="${dt.ptid}">
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