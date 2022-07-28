<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<style type="text/css">
	#replycheck {
		background : #eee;
		cursor : pointer;
	}
</style>

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
         <div class="panel-heading">Board Read Page</div>
         <!-- /.panel-heading -->
         <div class="panel-body">
            <div class="from-group">
               <label>Bno</label> <input class="form-control" name="bno"
                  readonly="readonly" value='<c:out value="${board.bno}"/>'><br>
            </div>
            <div class="from-group">
               <label>Title</label> <input class="form-control" name="title"
                  readonly="readonly" value='<c:out value="${board.title}"/>'><br>
            </div>
            <div class="from-group">
               <label>Text area</label>
               <textarea class="form-control" rows="3" name="content"
                  readonly="readonly">
                        <c:out value="${board.content}" /></textarea>
               <br>
            </div>
            <div class="from-group">
               <label>Writer</label> <input class="form-control" name="writer"
                  readonly="readonly" value='<c:out value="${board.writer}"/>'><br>
            </div>

            <button data-oper='modify' class="btn btn-default">Modify</button>
            <button data-oper=' list' class="btn btn-info">List</button>

            <form id='operForm' action="/board/modify" method="get">
               <input type="hidden" id="bno" name="bno"
                  value='<c:out value="${board.bno }"/>'> <input
                  type="hidden" name="pageNum"
                  value='<c:out value="${cri.pageNum}"/>'> <input
                  type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
               <input type="hidden" name="type"
                  value='<c:out value="${cri.type}"/>'> <input type="hidden"
                  name="keyword" value='<c:out value="${cri.keyword}"/>'>

            </form>
         </div>
         <!-- /.panel-body -->
      </div>
      <!-- /.panel -->
   </div>
   <!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<!-- 댓글 목록 처리 시작 -->
<div class='row'>
   <div class="col-lg-12">
      <!-- /.panel -->
      <div class="panel panel-default">
         <div class="panel-heading">
            <i class="fa fa-comments fa-fw"></i> Reply
            <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
         </div>
         <!-- /.panel-heading -->
         <div class="panel-body">
            <ul class="chat" id="replycheck">
               <!--  Start reply -->
               <li class="left clearfix"   data-rno='12'>
                  <div>
                     <div class="header">
                        <strong class="primary-font">user00</strong> 
                        <small class="pull-right text-muted">2022-07-26 10:16</small>
                     </div>
                     <p>Good Job!</p>
                  </div>
               </li>
            </ul>
            <!-- ./ end ul -->
         </div>
         <!-- /.panel .chat-panel -->
         <div class="panel-footer"></div>
      </div>
   </div>
   <!-- ./ end row -->
</div>

<!-- 댓글 목록 처리 끝-->

<!-- 댓글 모달창 시작-->
<!-- <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
   data-target="#myModal">Open Modal</button> -->

<!-- Modal -->
<div id="myModal" class="modal fade" tabindex="-1" role="dialog">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
         </div>
         <div class="modal-body">
            <div class="form-group">
               <label>Reply</label> <input class="form-control" name='reply'
                  value='New Reply!!!'>
            </div>
            <div class="form-group">
               <label>Replyer</label> <input class="form-control" name='replyer'
                  value='replyer'>
            </div>
            <div class="form-group">
               <label>Reply Date</label> <input class="form-control"
                  name='replyDate' value='2022-07-22'>
            </div>
         </div>
         <div class="modal-footer">
            <button type="button" id='modalModBtn' class="btn btn-warning">Modify</button>
            <button type="button" id='modalRemoveBtn' class="btn btn-danger">Remove</button>
            <button type="button" id='modalRegisterBtn' class="btn btn-defalut"
               data-dismiss="modal">Register</button>
            <button type="button" id='modalCloseBtn' class="btn btn-info"
               data-dismiss="modal">Close</button>
         </div>
      </div>
   </div>
</div>
<!-- 댓글 모달창 끝-->

