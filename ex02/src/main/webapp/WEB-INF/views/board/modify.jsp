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
                           Board Modify Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                        	<form role="form"  action="/board/modify"  method="post">
								<div class="from-group">
									<label>Bno</label>
									<input class="form-control"  name="bno"  readonly="readonly"  value='<c:out value="${board.bno}"/>' ><br>
								</div>
								
								<div class="from-group">
									<label>Title</label>
									<input class="form-control"  name="title"  value='<c:out value="${board.title}"/>' ><br>
								</div>
							
								<div class="from-group">
									<label>Text area</label>
									<textarea class="form-control"   rows="3"  name="content"  >
									<c:out value="${board.content}"/></textarea><br>
								</div>
							
								<div class="from-group">
									<label>Writer</label>
									<input class="form-control"  name="writer"  readonly="readonly" value='<c:out value="${board.writer}"/>' ><br>
								</div>
								
								<div class="from-group">
									<label>RegDate</label>
									<input class="form-control"  name='regdate'  readonly="readonly" 
									value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate }"/>' ><br>
								</div>
								
								<div class="from-group">
									<label>UpdateDate</label>
									<input class="form-control"  name='updatedate'  readonly="readonly" 
									value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updatedate }"/>' ><br>
								</div>
			
								<button type="submit"  data-oper='modify' class="btn btn-default">Modify</button>												    
								<button type="submit"   data-oper='remove' class="btn btn-danger">Remove</button>												    
								<button type="submit"  data-oper='list' class="btn btn-info">List</button>												    
							    
						    </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
 <script type="text/javascript">
 		$(document).ready(function(){
 			
 			var formObj = $("form");
 			
 			$('button').on("click", function(e){
 				e.preventDefault();
 				
 				var operation = $(this).data('oper');
 				console.log(operation);
 				
 				if(operation === 'remove'){
 					formObj.attr("action", "/board/remove");
 				}else if(operation === 'list'){
 				//	self.location = "/board/list";
 				formObj.attr("action", "/board/list").attr("method","get");
 				formObj.empty();
 				}
 				formObj.submit();
 			});
 		});
 </script>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 <%@ include file="../includes/footer.jsp" %>