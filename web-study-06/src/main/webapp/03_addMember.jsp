<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.saeyan.javabeans.MemberBean"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean" />
<jsp:setProperty name="member" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>입력 완료된 회원 정보</h2>
	<table border="1">
		<tr>
			<td>이름</td>
			<%-- <td><jsp:getProperty name="member" property="name"/></td> --%>
			<td><%=member.getName()%></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><jsp:getProperty name="member" property="userid" /></td>
		</tr>
		<tr>
			<td>별명</td>
			<td><jsp:getProperty name="member" property="nickname" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><jsp:getProperty name="member" property="pwd" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><jsp:getProperty name="member" property="email" /></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><jsp:getProperty name="member" property="phone" /></td>
		</tr>
	</table>
</body>
</html>