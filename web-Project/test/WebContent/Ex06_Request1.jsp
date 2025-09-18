<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Ex06_Request1</title>
</head>
<body>

<a href="Ex06_Request">リンク文字例</a><br>
<%-- <jsp:forward page="Ex06_Request"/>--%>
<c:redirect url="Ex06_Request"/>

</body>
</html>