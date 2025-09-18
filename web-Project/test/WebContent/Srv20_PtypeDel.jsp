<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv20_PtypeDel</title>
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

<h2>削除するタイプIDを入力(選択)</h2>
<form action="Srv20_PtypeDel" method="post">
<table>
	<tr>
		<th>タイプID</th><th>タイプ名</th><th>画像</th>
	</tr>
	<c:forEach items="${li}" var="dt">
	<tr>
		<td><c:out value="${dt.ptid}"/></td>
		<td><c:out value="${dt.ptname}"/></td>
		<td><img src="${dt.ptimg}"/></td>
	</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<th>タイプID</th>
		<td><input type="text" name="ptid"></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="送信">
		</td>
	</tr>
</table>
</form>
<hr>
<form action="Srv20_PtypeDel" method="POST">
<table>
	<tr>
		<th>タイプID</th><th>タイプ名</th><th>画像</th><th>選択</th>
	</tr>
<c:forEach items="${li}" var="dt">
	<tr>
		<td><c:out value="${dt.ptid}"/></td>
		<td><c:out value="${dt.ptname}]"/></td>
		<td><img src="${dt.ptimg}"/></td>
		<td>
			<input type="radio" name="ptid" value="${dt.ptid}">
		</td>
	</tr>
</c:forEach>
	<tr>
		<%-- 上のtr内にtdが4つあるため、colspan="4" --%>
		<td colspan="4" align="right">
			<input type="submit" value="送信">
		</td>
	</tr>
</table>
</form>
<hr>
<form action="Srv20_PtypeDel" method="POST">
<table>
	<tr>
		<th>タイプID</th>
		<td>
			<select name="ptid">
				<c:forEach items="${li}" var="dt">
                     <option value="${dt.ptid}">
						<c:out value="${dt.ptid} + ':' + ${dt.ptname}"/>
                     </option>
				</c:forEach>
			</select>
	</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		<input type="submit" value="送信">
		</td>
	</tr>
</table>
</form>

</body>
</html>