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
<title>Srv12_DeptSel</title>
</head>
<body>

<h2>Deptテーブル</h2>
<table border="1">
		<tr>
			<th>部署電話</th><th>部署名</th><th>所在地</th>
		</tr>
	<c:forEach items ="${li}" var="dt">
		<tr>
	<c:forTokens items="${dt}" delims=":" var="d">
		<td><c:out value="${d}"/>
	</c:forTokens>
		</tr>
	</c:forEach>
</table>
</body>
</html>