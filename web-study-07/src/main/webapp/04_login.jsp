<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="04_testLogin.jsp">
		<label for="userid"> 아이디 : </label> <input type="text" name="id"
			id="userid"><br> <label for="userpwd"> 암 &nbsp;
			호 : </label> <input type="password" name="pwd" id="userpwd"><br>
		<input type="submit" value="로그인">
	</form>
	
	<%
		int a = 10;
		if(a>10){
	%>
			out.println(a + " ");
	<%
		}else{
	%>
			out.println(a + " ");
	<%
		int b = a/0;
		}
	%>
	

</body>
</html>