<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="#"  name="frm" >
		&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-primary"
			value="주소검색"  onClick="goPopup()" ><br>
		<br> 주소 : <input type="text"  name="addr"  id="address"  size="100">
	</form>


	<script language="javascript">
		function goPopup() {
			var pop = window.open("/popup/jusoPopup.jsp", "pop",
					"width=570,height=420, scrollbars=yes, resizable=yes");

		}

		function jusoCallBack(roadFullAddr) {
			document.frm.address.value = roadFullAddr;

		}
	  </script>
		</body>
		</html>
	