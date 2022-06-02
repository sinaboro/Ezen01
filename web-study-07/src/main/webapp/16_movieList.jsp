<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] movieList = { "타이타닉", "시네마 천국", "혹성 탈출", "킹콩" };
		pageContext.setAttribute("movieList", movieList);
	%>
	<ul>
		<c:forEach var="movie" items="${movieList}" varStatus="status">
			<c:choose>
				<c:when test="${status.first }">
					<li style="font-weight: bold; color: red;">${movie}</li>
				</c:when>
				<c:otherwise>
					<li>${movie}</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	
	<c:forEach var="movie" items="${movieList}" varStatus="status">
			${movie} 
			<c:if test="${not status.last}"> , </c:if>
	</c:forEach>
</body>
</html>