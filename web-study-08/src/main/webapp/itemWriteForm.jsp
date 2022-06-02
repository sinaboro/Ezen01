<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>정보 입력 폼</h1>
		<form method="post" action="itemWriteResult.jsp">
		<table>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="item"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<th>설명</th>
				<td>
					<textarea rows="5" cols="50" name="content"></textarea>
				</td>
			</tr>
		</table>
		
		<input type="submit" value="전송">&nbsp;&nbsp;
		<input type="reset" value="취소">
		
		
	</form>
</body>
</html>