<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="msg" value="Hello"></c:set>
\${msg} = ${msg}<br>
<c:set var="age" value="32"/>
\${age} = ${age}<hr>
<c:set var="member" value= "<%= new com.saeyan.javabeans.MemberBean() %>"/>

<c:set target="${member}" property="name" value="전수빈" ></c:set>
<c:set target="${member}" property="userid">pinksubin</c:set>
\${member} = ${member}<hr>
\${name} = ${member.name}<hr>
\${userid} = ${member.userid}<hr>

<c:set var="add" value="${10 + 5}"></c:set>
\${add} = ${add}<br>
<c:set var="flag" value="${10 < 5}"></c:set>
\${flag} = ${flag}<br>

</body>
</html>