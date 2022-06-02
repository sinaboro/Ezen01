<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* pageContext.setAttribute("name", "page man"); */
request.setAttribute("name", "request man");
session.setAttribute("name", "session man");
application.setAttribute("name", "application man");
%>
name : ${name} <hr>
page 속성 : ${name} <br>
request 속성 : ${requestScope.name} <br>
session 속성 : ${name} <br>
application 속성 : ${name} <br>

servlet & jsp