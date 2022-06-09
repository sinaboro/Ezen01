<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String custno = request.getParameter("custno");
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	
	String sql = "insert into member_tbl_02 values(?,?,?,?,?,?,?)";
	Connection conn = null;
	PreparedStatement pstmt = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "system";
	String pwd = "1234";
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pwd);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, custno);		
		pstmt.setString(2, custname);	
		pstmt.setString(3, phone);		
		pstmt.setString(4, address);		
		pstmt.setString(5, joindate);		
		pstmt.setString(6, grade);		
		pstmt.setString(7, city);		
		int result = pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if( pstmt != null) pstmt.close();
			if( conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	response.sendRedirect("index.jsp");	
%>
