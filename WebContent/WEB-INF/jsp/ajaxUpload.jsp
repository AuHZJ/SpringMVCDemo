<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajaxUpload.jsp</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript">
	$(function(){
		$("input:button").on("click",function(){
			if(!$("input:file").val()){ // "" Boolean("")
				alert("请选择上传文件");
				return;
			}
			ajaxFileUpload();
			
		});
	});
	
	function ajaxFileUpload(){
		//alert("ajaxFileUpload");
		$.ajaxFileUpload(
			{
				type: "POST",
				url: 'ajax_upload/test',
				secureuri: false,
				fileElementId: 'myfile',
				dataType: 'text',
				success: function (data){
					$("input:file").val("");
					$("#sp").html(data).css("color","green");
				},
				error: function (data){
					$("#sp").html(data).css("color","red");
				}
			}
		);
	}
</script>
</head>
<body>
	<!-- ajax上传不需要表单 -->
		<!-- 这个上传框的id值一定要写,需要和js中的设置对应 -->
		<input id="myfile" type="file" name="myfile"><br>
		<input type="button" value="上传"><br>
		<span id="sp"></span>
</body>
</html>