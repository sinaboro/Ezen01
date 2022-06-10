<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "system";
	String pwd = "1234";
	String sql = "select m.CUSTNO, m.CUSTNAME,m.GRADE, sum(n.price) as 매출 "+
			"from member_tbl_02 m, money_tbl_02 n "+
			"where m.CUSTNO = n.CUSTNO "+
			"group by m.CUSTNO, m.custname, m.grade "+
			"order by 매출 desc";
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,id,pwd);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/common.css"/>
<title>Insert title here</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<section>

        <h3>회원매출조회</h3>
		<form method="post" action="updateImpl.jsp">

	        <table border="1" style="margin-left: auto; margin-right: auto;">
	            <tr>
	                <th>회원번호</th>
	                <th>회원성명</th>
	                <th>고객등급</th>
	                <th>매출</th>
	            </tr>
	            <tr>
<%
		while(rs.next()){
				String grade="7직원";
				if(rs.getString(3).equals("A")) grade="VIP";
				else if(rs.getString(3).equals("B")) grade="일반";
%>				
	                <td><input type="text"  name="custno" value="<%=rs.getString(1) %>"><br></td>
	                <td><input type="text"  name="custname" value="<%=rs.getString(2) %>"></td>
	                <td><input type="text"  name="grade" value="<%=grade %>"></td>
	                <td><input type="text"  name="sale" value="<%=rs.getString(4) %>"></td>
	            </tr>
<%
		}
%>
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