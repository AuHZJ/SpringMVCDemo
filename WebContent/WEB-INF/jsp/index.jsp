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
<title>index.jsp</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1>index.jsp</h1>
	<%-- <h1>${username }</h1> --%>
	<h1>${name }</h1>
	
	<h1>${username }</h1>
	<h1>${password }</h1>
	
 	 <h1>${msg }</h1>

	<h1>${user }</h1>
	<%--
	<h1>${user.id }</h1>
	
	<h1>${m }</h1>
	<h1>${map }</h1>
	<h1>${mm }</h1> --%>
</body>
</html>