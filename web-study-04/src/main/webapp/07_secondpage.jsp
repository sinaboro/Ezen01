<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>SecondPage</h1><br>
		
		<%= pageContext.getAttribute("name") %><br>
		<%= request.getAttribute("name") %> <br>
		<%= session.getAttribute("name") %> <br>
		<%= application.getAttribute("name") %> <br>
		<% 
			System.out.println("----------------------------");
			System.out.println(pageContext.getAttribute("name"));
			System.out.println(request.getAttribute("name"));
			System.out.println(session.getAttribute("name"));
			System.out.println(application.getAttribute("name"));
			
			request.getRequestDispatcher("07_thirdPage.jsp").forward(request, response);
		%>
		
		<!-- <a href = "07_thirdPage.jsp">또 다른 페이지</a> -->
		
		
		
		
</body>
</html>