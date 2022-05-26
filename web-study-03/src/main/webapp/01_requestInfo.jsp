<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getContextPath() %><br>
	<%=request.getMethod() %><br>
	<%=request.getRequestURL() %><br>
	<%=request.getRequestURI() %><br>
	<%=request.getServerName() %><br>
	<%=request.getProtocol() %><br>
</body>
</html>