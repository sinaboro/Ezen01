<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String no = request.getParameter("no");
%>
<!DOCTYPE html>
<html></html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
<style type="text/css">
	.container{
		margin-top: 50px;
	}
	.row{
		margin: 0px auto;
		width : 960px;
	}
	
	h1{
		text-align: center;
	}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$('#delBtn').click(function(){
			let pwd = $('#pwd').val();
			if(pwd.trim() == "") {//비밀변호 입력값 확인 ,,,,,,,, #(id), .(class)
				$('#pwd').focus();
				return;
			}
		})
		
		$.ajax({
			type:'POST',
			url: 'delete_impl.jsp',
			data:{"no":$('#no').val, "pwd":pwd};
			success:function(res){
				let r= res.trim();
				if(r==0){
					alert("비밀번호가 틀립니다.");
					$('#pwd').val("");
					$('#pwd').focus();
				}else{
					location.href="list.jsp";
				}
			}
		})
	})
</script>

</head>
<body>
	<div class="container">
		<h1>수정하기</h1>
		<div class="row">
			<form method="get" action="delete_impl.jsp">
				<table class="table">
					<tr>
						<td class="text-center">
							비밀번호 : <input type="password" name="pwd" size="10" class="input-sm">
							<input type="hidden" name = "no" value=<%=no%> id="no">
						</td>
					</tr>
					<td class="text-center">
						<input type=submit value="삭제" class="btn btn-sm btn-primary" id="delBtn">
						<input type="button" value="취소" class="btn btn-sm btn-primary"  
						onclick="javascript:history.back()">
					</td>
				</table>
			</form>
		</div>
	</div>
	
</body>
