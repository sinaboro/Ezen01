<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.sql.*"%>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "system";
	String pwd = "1234";
	String sql = "select max(custno) from member_tbl_02";
	int custno = 100001;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pwd);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()){
			custno = rs.getInt(1)+1;
		}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/common.css"/>
<script type="text/javascript" src="/script/member.js"></script>
<title>Insert title here</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<section>

        <h3>쇼핑몰 회원 등록</h3>
		<form method="post" action="joinImpl.jsp" name="frm">
	        <table border="1" style="margin-left: auto; margin-right: auto;">
	            <tr>
	                <th>회원번호(자동발생))</th>
	                <td><input type="text"  name="custno" id="custno" value="<%=custno %>"><br></td>
	            </tr>
	            <tr>
	                <th>회원성명</th>
	                <td><input type="text"  name="custname" id="custname"></td>
	            </tr>
	            <tr>
	                <th>회원전화</th>
	                <td><input type="text"  name="phone" id="phone"></td>
	            </tr>
	            <tr>
	                <th>회원주소</th>
	                <td><input type="text"  name="address" id="address"></td>
	            </tr>
	            <tr>
	                <th>가입일자</th>
	                <td><input type="text" name="joindate" id="joindate"></td>
	            </tr>
	            <tr>
	                <th>고객등급 [A:VIP, B:일반, C:직원]</th>
	                <td><input type="text" name="grade" id="grade"></td>
	            </tr>
	            <tr>
	                <th>도시코드</th>
	                <td><input type="text" name="city" id="city"></td>
	            </tr>
	            <tr>
	                <th colspan="2">
	                    <input type="submit" value="등록" onclick="return joinCheck()" >
	
	                    <input type="button" value="조회" onclick="location.href='memberForm.jsp'">
	
	                </th>
	            </tr>
	        </table>
        </form>

    </section>
    
     <%@ include file="footer.jsp" %>
</body>
</html>
<%		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if( rs != null) rs.close();
			if( pstmt != null) pstmt.close();
			if( conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>