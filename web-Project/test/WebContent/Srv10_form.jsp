<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv10_from</title>
</head>
<body>
	<%--　入力欄を並べるため、formタグ内にtableタグを記述 --%>
	<form action ="Srv10_form">
		<table border="1">
		<tr>
			<th>名前</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>住所	</th>
			<td><input type="text" name="adrr"></td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td><input type="text" name="tel"></td>
		</tr>
		<tr>
			<th>血液型</th>
		<td>
			<%-- radioボタンは小さく、クリックしにくいため、文字の部分をクリックしても選択できるようにする --%>
			<label>
				A<input type="radio" name="bld" value="A">
			</label>
			<label>
				B<input type="radio" name="bld" value="B">
			</label>
			<label>
				O<input type="radio" name="bld" value="O">
			</label>
			<label>
				AB<input type="radio" name="bld" value="AB">
			</label>
			<label>
				不明<input type="radio" name="bld" value="不明">
			</label>
			</td>
		</tr>
		<tr>
			<th>職業</th>
			<td>
				<select name="job">
					<option>会社員</option>
					<option>自営業</option>
					<option>学生</option>
					<option>バイト</option>				
				</select>
			</td>
		</tr>
		<tr>
			<%-- 横のセル二つ分を結合する→colspan="2"
				内容を右寄せで出力する→align="right" --%>
			<td	colspan="2" align="right">
				<input type="submit" value="送信">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>