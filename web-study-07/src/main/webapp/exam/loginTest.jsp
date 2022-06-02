<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.name == 1}">
			<c:redirect url="main_user.jsp?id=${param.id}" ></c:redirect>
		</c:when>
		<c:otherwise>
			<c:redirect url="main_administrator.jsp?id=${param.id}"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>