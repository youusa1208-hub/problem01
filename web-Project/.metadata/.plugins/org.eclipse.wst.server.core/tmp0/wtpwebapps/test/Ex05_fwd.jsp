<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, beans.PersonBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ex05_fwd</title>
</head>
<%!
	//転送されたJavaBeansを格納/保持するためのListコレクションを宣言
	List<PersonBean> list = new ArrayList<>();
%>
<body>
<%
	//転送されたJavaBeansを取得
	//データ型　変数名＝(データ)request.getAttribute(属性名)
	//				~~~~強制型変換を行っている
	//				Object型→ItemBean型
	PersonBean pb = (PersonBean)request.getAttribute("pb1");
	//Listコレクション追加	
	list.add(pb);
	//属性名を付与
	pageContext.setAttribute("li",list);
	//
%>
    <table border="1">
        <tr>
            <th>名前</th>
            <th>住所</th>
            <th>電話番号</th>
            <th>血液型</th>
            <th>職業</th>
        </tr>
        <!-- リストのデータをループで表示 -->
        <c:forEach items="${li}" var="pb1">
            <tr>
                <td><c:out value="${pb1.name}"/></td>
                <td><c:out value="${pb1.addr}"/></td>
                <td><c:out value="${pb1.tel}"/></td>
                <td><c:out value="${pb1.bld}"/></td>
                <td><c:out value="${pb1.job}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
