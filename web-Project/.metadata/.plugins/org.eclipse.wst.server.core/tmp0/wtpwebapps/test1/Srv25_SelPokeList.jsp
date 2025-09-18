<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv25_SelPokeList</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

${pm.pmname}さんログイン中<br><br>
ゲットするポケモンを選択してください。<br>
<form action="Srv25_SelPokeList" method="POST">
    <table>
        <thead>
            <tr>
                <th>ポケモン名</th>
                <th>画像</th>
                <th>タイプ名</th>
                <th>タイプ画像</th>
                <th>選択</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${li}" var="dt">
                <tr>
                    <td><c:out value="${dt.pname}"/></td>
                    <td><img src="${dt.pimg}" class="icon" alt="ポケモン画像"/></td>
                    <td><c:out value="${dt.ptname}"/></td>
                    <td><img src="${dt.ptimg}" class="icon" alt="タイプ画像"/></td>
                    <td><input type="radio" name="pid" value="${dt.pid}"></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" align="right">
                    <input type="submit" value="送信">
                </td>
            </tr>
        </tbody>
    </table>
</form>
<br>
<form action="Srv25_PmLogin">
	<input type="hidden" name="logout" value="out">
	<input type="submit" value="ログアウト">
</form><br>
<a href="Srv25_PmLogin.jsp">ログイン画面に戻る</a><br>

</body>
</html>