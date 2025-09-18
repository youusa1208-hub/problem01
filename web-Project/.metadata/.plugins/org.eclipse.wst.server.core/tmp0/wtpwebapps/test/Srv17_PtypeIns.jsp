<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv17_PtypeIns</title>
</head>
<body>

	<h2>追加するタイプの入力</h2>
	<form action="Srv17_PtypeIns" method="POST">
	<table>
		<tr>
			<th>タイプ名</th>
			<td><input type="text" name="ptname"></td>
		</tr>
		<tr>
			<th>画面</th>
			<td><input type="text" name="ptimg"></td>
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