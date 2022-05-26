<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();
	String name = null;
	
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			name = cookie.getName();
			if (name.equals("userName")) {
				out.print(URLDecoder.decode(cookie.getValue(), "UTF-8"));
		// 				out.print(cookie.getValue());	
			}
		}
	%>
	님 안녕하세요!!
	<br> 저희 홈페이지에 방문해 주셔서 감사합니다.
	<br> 즐거운 시간 되세요...
	<br>
	<!-- 	<form method="post" action="logout.jsp"> -->
	<!-- 		<input type="submit" value="로그아웃"> -->
	<!-- 	</form> -->
	<p>
		<a href="logout.jsp">로그아웃</a>
	</p>
	<%
	} else {
	%>
	<h2>로그인 실패했습니다..</h2>
	<p>
		<a href="loginForm.jsp">돌아가기</a>
	</p>
	<%
	}
	%>

</body>
</html>