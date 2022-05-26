<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 04_testLogin.jsp</h1>
	
	<%
		String id = "pinksung";
		String pwd= "1234";
		String name = "성윤정";
		
		//request.setAttribute(name, "홍길동");
		
		request.setCharacterEncoding("utf-8");
		
		if(id.equals(request.getParameter("id"))){
			if(pwd.equals(request.getParameter("pwd"))){
				response.sendRedirect("04_main.jsp?name=" + URLEncoder.encode(name,"utf-8"));
			}
			else{
			response.sendRedirect("04_loingForm.jsp");
			}
		}else{
			response.sendRedirect("04_loingForm.jsp");
		}
		
	%>
</body>
</html>