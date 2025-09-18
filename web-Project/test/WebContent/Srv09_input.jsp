<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv09_input</title>
</head>
<%!
	//宣言部に変数を定義→リロード/送信しても値を保持
	String user = "";
	String pass = "";
	//メソッドの定義
	//両方一致した場合→true,それ以外→false
	boolean check(String u,String p){
		//宣言部の変数が0文字の文字列
		//または引数のユーザー名(u)が0文字の文字例(未送信)ならば一致と見なさない
		if(user.equals("")||u.equals("")){
			return false;
		}
		//ユーザー名は大文字小文字を問わず判定
		//パスワードは厳密に判定
		if(user.equalsIgnoreCase(u)&& pass.equals(p)){
			return true;
		}
		return false;
	}
%>
<%
	//送信データを受け取る
	String u = request.getParameter("user");
	String p = request.getParameter("pass");
%>

<body>

<c:choose>
<%--
	初回表示時:empty param.user
			→送信データ内にuserはない→未送信なので成立
	その逆の判定:not empty param.user
			→送信データ内にuserはある→送信した場合に成立
		fn:length(param.user)>0
			→送信データのuserの文字数が0文字より多い
			→1文字でも入力した場合は成立
			→未入力で送信ボタンを押した場合は非成立
 --%>

<c:when test="${not empty param.user && fn:length(param.user)>0}">
 		ログイン用にユーザー名をパスワードを入力
</c:when>
<c:otherwise>
		登録するユーザー名をパスワードを入力<br>
</c:otherwise>
</c:choose>
<form action="Srv09_input.jsp">
		ユーザー名:<input type="text" name="user"><br>
		<%-- 分かりやすくするため、パスワードもtype:textで指定 --%>
		パスワード:<input type="text" name="pass"><br>
			<input type ="submit" value="送信">
</form>
	<% if(check(u,p)){ %>
		<%-- ログイン成功時 --%>
		<c:redirect url="Srv09_redirect.jsp"/>
	<% }else{ %>
		<%-- ログイン失敗時(何か処理したい場合はここに記述) --%>
	<% } %>
<%
	//入力データ送信時の動作(登録前)
	//user:0文字、送信データ:0文字ではない
	//	→「送信データ:nullではない」判定を先にする
	if(user.equals("")&& u!=null && !u.equals("")){
		//1回目の送信データを変数に格納
			user = u;
			pass = p;
	}
%>


</body>
</html>