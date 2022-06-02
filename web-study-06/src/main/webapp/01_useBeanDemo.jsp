<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 객체생성 ==>  MemberBean member = new MemberBean() -->
<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean" />

이름 : <%= member.getName() %>
아이디 : <%=member.getUserid() %>

<h1> 정보변경 후</h1>
<%
	member.setName("전수빈");
	member.setUserid("pinksubin");
%>

이름 : <%= member.getName() %>
아이디 : <%=member.getUserid() %>

</body>
</html>