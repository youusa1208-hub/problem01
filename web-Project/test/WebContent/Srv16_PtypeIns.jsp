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
<title>Srv16_PtypeIns</title>
<style>

	table,th,td{
		border:1px solid blacl;
	}
	table{
		/* 境界線をくっつける */
		border-collapse:collapse;
	}
	th{
		background-color:gold;
	}
	
</style>
</head>
<body>

<table>
	<tr>
		<th>タイプID</th><th>タイプ名</th><th>画像</th>
	</tr>
	<c:forEach items="${li}" var="dt">
		<%-- srv12aの場合、<c:forTokens>は不要 --%>
		<tr>
			<td><c:out value="${dt.ptid}"/></td>
			<td><c:out value="${dt.ptname}"/></td>
			<td><img src="${dt.ptimg}"/></td>
		</tr>
	</c:forEach>
</table>
	
</body>
</html>