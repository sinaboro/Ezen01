<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgclolr="red">
	<h1> red.jsp</h1>
	
	<jsp:forward page="08_yellow.jsp">
		<jsp:param value="java" name="name"/>	
	</jsp:forward>
</body>
</html>