<script src="/resources/js/reply.js"></script>
<script>
   $(document).ready(function() {
                  console.log("Js Test.............");
                  var bnoValue = '<c:out value="${board.bno}"/>';
                  var replyUL = $(".chat");

                  /*Modal start*/
                  var modal = $(".modal");
                  var modalInputReply = modal.find("input[name='reply']");
                  var modalInputReplyer = modal.find("input[name='replyer']");
                  var modalInputReplyDate = modal.find("input[name='replyDate']");
                  var modalModBtn = $("#modalModBtn");
                  var modalRemoveBtn = $("#modalRemoveBtn");
                  var modalRegisterBtn = $("#modalRegisterBtn");

                  showList(1);
                  
                  /*댓글 수정 Start*/
                  modalModBtn.on("click", function(e){
                	  var reply = {rno : modal.data("rno"), reply : modalInputReply.val() };
                	  replyService.update(reply, function(result){
                		  alert("댓글 수정이 완료됬습니다 : " + result);
                		  modal.modal("show");
                		  showList(pageNum);
                	  });
                  });
                  /*댓글 수정 End*/
                  
                  /*댓글 삭제 Start*/
                  modalRemoveBtn.on("click", function (e){
  	  			 	var rno = modal.data("rno");
  					 replyService.remove(rno, function(result){
  	     			 	alert(result);
  	  				    modal.modal("hide");
  	 			    	 showList(pageNum);
  	 				 });
				  	});
                  /*댓글 삭제 End*/
                  
                  /* $("#modalCloseBtn").on("click", function(e) {

                     modal.modal('hide');
                  }); */
                  
                  /*
                  >>>>>> replyService.getList()메소드 실행하면  아래문장을 for문 문장으로  대체함.
                  <li class="left clearfix" data-rno='12'>
                     <div>
                        <div class="header">
                           <strong class="primary-font">user00</strong> 
                           <small class="pull-right text-muted">2022-07-26 10:16</small>
                        </div>
                        <p>Good Job!</p>
                     </div>
                  </li>
                  */
                  /* function showList(page) {
                     replyService.getList(   {bno : bnoValue, page : page || 1 }, function(list) {
                                    var str = " ";
                                    if (list == null  || list.length == 0) {
                                       replyUL.html("");
                                       return;
                                    }
                                    for (var i = 0, len = list.length || 0; i < len; i++) {  
                                       str += "<li class='left clearfix' data-rno= '"+list[i].rno+"'>";
                                       str += " <div>";
                                       str+=  "<div class='header'>";
                                       str+= "<strong class='primary-font'>[" + list[i].rno   + "] " + list[i].replyer + "</strong>";
                                       str += "<small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate)   + "</small></div>";
                                       str += "    <p>" + list[i].reply + "</p></div></li>";
                                    }
                                    replyUL.html(str);
                                 });
                  }  --> old showList*/
                  function showList(page) {
                     replyService.getList(   {bno : bnoValue, page : page || 1 }, function(replyCnt, list) {
                    	 			console.log("replyCnt : " + replyCnt);
                    	 			console.log("page : " + page);

                    	 			if(page ==  -1){
                    	 				pageNum = Math.ceil(replyCnt/10.0);
                    	 				showList(pageNum);
                    	 				return ;
                    	 			}
                    	 			var str = " ";
                                    if (list == null  || list.length == 0) {
                                       return;
                                    }
                                    
                                    for (var i = 0, len = list.length || 0; i < len; i++) {  /* <ul class="chat">(76라인) 삽입될 내용*/
                                       str += "<li class='left clearfix' data-rno= '"+list[i].rno+"'>";
                                       str += " <div>";
                                       str+=  "<div class='header'>";
                                       str+= "<strong class='primary-font'>[" + list[i].rno   + "] " + list[i].replyer + "</strong>";
                                       str += "<small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate)   + "</small></div>";
                                       str += "    <p>" + list[i].reply + "</p></div></li>";
                                    }
                                    console.log("replyCnt : "+ replyCnt);
                                    
                                    replyUL.html(str);
                                    
                                    showReplyPage(replyCnt);
                                 });
                  } 
                  /* end ShowList */
                  
                  /*댓글 클릭 이벤트 처리 start*/
                  $(".chat").on("click","li", function(e) { /*이벤트 위임처리*/
                                 var rno = $(this).data("rno");
                                 console.log("rno ----------------: "+ rno);
                                 replyService.get( rno, function(reply) {
                                                modalInputReply   .val(reply.reply);
                                                modalInputReplyer.val(reply.replyer);
                                                modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
                                                modal.data("rno", reply.rno);
                                                modal.find("button[id != 'modalCloseBtn']").hide();
                                                modalModBtn.show();
                                                modalRemoveBtn.show();
                                                $(".modal").modal("show");
                                             });
                  });

                  /*댓글 클릭 이벤트 처리 close*/

                  $("#addReplyBtn").on("click", function(e) {

                     modal.find("input").val("");
                     modalInputReplyDate.closest("div").hide();
                     modal.find("button[id !='modalCloseBtn']").hide();
                     modalRegisterBtn.show();
                     $("#myModalLabel .modal-title").text("댓글 등록");
                     $(".modal").modal("show");

                  });
                  /*Modal end*/

                  /*댓글 추가 Register*/
                  modalRegisterBtn.on("click", function(e) {
                     var reply = {
                        reply : modalInputReply.val(),
                        replyer : modalInputReplyer.val(),
                        bno : bnoValue
                     };
                     $("#myModalLabel .modal-title").text("댓글 등록");
                     replyService.add(reply, function(result) {
                        alert(result);
                        modal.find("input").val("");
                        modal.modal("hide");
/*                         showList(1); */
                        showList(-1);
                     });
                  });
                  
                  /*panel-footer Start*/
                  var pageNum = 1;
                  var replyPageFooter = $(".panel-footer");
                  
                  function showReplyPage(replyCnt){
                    var endNum = Math.ceil(pageNum / 10.0) * 10;  
                    var startNum = endNum - 9; 
                    var prev = startNum != 1;
                    var next = false;
                    
                    if(endNum * 10 >= replyCnt){
                      endNum = Math.ceil(replyCnt/10.0);
                    }
                    
                    if(endNum * 10 < replyCnt){
                      next = true;
                    }
                    
                    var str = "<ul class='pagination pull-right'>";
                    if(prev){
                      str+= "<li class='page-item'><a class='page-link' href='"+(startNum -1)+"'>Previous</a></li>";
                    }
                    
                    for(var i = startNum ; i <= endNum; i++){
                      var active = pageNum == i? "active":"";
                      str+= "<li class='page-item "+active+" '><a class='page-link' href='"+i+"'>"+i+"</a></li>";
                    }
                    
                    if(next){
                        str+= "<li class='page-item'><a class='page-link' href='"+(endNum + 1)+"'>Next</a></li>";
                      }
                      
                      str += "</ul></div>";
                      
                      replyPageFooter.html(str);
                    }
                  /*panel-footer End*/
					
                  /*새로운 댓글 가져오는 파트*/
                 replyPageFooter.on("click", "li a", function(e){
                	  e.preventDefault();
                	  console.log("page click");
                	  
                	  var targetPageNum = $(this).attr("href");
                	  console.log("targetPageNum : " + targetPageNum);
                	  pageNum = targetPageNum;
                	  showList(pageNum);
                  });
                  
                  
                  /*댓글 추가 Register closs*/
                  /* replyService.add( {reply:"js Test", replyer:"tester", bno:bnoValue},
                        function(result){ 
                           alert("Result : " + result);
                        }
                  ); */

                  /* replyService.getList({bno:bnoValue, page:1}, function(list){
                     for(var i=0, len=list.length || 0; i<len; i++){
                        console.log(list[i] + " : " + i );
                     }
                  }); */

                  //17번 삭제
                  /* replyService.remove(17, function(count) {

                     console.log(count);

                     if (count === "success") {
                       alert("REMOVED");
                     }
                   }, function(err) {
                     alert('ERROR...');
                   }); */

                  //17번 댓글 수정
                  /* replyService.update({
                   rno : 17,
                   bno : bnoValue,
                   reply : "Modified Reply.........."},
                   function(result){
                      alert("수정 완료....");
                   }
                  ) */

                  //17번 댓글 검색
                  /* replyService.get(17, function(data) {
                     console.log("data : " + data);
                     console.log("data.rno : " + data.rno);
                  }) */

               });
</script>

<script>
   var operForm = $("#operForm");

   $("button[data-oper='modify' ]").on("click", function(e) {
      operForm.attr("action", "/board/modify").submit();
   });

   $("button[data-oper=' list']").on("click", function(e) {
      operForm.find("#bno").remove();
      operForm.attr("action", "/board/list").submit();
   });
</script>











<%@ include file="../includes/footer.jsp"%>