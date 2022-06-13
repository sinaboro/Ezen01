<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<form method="post"  action="join"  name="frm">

		아이디 : <input type="text"  name="id"  required><br>

		비밀번호 : <input type="password"  name="pwd"  required="required"><br>

		주소 : <input type="text"  id="address"  name="address"  size="70"  required="required"  readonly="readonly"><br> 
		       <input 	type="button"  value="주소검색"   onclick="goPopup()" ><br> 
		       <input  	type="submit"  value="전송"><br>
	</form>
	
<script language="javascript">
		function goPopup(){
			var pop = window.open("/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		}
		
		function jusoCallBack(roadFullAddr, zipNo){
//		function jusoCallBack(roadFullAddr, zipNo){
				document.frm.address.value = roadFullAddr;
				//document.frm.zipNo.value = zipNo;
		}
</script>
</body>
</html>
	​