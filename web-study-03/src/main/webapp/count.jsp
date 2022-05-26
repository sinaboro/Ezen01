<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.util.Calendar" %>

<%!
	int global_cnt = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		Calendar date = Calendar.getInstance();
	 SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");
	%>
	
	<%= today.format(date.getTime()) %>
</body>
</html>