<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "scott";
	String pass = "tiger";
	String sql = "insert into item values(?,?,?)";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String item = request.getParameter("item");
	String price = request.getParameter("price");
	String content = request.getParameter("content");
	
			
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pass);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, item);
		pstmt.setInt(2, Integer.parseInt(price));
		pstmt.setString(3, content);
		pstmt.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<a href="itemWrite.jsp">결과보기</a>
</body>
</html>