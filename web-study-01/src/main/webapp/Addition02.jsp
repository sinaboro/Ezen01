<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%  //스크립트릿
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
	%>
	
	<!-- 표현식 -->
	<h1> Addiotn 합계 계산</h1>
	<%=num1%> + <%=num2 %> = <%=add %>
	
</body>
</html>