<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv11_fwd</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<th>名前</th>
			<%-- <td><c:out value="${nm}"/></td> --%>
			<%-- ${属性名.JaveBeansのフィールド名}の形式で記述 --%>
			<%-- JavaBeans内にgetterの定義がないと${属性名.フィールド名}の記述がエラーになる --%>
			<td><c:out value="${pb1.name}"/></td>
		</tr>
		<tr>
			<th>住所</th>
			<%--<td><c:out value="${adrr}"/></td>--%>
			<td><c:out value="${pb1.addr}"/></td>
		</tr>
		<tr>
			<th>電話番号</th>
			<%--<td><c:out value="${tel}"/></td>--%>
			<td><c:out value="${pb1.tel}"/></td>
		</tr>	
		<tr>
			<th>血液型</th>
			<%--<td><c:out value="${bd}"/></td>--%>
			<td><c:out value="${pb1.bld}"/></td>
		</tr>
		<tr>
			<th>職業</th>
			<%--<td><c:out value="${jb}"/></td>--%>
			<td><c:out value="${pb1.job}"/></td>
		</tr>
	</table>

</body>
</html>