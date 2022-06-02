<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="movie" class="com.mission.javabeans.MovieBean"/>
<jsp:setProperty property="*" name="movie"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.item{
		text-align: center;
	}
	
	.border{
		border:1px solid black;
		border-radius: 10px;
	}
</style>
</head>
<body>
<h1>입력된 완료된 정보</h1>
	<table border="1">
		<tr >
			<th class="item">제목</th>
			<td><%=movie.getTitle() %></td>
		</tr>
		<tr >
			<th class="item">가격</th>
			<td><%=movie.getPrice() %></td>
		</tr>
		<tr >
			<th class="item">감독</th>
			<td><%=movie.getDirector() %></td>
		</tr>
		<tr >
			<th class="item">출연배우</th>
			<td><%=movie.getActor() %></td>
		</tr>
		<tr >
			<th class="item" >시놉시스</th>
			<td class="border1"><%=movie.getSynopsis() %></td>
		</tr>
		<tr >
			<th class="item">장르</th>
			<td><%=movie.getGenre() %></td>
		</tr>
	</table>
</body>
</html>