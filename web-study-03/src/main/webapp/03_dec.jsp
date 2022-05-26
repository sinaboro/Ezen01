<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String str = "안녕하세요!";
		int a = 5, b = -5;
		int sum = a+b;
		public int abs(int n) {
			if (n < 0) {
				n = -n;
			}
			return n;
	}%>

	<%
		
		out.print(str + "<br>");
		out.print(a + "의 절대값 : " + abs(a) + "<br>");
		out.print(b + "의 절대값 : " + abs(b) + "<br>");
		
		out.print("sum = " + sum + "<br>");
		out.println();
	%>
	
	
	
</body>
</html>
