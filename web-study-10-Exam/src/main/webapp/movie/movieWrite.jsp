<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>영화 정보 등록</h1>
		<form method="post" enctype="multipart/form-data" name="frm">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" ></td>
				</tr>
				<tr>
					<th>가 격</th>
					<td><input type="text" name="price"> 원</td>
				</tr>
				<tr>
					<th>감독</th>
					<td><input type="text" name="director"></td>
				</tr>
				<tr>
					<th>배우</th>
					<td><input type="text" name="actor"> </td>
				</tr>
				<tr>
					<th>설 명</th>
					<td><textarea cols="80" rows="10" name="synopsis"></textarea></td>
				</tr>
				<tr>
					<th>사 진</th>
					<td><input type="file" name="poster"><br>
				</tr>
			</table>	<br> 
			<input type="submit" value="확인"  onclick="return productCheck()"> 
            <input type="reset"  value="취소"> 
            <input type="button" value="목록" 	onclick="location.href='movieList.do'">
		</form>
	</div>
</body>
</html>