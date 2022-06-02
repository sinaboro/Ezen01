<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<form method="post" action="loginTest.jsp">
		아이디 : <input type="text" name="id" id="userid"><br>
		암　호 : <input type="password" name="pwd" id="userpwd"><br>
		<input type="radio" name="name" value="1" checked>사용자
		<input type="radio" name="name" value="2">관리자<br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>