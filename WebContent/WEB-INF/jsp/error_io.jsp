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
<title>error_io.jsp</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1>error_io.jsp</h1>
	<!-- 因为spring中修改了异常的默认名字,所以这里是ex -->
	<%-- 	<% Exception ex = (Exception)request.getAttribute("ex"); %> 
		<H2>Exception: <%= ex.getMessage()%></H2> 
		<P/> 
		<% ex.printStackTrace(new java.io.PrintWriter(out)); %> 
		 --%>
		2.如果是EL显示错误信息
		<div>${ex }</div>
		<div>${ex.message }</div>
</body>
</html>