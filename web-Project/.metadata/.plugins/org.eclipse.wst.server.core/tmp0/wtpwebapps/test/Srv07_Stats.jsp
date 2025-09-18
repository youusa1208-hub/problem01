<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv07_Stats</title>
</head>
<body>
<%
	String str = request.getParameter("p1");
	//p1の送信データが0文字か判定
		if(!str.equals("")){
	//リクエスト属性に情報を追加
		str +="追加の値";
	//リクエスト属性に値を設定(属性名を付与)
		request.setAttribute("addstr",str);
		}
%>
<jsp:forward page="Srv07_Stats2.jsp"/>
</body>
</html>