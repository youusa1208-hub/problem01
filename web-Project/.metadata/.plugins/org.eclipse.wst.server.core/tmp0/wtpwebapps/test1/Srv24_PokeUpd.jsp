<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv24_PokeUpd</title>
<link rel="stylesheet" href="style.css">
</head>
<%
	FilenameFilter filter = new FilenameFilter(){
		public boolean accept(File f,String s){
			return s.endsWith(".png")&& !s.endsWith("_t.png");
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

	<form action="Srv24_PokeUpd1" method="POST">
		<table>
			<tr>
				<th>ポケモンid</th>
				<td><c:out value="${pb.pid}" /> <input type="hidden"
					name="pid" value="${pb.pid}"></td>
			</tr>
			<tr>
				<th>ポケモン名</th>
				<td><input type="text" name="pname" value="${pb.pname}">
				</td>
			</tr>
			<tr>
				<th>画像</th>
				<td><select name="pimg">
						<c:forEach items="${imgli}" var="dt">
							<option value="img/${dt}">
								<c:if test="${fn:substringAfter(pb.pimg,'/')==dt}">
					selected
				</c:if>>
								<c:out value="${dt}" />
							</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>タイプ</th>
				<td><select name="ptid">
						<c:forEach items="${li}" var="dt">
							<option value="${dt.ptid}">
								<c:if test="${pb.ptid==dt.ptid}">
					selected
					</c:if>>
								<c:out value="${dt.ptid}:${dt.ptname}" />
							</option>
						</c:forEach>
				</select>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="送信">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>