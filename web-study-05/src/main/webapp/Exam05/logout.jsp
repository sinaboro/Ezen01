<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃</h1>
<%
	Cookie cookie = new Cookie("userName","");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
%>

<script type="text/javascript">
	alert("로그아웃됬습니다.");
	location.href= "loginForm.jsp";
</script>
</body>
</html>