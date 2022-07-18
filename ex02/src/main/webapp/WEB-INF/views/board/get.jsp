<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
							<div class="from-group">
								<label>Bno</label>
								<input class="form-control"  name="bno"  readonly="readonly"  value='<c:out value="${board.bno}"/>' ><br>
							</div>
							<div class="from-group">
								<label>Title</label>
								<input class="form-control"  name="title"  readonly="readonly" value='<c:out value="${board.title}"/>' ><br>
							</div>
							<div class="from-group">
								<label>Text area</label>
								<textarea class="form-control"   rows="3"  name="content"  readonly="readonly">
								<c:out value="${board.content}"/></textarea><br>
							</div>
							<div class="from-group">
								<label>Writer</label>
								<input class="form-control"  name="writer"  readonly="readonly" value='<c:out value="${board.writer}"/>' ><br>
							</div>
						    
						    <button data-oper=' modify'   class="btn btn-default"
						    onclick="location.href = '/board/modify?bno= <c:out value="${board.bno}" />' ">
						    Modify</button>
						    
						    <button data-oper=' list'  class="btn btn-info"  onclick="location.href= '/board/list'  ">List</button>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
 <!-- 여기부터 시작............ -->
<!--  <div class="modal" tabindex="-1" role="dialog" id="myModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        처리가 완료되었습니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
 -->
 <!-- <script>
 	$(document).ready(function(){
 		var result = '<c:out value="${result}" />'
 		
 		checkModal(result);
 		function checkModal(result){
 			if(result == ' '){
 				return;
 			}
 			if(parseInt(result) > 0 ){
 				$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
 			}
 			$("#myModal").modal("show");
 		}
 		
 		$("#regBtn").on("click", function(){
 			self.location = "/board/register";
 		});
 	});
 </script>    -->
 <%@ include file="../includes/footer.jsp" %>