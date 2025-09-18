<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv11b_form</title>
</head>
<body>

	<h1>商品情報を入力</h1>
	<form action="Srv11b_form" method="POST">
	<table border="1">
		<tr>
			<th>商品名</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>商品種別</th>
			<td>
			<select name="type">
					<option>野菜</option>
					<option>魚</option>
					<option>肉</option>
					<option>乳製品</option>
					<option>パン</option>
			</select>
			</td>
		</tr>
		<tr>
			<th>価格</th>
			<td><input type="text" name="price"></td>
		</tr>		
		<tr>
			<th>内容量</th>
			<td><input type="text" name="quantity"></td>
		</tr>
		<tr>
			<td	colspan="2" align="right">
				<input type="submit" value="送信">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>