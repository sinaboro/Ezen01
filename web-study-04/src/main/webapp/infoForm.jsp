<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "infoResult.jsp" method="post">
		ID : <input type="text" name = "id"><br>
		pwd : <input type="password" name="pwd"><br>
		<textarea name = "dec" rows="4" cols="50">
		</textarea><br>
		<input type="submit" value="전송">
		<input type="reset" value="취소">
	</form>
</body>
</html>