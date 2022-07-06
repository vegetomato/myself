<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form:form action="register" id="registerForm" modelAttribute="board">
	<div class="hiddenArea"></div>
	제목 : <form:input type="text" path="title" />
		<form:errors path="title" class="error" element="div" />
		<br>
	내용 :<br>
		<form:textarea rows="30" cols="50" path="content" />
		<br>
	작성자 : <form:input type="text" path="writer" />
		<form:errors path="writer" />
		<br>
		<button>등록</button>
	</form:form>
  
	<div class="row my-5">
		<div class="col-lg-12">
			<div class="card">
				<div class="card-header">
					<h4>파일 첨부</h4>
				</div>
				<div class="panel-body">
					<div class="form-group uploadDiv">
						<input type="file" name="uploadFile" multiple="multiple">
					</div>
					<div class="uploadResult">
						<ul class="list-group"></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script>
let regex = new RegExp("(.*?)\.(exe|sh|js|alz)$")
let maxSize = 5242880;

function checkExtension(fileName, fileSize){
   if(fileSize >= maxSize){
      alert('파일 크기 초과');
      return false;
   }
   if(regex.test(fileName)){
      alert('허용되지 않는 확장자');
      return false;
   }
   return true;
}
let uploadResult = $('.uploadResult ul');
function showUploadResult(uploadResultArr){
	   if(!uploadResultArr || uploadResultArr.length==0) return;
	   let str = "";
	   $(uploadResultArr).each(function(i,obj){
		   if(!obj.fileType){ //이미지가 아닌경우
		   		let fileCellPath = encodeURIComponent(obj.uploadPath + "/"+ obj.uuid + "_" + obj.fileName);
		   		//전송하기 위해 li태그로 묶었다?? 
		   		str+= "<li class = 'list-group-item' data-path='"+obj.uploadPath+"'";
		   		str+= "data-uuid='"+obj.uuid+"'data-filename='"+obj.fileName+"' data-type="+obj.fileType+">"
		   		str+= "<img src='${contextPath}/resources/img/attach.png' style = 'width:50px '>"
		   		str+= "<a href='${contextPath}/download?fileName="+fileCellPath+"'>"+obj.fileName+"</a>"
		   		str+= "<div class = 'd-flex justify-content-end'><span data-file='"+fileCellPath+"' data-type='file'>삭제</span>"
		   		str+= "</li>"
			   
		   }else { //이미지인 경우
			   let fileCellPath = encodeURIComponent(obj.uploadPath + "/s_"+ obj.uuid + "_" + obj.fileName);
		   	   let originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
		   	   originPath = originPath.replace(new RegExp(/\\/g),"/");
		   	   		
	   			str+= "<li class = 'list-group-item' data-path='"+obj.uploadPath+"'";
   				str+= "data-uuid='"+obj.uuid+"'data-filename='"+obj.fileName+"' data-type="+obj.fileType+">"
	   	   		str += "<img src='${contextPath}/display?fileName="+fileCellPath+"'>";
	   			str +="<a href ='javascript:showImage(\""+originPath+"\")'>이미지 원본 보기</a>";
	   			str +="<div class = 'd-flex justify-content-end'><span data-file='"+fileCellPath+"' data-type='image'>삭제</span>"
	   	   		str += "</ii>";
		   }
		   
	   })
	   uploadResult.append(str);
  }


$(function(){
	let form = $('#registerForm');
	let submitBtn = $('#registerForm button')
	
	//글쓰기 처리
	submitBtn.on('click',function(e){
		
		let str = "";
		$('.uploadResult li').each(function(i,obj){
			let jobj = $(obj);
			console.log(jobj.data('filename'));
			
			str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data('filename')+"'/>"
			str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data('uuid')+"'/>"
			str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data('path')+"'/>"
			str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data('type')+"'/>"
		});
		form.append(str).submit;
	})
	
	//파일 업로드
	$('input[type = "file"]').change(function(){
		let formData = new FormData();
		let inputFiles = $('input[name = "uploadFile"]');
		let files = inputFiles[0].files;
		
		for(let f of files){
			if(!checkExtension(f.name, f.size)) return false;
			formData.append('uploadFile',f);
		}
		
		$.ajax({
			url : contextPath + '/uploadAjaxAction',
			// RestController에 있는 것 
			type : 'post',
			processData : false, 
			contentType : false,
			data : formData,
			dataType : 'json',
			success : function(result){
				showUploadResult(result);
			}
		});
	})
	$('.uploadResult ul').on('click','span',function(){
		let targetFile = $(this).data('file');
		let type = $(this).data('type');
		let targetLi = $(this).closest('li')
			
		$.ajax({
			url : contextPath + '/deleteFile',
			type : 'post',
			data : {fileName : targetFile, type : type},
			dataType : 'text',
			success : function(result){
				alert(result);
				targetLi.remove();
			}
			
		})	
	})

/* 	let checked = false;	
	$('#test').on('change',function(){
		if(!checked){
			checked = true;
			alert('체크')
		}else{
			checked = false;
			alert('해제')
		}
	}) */
	
})
</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
