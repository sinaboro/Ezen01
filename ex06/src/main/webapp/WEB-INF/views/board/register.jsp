<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Rigister</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/register" method="post">
					<div class="from-group">
						<label>Title</label><input class="form-control" name="title"><br>
					</div>
					<div class="from-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content"></textarea>
						<br>
					</div>
					<div class="from-group">
						<label>Writer</label><input class="form-control" name="writer"><br>
					</div>

					<button type="submit" class="btn btn-default">Submit</button>
					<button type="reset" class="btn btn-default">Reset Button</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">File Attach</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
					<div class="from-group uploadDiv">
						<input type="file" name="uploadFile" multiple="multiple"><br>
					</div>
					<div class="uploadResult">
						<ul>
						</ul>
					</div>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

 <script>
 	$(document).ready(function(){
 		
 		var formObj = $("form[role='form']");
 	
 		$("button[type='submit']").on("click", function(e){
 			e.preventDefault();
 			console.log("sumbit clicked");
 			 var str = "";
 		    
 		    $(".uploadResult ul li").each(function(i, obj){
 		      var jobj = $(obj);
 		      console.dir(jobj);
 		      console.log("-------------------------");
 		      console.log(jobj.data("filename"));
 		      str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
 		      str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
 		      str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
 		      str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+ jobj.data("type")+"'>";
 		    });
 		    console.log(str);
 		    console.log(formObj.append(str));
 		    formObj.append(str).submit();
 		});
 		
 		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
 		var maxSize = 5242880;
 		
 		function checkExtension(fileName, fileSize){
 			if(fileSize>maxSize){
 				alert("파일 사이즈 초과");
 				return false;
 			}
 			
 			if(regex.test(fileName)){
 				alert("해당 종류의 파일은 업로드할 수 없습니다.");
 				return false;
 			}
 			return true;
 		} // end for checkExtension
 		
 		$("input[type='file']").change(function(e){
 			var formData = new FormData();
 			var inputFile = $("input[name='uploadFile']");
 			var files = inputFile[0].files;
 			console.log("inputFile : " + inputFile);
 			console.log("files : " + files);
 			
 			for(var i=0; i<files.length; i++){
 				if(!checkExtension(files[i].name, files[i].size)) return false;
 				
 				formData.append("uploadFile", files[i]);
 			}
 			
 			$.ajax({
 				url : '/uploadAjaxAction',
 				processData : false,
 				contentType : false,
 				data : formData,
 				type : 'post',
 				dataType : 'json',
 				success : function(result){
 					console.log("upload result : " + result);
 					showUploadResult(result);
 				}
 			}); //end for ajax
 			
 		}); //end for change
 		
 		function showUploadResult(uploadResultArr){
 			if(!uploadResultArr || uploadResultArr.length == 0 ) return ;
 			
 			var uploadUL = $(".uploadResult ul");
 			var str="";
 			
 			$(uploadResultArr).each(function(i, obj){
 				if(obj.image){
 					var fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid +"_"+obj.fileName);
 					str += "<li data-path='"+obj.uploadPath+"'";
 					str +=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'"
 					str +" ><div>";
 					str += "<span> "+ obj.fileName+"</span>";
 					str += "<button type='button' data-file=\'"+fileCallPath+"\' "
 					str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
 					str += "<img src='/display?fileName="+fileCallPath+"'>";
 					str += "</div>";
 					str +"</li>";
 				}else{
 					var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);			      
 				    var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
 				      
 					str += "<li "
 					str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"' ><div>";
 					str += "<span> "+ obj.fileName+"</span>";
 					str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' " 
 					str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
 					str += "<img src='/resources/img/attach.png'></a>";
 					str += "</div>";
 					str +"</li>";
 				}
 			});
 			return uploadUL.append(str);
 		}// end for showUploadResult
 		
 		$(".uploadResult").on("click", "button", function(e){
 			console.log("delete file");
 			var targetFile = $(this).data("file");
 			var type = $(this).data("type");
 			
 			var targetLi = $(this).closest("li");
 			
 			$.ajax({
 				url : '/deleteFile',
 				data : {fileName:targetFile, type:type},
 				dataType:'text',
 				type : 'post',
 				success : function(result){
 					alert(result);
 					targetLi.remove();
 				}
 			});//end for ajax
 		}); //end for uploadResult
 		
 	});
 </script>
<%@ include file="../includes/footer.jsp"%>