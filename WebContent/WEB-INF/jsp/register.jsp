<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register.jsp</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1>register.jsp</h1>
	<!-- <form action="param/test9" method="post"> -->
	<form action="param/test5" method="post">
		<br>
		<input name="id" type="text" placeholder="请输入用户id">
		<br>
		<input name="name" type="text" placeholder="请输入用户名">
		<br>
		<input name="age" type="text" placeholder="请输入用户年龄">
		<br>
		<input name="dob" type="text" placeholder="请输入用户出生年月">
		<!-- 2018-11-16 -->
		<br>
		<input type="submit" value="提交">
	</form>
</body>
</html>