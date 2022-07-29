<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.uploadResult{
		width: 100%;
		background-color: gray;
	}
	
	.uploadResult ul {
		display: flex;
		flex-flow : row;
		justify-content: center;
		align-items: center;
	}
	
	.uploadResult ul li{
		list-style: none;
		padding:  10px;
		align-content: center;
		text-align: center;
	}
	
	.uploadResult ul li img{
		width : 100px;
	}
	.uploadResult ul li span{
		color: white;
	}
	.bigPictureWrapper {
		position: absolute;
		display: none;
		justify-content: center;
		align-items: center;
		top:0%; width: 100%; height: 100%;
		background-color: gray;
		z-index: 100;
		background: rgba(255,255,255,0,5);
	}
	.bigPicture {
		position: relative;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.bigPicture img{
		width: 600px; 
	}
</style>
</head>
<body>
	<h1>Upload with Ajax</h1>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple="multiple">
	</div>
	<div class="uploadResult">
		<ul>
		</ul>
	</div>
	<div id="bigPictureWrapper">
		<div id="bigPicture">
		</div>
	</div>
	<button id="uploadBtn">Upload</button>
	
<script>
	$(document).ready(function(){
		
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");  //정규표현식으로 표현..
		var maxSize = 5242880; //5MB
		var cloneObj = $(".uploadDiv").clone();
		
		//파일 확장자와 크기 설정 시작
		function checkExtension(fileName, fileSize){
				if(fileSize >= maxSize){
					alert("파일 사이즈 초과");
					return false;
				}
				
				if(regex.test(fileName)){
					alert("해당 확장자 파일은 업로드할 수 었습니다.");
					return false;
				}
				return true;
		}
		//파일 확장자와 크기 설정 끝
		
		var uploadResult = $(".uploadResult ul");
		
		function showUploadedFile(uploadResultArr){
			 var str = "";
			 
			 $(uploadResultArr).each(function(i,obj){
				if(!obj.image){
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
				 	str += "<li><a href='/download?fileName="+ fileCallPath +" '><img src='/resources/img/attach.png '>" + obj.fileName + "</a></li>";
				}else{
					//str += "<li>" + obj.fileName + "</li>";
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
					var originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
					originPath = originPath.replace(new RegExp(/\\/g), "/");
					str += "<li><a href=\"javascript:showImage(\'"+originPath+"\')\"><img src='/display?fileName="+fileCallPath+"'></a><li>";
				}
			 });
			 
			 uploadResult.append(str);
		 }
		 
		$("#uploadBtn").on("click", function(e){
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			console.log(files);
			
			for(var i=0; i<files.length; i++){
				if(!checkExtension(files[i].name, files[i].size)){
					return false;
				}
				formData.append("uploadFile", files[i]);
			}
			
			$.ajax({
				 url: '/uploadAjaxAction',
				 processData: false,
				 contentType: false,
				 data: formData,
				 type: 'POST',
				 dataType : 'json',
				 success: function(result){
					 console.log("result : " +result)
					 showUploadedFile(result);
					 $(".uploadDiv").html(cloneObj.html());
					 
				 }
			 }); //$.ajax
		}); //ready end
	}); // end for document
	
	//원본 이미지를 Show Start
	function showImage(fileCallPath){
		//alert("fileCallPath -> " +fileCallPath);
		$(".bigPictureWrapper").css("display", "flex").show();
		$(".bigPicture")
		.html("<img src='/display?fileName=" + encodeURI(fileCallPath)+" '>")
		.animate({width:'100%', height:'100%'},1000);
	} //end for showImage
	
	 $(".bigPictureWrapper").on("click", function(e){
		  $(".bigPicture").animate({width:'0%', height: '0%'}, 1000);
	 	  setTimeout(() => {
		    $(this).hide();
		 }, 1000); 
	 });
</script>	

</body>
</html>