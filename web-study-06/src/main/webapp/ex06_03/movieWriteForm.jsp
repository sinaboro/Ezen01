<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.item{
		text-align: center;	
	}
</style>
</head>

<body>
	<h1>게시판 글쓰기</h1>
	<form method="post" action="movieWrite.jsp">
		<table >
			<tr>
				<th class="item">제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th class="item">가격</th>
				<td><input type="text" name="price"> 원	</td>
			</tr>
			<tr>
				<th class="item">감독</th>
				<td><input type="text" name="director"></td>
			</tr>
			<tr>
				<th class="item">출연배우</th>
				<td><input type="text" name="actor" ></td>
			</tr>
		
			<tr>
				<th class="item">시놉시스</th>
				<td>
					<textarea rows="20" cols="80" name="synopsis">
					</textarea>
				</td>
			</tr>
			<tr>
				<th class="item">장르</th>
				<td>
					<select name="genre">
						<option value="로맨스">로맨스</option>
						<option value="스릴러" selected="selected">스릴러</option>
						<option value="미스터리">미스터리</option>
						<option value="액션">액션</option>
						<option value="코미디">코미디</option>
						<option value="애니메이션">애니메이션</option>
					</select>
				</td>
			</tr>
		</table>
		
		<span>
			<input type="submit" value="등록"/> 
			<input type="reset" value="다시 작성"/>
		</span>
	</form>
</body>
</html>