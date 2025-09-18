<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv22_PtypeIns</title>
<link rel="stylesheet" href="style.css">
</head>
<%
	FilenameFilter filter = new FilenameFilter(){
		public boolean accept(File f,String s){
			return s.endsWith("_t.png");
		}
	};
	File fl = new File(application.getRealPath(".")+"/img");
	File[] fls = fl.listFiles(filter);
	List<String> list = new ArrayList<>();
	for(File f:fls){
		list.add(f.getName());	
	}
	pageContext.setAttribute("imgli", list);
%>
<body>

<h2>更新後の値を入力</h2>
<form action="Srv22_PtypeIns" method="post">
<table>
	<tr>
		<th>タイプ名</th>
		<td><input type="text" name="ptname"></td>
	</tr>
	<tr>
		<th>画像</th>
		<td>
			<select name="ptimg">
			<c:forEach items="${imgli}" var="dt">4
			<option value="img/${dt}">
				<c:out value="${dt}"/>
			</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="送信">
		</td>
	</tr>
</table>
</form>	
</body>
</html>