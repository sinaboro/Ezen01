<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getParameter("name") %>님 안녕하세요!!
	<br>
	저희 홈페이지 방문을 환영합니다.!!
	<%=request.getAttribute("id") %>
</body>
</html>