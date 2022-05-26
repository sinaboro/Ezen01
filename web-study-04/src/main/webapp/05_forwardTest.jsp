<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		int age = Integer.parseInt(request.getParameter("age"));
	
		if(age<=19){
	%>
		<script type="text/javascript">
			alert("19세 미만 입장 불가능")
			history.go(-1)
		</script>
	<%		
		}else{
			//request.setAttribute("name", "홍길동");
			request.setAttribute("name","홍길동");
			
			RequestDispatcher dis = request.getRequestDispatcher("05_forwardResult.jsp");
			dis.forward(request, response);
		}
	%>
