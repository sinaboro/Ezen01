<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<h1>List Page</h1>
		<table class="table">
	    <thead>
	      <tr>
	        <th>#번호</th>
	        <th>제목</th>
	        <th>내용</th>
	        <th>저자</th>
	        <th>작성일</th>
	        <th>수정일</th>
	      </tr>
	    </thead>
	 	<c:forEach items="${list}" var="board"> 
		    <tbody>
		      <tr>
		        <td>${board.bno }</td>
		        <td>${board.title }</td>
		        <td>${board.content }</td>
		        <td>${board.writer }</td>
		        <td>${board.regdate }</td>
		        <td>${board.updatedate }</td>
		      </tr>
		    </tbody>
	    </c:forEach>
	  </table>
</div>
</body>
</html>