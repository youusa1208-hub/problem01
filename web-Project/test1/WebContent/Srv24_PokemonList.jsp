<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<table>
		<tr>
			<th>ポケモンid</th><th>ポケモン名</th><th>画像</th>
			<th>ptid</th><th>タイプid</th><th>タイプ名</th><th>画像</th>
		</tr>
		<c:forEach items="${li}" var="dt">
			<tr>
				<c:forTokens items="${dt}" delims=":" var="d">
					<td><c:out value="${d}" /></td>
				</c:forTokens>
			</tr>
		</c:forEach>
	</table>

</body>
</html>