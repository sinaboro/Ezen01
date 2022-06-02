<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<%!
	Connection conn = null;
	Statement stmt=null;
	ResultSet rs = null;
	
	/* String url = "jdbc:oracle:thin:@localhost:1521:xe"; */
	String url = "jdbc:oracle:thin:@192.168.0.67:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	String sql = "select * from member";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<table width="800" border="1">
		<tr>
			<th>이름3</th>
			<th>아이디3</th>
			<th>암호3</th>
			<th>이메일2</th>
			<th>전화번호2</th>
			<th>권한(1:관리자, 0:일반회원)</th>
		</tr>
<%
	try{
		//1. 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2. 연결
		conn = DriverManager.getConnection(url,uid,pass);
		//3. sql문장 작성
		stmt = conn.createStatement();
		//4. sql문 실행
		rs = stmt.executeQuery(sql);
		//5. 실행된 결과물을 rs를 통해서 출력
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>" + rs.getString(1) + "</td>");
			out.println("<td>" + rs.getString(2) + "</td>");
			out.println("<td>" + rs.getString(3) + "</td>");
			out.println("<td>" + rs.getString(4) + "</td>");
			out.println("<td>" + rs.getString(5) + "</td>");
			out.println("<td>" + rs.getInt(6) + "</td>");
			out.println("</tr>");
		}  
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs !=null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
	</table>
</body>
</html>