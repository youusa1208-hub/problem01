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
<title>Srv11b_fwd</title>
</head>
	
<%!
	//転送されたJavaBeansを格納/保持するためのListコレクションを宣言
	List<ItemBean> list = new ArrayList<>();
%>
<body>
	<fmt:setLocale value="ja_JP" />
<%
	//転送されたJavaBeansを取得
	//データ型　変数名＝(データ)request.getAttribute(属性名)
	//				~~~~強制型変換を行っている
	//				Object型→ItemBean型
	ItemBean ib = (ItemBean)request.getAttribute("ib1");
	//Listコレクション追加	
	list.add(ib);
	//属性名を付与
	pageContext.setAttribute("li",list);
	//
%>

	<h1>商品情報一覧</h1>
	<table border="1">
		<tr>
			<th>商品名</th><th>商品種別</th>
			<th>価格</th><th>内容量</th>
		</tr>
	<c:forEach items="${li}" var="dt">
		<tr>
			<td><c:out value="${dt.name}"/>
			<td><c:out value="${dt.type}"/>
			<td><fmt:formatNumber type="CURRENCY" value="${dt.price}"/>
			<td><fmt:formatNumber value="${dt.quantity}"/>
		</tr>
	</c:forEach>
	</table>
</body>
</html>