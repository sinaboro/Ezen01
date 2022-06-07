<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.dao.*"%>
    
<jsp:useBean id="dao" class="com.it.dao.BoardDAO"/>

<%
	String no = request.getParameter("no");
	String pwd = request.getParameter("pwd");
	
	int result = dao.boardDelete(Integer.parseInt(no), pwd);
%>
<%=result%>