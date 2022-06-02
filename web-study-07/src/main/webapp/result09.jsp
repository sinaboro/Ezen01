<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${param.id}님
	<c:choose>
		<c:when test="${param.admin == 1}">
			사용자로 로그인했습니다.
		</c:when>
		<c:when test="${param.admin == 2}">
			관리자로 로그인했습니다.
		</c:when>
	</c:choose>
</body>
</html>