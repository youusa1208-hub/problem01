<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,beans.ItemBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv13_PtypeSel</title>
<style>
	h2{
		color:red;
	}
	th{
		background-color:silver;
		color:#0000ff;
	}
	table,th,td{
	border:3px solid black;
	}
</style>
</head>
<body>

	<h2>Ptypeテーブル</h2>
	<table border="1">
		<tr>
			<th>タイプID</th><th>タイプ名</th><th>画像ID</th><th>画像</th>
		</tr>
	<c:forEach items="${li}" var="dt">
		<%-- srv12aの場合、<c:forTokens>は不要 --%>
		<tr>
			<td><c:out value="${dt.ptid}"/></td>
			<td><c:out value="${dt.ptname}"/></td>
			<td><c:out value="${dt.ptimg}"/></td>
			<td>
                <img src="${dt.ptimg}" alt="画像" width="100" height="100"/>
            </td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>