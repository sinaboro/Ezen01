<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp" %>

        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Board Read Page</h1>
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
						    
						    <button data-oper='modify' class="btn btn-default">Modify</button>
						    <button data-oper=' list'  class="btn btn-info" > List</button>
						    
						    <form id='operForm'  action = "/board/modify" method="get">
						    	<input type="hidden"  id="bno"  name="bno"  value='<c:out value="${board.bno }"/>' >
						    	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'   >
						    	<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'   >
						       	<input type="hidden" name="type" value='<c:out value="${cri.type}"/>'   >
						    	<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'   >
						    	
						     </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

<style type="text/css">
	.chat {
		background: #eee;
		cursor: pointer;
	}
</style>
     <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           <i class = "fa fa-comments fa-fw"></i>  Ready 
                           <button id="addReplyBtn"  class="btn btn-primary btn-xs pull-right">New Reply</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<ul class ="chat">
                        		<!-- <li class="left clearfix" data-rno='12'>
                        			<div>
                        				<div class="header">
                        					<strong class="primary-font">user00</strong>
                        					<small class="pull-right text-muted">2018-01-01 12:12</small>
                        				</div>
                        				<p>댓글 테스트</p>
                        			</div>
                        		</li> -->
                        	</ul>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->      
   <!-- -------------- ------------------------------------------------------------- -->
   
      <!-- 댓글 모달창 시작 -->
   <!-- Modal -->
<div id="myModal" class="modal fade" role="dialog"  tabindex="-1">
  <div class="modal-dialog">
    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Reply Modal</h4>
	      </div>
	      <div class="modal-body">
	        <div class="form-group">
	        	<label>Reply</label>
	        	<input  class="form-control" name="reply"  value="New replyer">
	        </div>
	        <div class="form-group">
	        	<label>Replyer</label>
	        	<input class="form-control"  name="replyer" value="replyer">
	        </div>
	        <div class="form-group">
	        	<label>Reply Date</label>
	        	<input class="form-control"  name="replyDate" value="">
	        </div>
	      </div>
	      <div class="modal-footer">
	      	<button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
	      	<button id="modalRemoveBtn" type="button" class="btn btn-danger">Remove</button>
	      	<button id="modalRegisterBtn" type="button" class="btn btn-info">Register</button>
	        <button id="modalCloseBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
  </div>
</div>
 <!-- 댓글 모달창 끝 -->
   
  <script type="text/javascript" src="/resources/js/reply.js"></script> 
  
  <script>
  
  
  
  $(document).ready(function(){
	  var bnoValue = '<c:out value= "${board.bno}" /> ';
	  var replyUL = $(".chat");
	 
	 /*  <li class="left clearfix" data-rno='12'>
			<div>
				<div class="header">
					<strong class="primary-font">user00</strong>
					<small class="pull-right text-muted">2018-01-01 12:12</small>
				</div>
				<p>댓글 테스트</p>
			</div> 
			</li>*/
	  showList(1);
	
	 var modal = $("#myModal");    //$(".myModal");
	 var modalInputReply = modal.find("input[name='reply']");
	 var modalInputReplyer = modal.find("input[name='replyer']");
	 var modalInputReplyDate = modal.find("input[name='replyDate']");
	 
	 var modalModBtn = $("#modalModBtn");
	 var modalRemoveBtn = $("#modalRemoveBtn");
	 var modalRegisterBtn = $("#modalRegisterBtn");
	 
	  $("#addReplyBtn").on("click",function(){
		  
		  modal.find("input").val("");
		  modalInputReplyDate.closest("div").hide();
		  modal.find("button[id != 'modalCloseBtn']").hide();
		  
		  modalRegisterBtn.show();
		  $("#myModal").modal("show");
		  
	  });
	  
	  modalRegisterBtn.on("click", function(e){
		  var replys = {
				  reply : modalInputReply.val(),
				  replyer : modalInputReplyer.val(),
				  bno : bnoValue
		  }  //javascript 객체
		  
		  replyService.add(replys,  function(result){
			  alert("result : " + result);
			  modal.find("input").val("");
			  modal.modal("hide");
			  showList(1);
		  });
		  
	  }); //Register 등록
	  
	  //이벤트위임..시작
	  $(".chat").on("click", "li",function(){
		  var rno = $(this).data("rno");
		  
		  replyService.get(rno, function(reply){
			  modalInputReply.val(reply.reply);
			  modalInputReplyer.val(reply.replyer);
			  modalInputReplyDate.val(
					  replyService.displyTime( reply.replyDate)).attr("readonly", "readonly"); //수정예정
			  modal.data("rno", reply.rno);
			  
			  modal.find("button[id != 'modalClassBtn']").hide();
			  modalModBtn.show();
			  modalRemoveBtn.show();
			  
			  $("#myModal").modal("show");
			  
		  });
	  });
	  //이벤트위임..끝
	  
	  function showList(page){
		  replyService.getList(
				{bno:bnoValue, page : page||1},
				function(list){
					var str="";
					if(list == null || list.length==0){
						replyUL.html("");
						return ;
					}
					for(var i=0, len=list.length ||0 ; i<len; i++){
						str += "<li class='left clearfix' data-rno=' "+list[i].rno+" '>";
						str +=  "<div><div class='header'><strong class='primary-font'>" + list[i].replyer+ "</strong>";
						str += "<small class='pull-right text-muted'>"+ replyService.displyTime(list[i].replyDate)  +"</small></div>";
						str += "<p>"+ list[i].reply +"</p></div></li>";
					}
					replyUL.html(str);
				} 
		  ); //end Service
	  } //end showList
	  
	  
  });
 /*  replyService.get(186, function(data){
	  alert(data);
	  console.log(data);
  }); */
		  
  
  	/* replyService.update(
  			{rno: 187, reply: 'Mdidied Reply2.....'},
			function(result){
  				alert("수정 완료");
  			} 			
  	); */
  	/* replyService.remove(188, function(result){
	  		console.log(result);
	  		if( result === "success") {
	  			alert("Removed");
	  		}
	  	},
  		function(err){
  			alert("Error");
  		}
	); */
  
/* replyService.getList(
		 {bno:bnoValue, page:1},
		 function(list){
			 for(var i=0, len = list.length || 0; i<len; i++){
				 console.log(list[i]);
			 }
		 }
  )  */
  
 /* replyService.add(
		    {reply:"JS Test2", replyer:"tester2", bno:bnoValue}  ,
		    function(result){ 
		      	alert("RESULT: " + result);
		    }
	); 
 */
		    
  
  	
  </script>
  
  <script>
  		var operForm = $("#operForm");
  		
  		$("button[data-oper='modify' ]").on("click", function(e){
  			operForm.attr("action", "/board/modify").submit();
  		});

  		$("button[data-oper=' list']").on("click", function(e){
  			operForm.find("#bno").remove();
  			operForm.attr("action", "/board/list").submit();
  		});
  		
  </script>       
  
  
 <%@ include file="../includes/footer.jsp" %>