<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean" />

이름 : <jsp:getProperty property="name" name="member"/><br>
아이디 : <jsp:getProperty property="userid" name="member"/><br>

<hr>
<h1> 정보변경 후</h1>
<jsp:setProperty property="name" name="member" value="전수빈2"/>
<jsp:setProperty property="userid" name="member" value="pinksubin2"/>

이름 : <jsp:getProperty property="name" name="member"/><br>
아이디 : <jsp:getProperty property="userid" name="member"/><br>
	
</body>
</html>