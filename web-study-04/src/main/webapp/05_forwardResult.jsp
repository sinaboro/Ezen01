<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	forward 방식으로 이동된 페이지<br>
	<%=request.getParameter("age") %>
	<%=request.getAttribute("name") %>
</body>
</html>