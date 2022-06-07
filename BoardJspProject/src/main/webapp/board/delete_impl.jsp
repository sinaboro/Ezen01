<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*"%>
    
<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>

<%
	String no = request.getParameter("no");
	String pwd = request.getParameter("pwd");
	
	boolean result = dao.boardDelete(Integer.parseInt(no), pwd);
	
	if(result == true){
%>
	<script type="text/javascript">
		alert("데이타가 삭제됐습니다.");
		location.href="list.jsp";
	</script>
<%
	}
%>
