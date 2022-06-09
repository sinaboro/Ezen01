<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
    <title>Page Title</title>
    <meta charset="UTF-8">
  	<link rel="stylesheet" href="./css/common.css"/>
  </head>
  <body>
	
	<%@ include file="header.jsp" %>
    <!-- <header>
      <h1>쇼핑몰 회원관리 ver 1.0</h1>

    </header>

    <nav>
      <ul>
        <li><a href="joinForm.jsp">회원등록 </a></li>
        <li><a href="memberForm.jsp">회원목록 조회/수정 </a></li>
        <li><a href="saleForm.jsp">회원매출조회</a></li>
        <li><a href="index.jsp">홈으로 </a></li>
      </ul>
    </nav> -->

    <section>
      <h3>쇼핑몰회원관리 프로그램</h3>
      <h4>쇼핑몰 회원정보와 회원매출정보 데이타베이스를 구축하고 회원관리 프로그램을 작상하는 프로그램이다.</h4>
      <ol>
        <li>회원정보 테이블를 생성한다.</li>
        <li>매출정보 테이블를 생성한다.</li>
        <li>회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.</li>
        <li>회원정보 조회 프로그램을 작성한다.</li>
        <li>회원매출정보 조회 프로그램를 작성한다.</li>
      </ol>
    </section>
      
    <%@ include file="footer.jsp" %>


  </body>
</html>
