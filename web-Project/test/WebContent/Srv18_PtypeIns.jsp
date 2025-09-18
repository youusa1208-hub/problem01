<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,beans.PtypeBean" %>
<%@ page import="java.util.*, java.io.File, java.io.FilenameFilter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv18_PtypeIns</title>
<style>
	table,th,td{
	border:1px solid black;
	}
	table{
	border-collapse:collapse;
	}
</style>
</head>
<%
	//ファイル名全てを取得しないように、対象を限定する
	//java基礎のラムダ式の記述で、以下の処理はされに省略可能
	FilenameFilter filter = new FilenameFilter() {
		public boolean accept(File dir, String name) {
		//strにはファイルパスが格納されている
		//	→ファイルパスの最後が「_t.png」の場合:true
		//	そうではない(_t.png以外の)場合:false
	        return name.endsWith("_t.png");
		    }
		};
	//application.getRealPath(".")→現在のjspファイルの格納場合
	//→サーバー内のアドレスではなく、PC内の格納場合JSPファイルの格納場合+"/img"→「WebContent/img」を指定
	File fl = new File(application.getRealPath(".")+"/img");
	//WebContent/imgの中のファイルを１つずつaccept()メソッドの引数に指定
	//→trueのファイルのみ情報を取得し、配列に格納
	//filter:FilenameFilter型のインスタンス、listFiles()の引数に指定するとflのファイルを1つずつaccept()で判定する
	File[]fls = fl.listFiles(filter);
	List<String> imglist = new ArrayList<>();
	for(File f:fls){
		//accept()メソッドでtrueを返したファイル名をListコレクションに追加
		imglist.add(f.getName());
	}
	pageContext.setAttribute("imgli", imglist);
%>
<body>

<h2>追加するタイプを入力</h2>
<form action ="Srv17_PtypeIns" method="POST">
<table>
	<tr>
		<th>タイプ名</th>
		<td><input type="text" name="ptname"></td>
	</tr>
	<tr>
		<th>画像</th>
		<td>
			<select name="ptimg">
			<c:forEach items="${imgli}" var="dt">
				<option value="img/${dt}">${dt}</option>
			</c:forEach>
			</select>
		</td>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="送信">
		</td>	
	</tr>
</table>
</form>

</body>
</html>