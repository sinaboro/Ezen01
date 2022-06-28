<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>

<%
	request.setCharacterEncoding("utf-8");

	int seq = Integer.parseInt(request.getParameter("seq")); 
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	BoardVO vo = new BoardVO();
	vo.setSeq(seq);
	vo.setTitle(title);
	vo.setContent(content);
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(vo);
	response.sendRedirect("getBoardList.jsp");
%>