<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%!
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "scott";
	String pass = "tiger";

	String sql = "select * from item";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<h1 align="center">입력 완료된 정보</h1><br>
<body>
	<div class="container">
	 <table class="table table-bordered">
	  	<thead>
	      <tr>
	        <th>상품</th>
	        <th>가격</th>
	        <th>설명</th>
	      </tr>
  	 	 </thead>
<%
	try{
		//1. 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2. 연결
		conn = DriverManager.getConnection(url,id,pass);
		//3. sql문장 작성
		pstmt = conn.prepareStatement(sql);
		//4. sql문 실행
		rs = pstmt.executeQuery();
		//5. 실행된 결과물을 rs를 통해서 출력
		while(rs.next()){
%>
		<tbody>
			<tr class="table-primary">
				<td > <%= rs.getString(1) %> </td>
				<td> <%= rs.getString(2) %> </td>
				<td> <%= rs.getString(3) %> </td>
			</tr>
		</tbody>
<%
		}  
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs !=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
	  </table>
  </div>
</body>
</html>