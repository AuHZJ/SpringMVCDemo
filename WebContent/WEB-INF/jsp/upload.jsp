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
<title>upload.jsp</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<form action="upload/test" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="上传">
	</form>
</body>
</html>