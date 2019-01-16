<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据验证</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1>validate.jsp</h1>
	<sf:form method="post" modelAttribute="teacher">
			<sf:label path="name">用户名:</sf:label> 
			<sf:input path="name"/>
			<sf:errors path="name" cssStyle="color:red"></sf:errors><br>

			<sf:label path="age"> 年   龄:</sf:label>
			<sf:input path="age"/>
			<sf:errors path="age" cssStyle="color:red"></sf:errors><br>

			<sf:label path="dob"> 生   日:</sf:label>  
			<sf:input path="dob"/>
			<sf:errors path="dob" cssStyle="color:red"></sf:errors><br>

			<input type="submit" value="提交"/>
		</sf:form>
	
</body>
</html>