<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Srv11_from</title>
</head>
<body>

	<form action="Srv11_form">
	<table border="1">
		<tr>
			<th>姓</th>
			<td><input type="text" name="fname"></td>
		</tr>			
		<tr>
			<th>名</th>
			<td><input type="text" name="pname"></td>
		</tr>		
		<tr>
			<th>都道府県</th>
			<td>
				<select name="addr1">
					<option>東京都</option>
					<option>大阪府</option>
					<option>京都府</option>
					<option>山口県</option>
					<option>沖縄県</option>
				</select>
			</td>
		</tr>		
		<tr>
			<th>市区町村</th>
			<td><input type="text" name="addr2"></td>
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
			<td	colspan="2" align="right">
				<input type="submit" value="送信">
			</td>
		</tr>		
	</table>
	</form>
</body>
</html>