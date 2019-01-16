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
<title>ajax.jsp</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn1").on("click",function(){
			$.ajax({
				   //请求方式：GET，POST
				   type: "POST",
				   //请求路径 /
				   url: "request_body_param/test1",
				   data: "id=101&name=zs&age=18",
				   success: function(msg){
				     alert( "msg: " + msg );
				   }
			});
		});
		
		
		$("#btn2").on("click",function(){
			$.ajax({
				   //请求方式：GET，POST
				   type: "POST",
				   //请求路径 /
				   url: "request_body_param/test2",
				   data: "id=101&name=zs&age=18",
				   success: function(msg){
				     alert( "msg: " + msg );
				   }
			});
		});
		
		$("#btn3").on("click",function(){
			
			//var json = {id:101,name:"tom",age:18,dob:"2018-11-19"};
			var json = {};
			json.id=101;
			json.name="tom";
			json.age=18;
			json.dob="2018-11-19";
			//console.log(json);
			//console.log(typeof json);
			var jsonStr =  JSON.stringify(json);
			console.log(jsonStr);
			//console.log(typeof jsonStr);
			console.log(JSON.parse(jsonStr));
			$.ajax({
				   //请求方式：GET，POST
				   type: "POST",
				   //请求路径 /
				   url: "request_body_param/test3",
				   data: jsonStr,
				   //请求头中的Content-Type默认值是: application/x-www-form-urlencoded,表示当前请求中如果有数据的话,将会是key=value&key=value的形式
				   contentType:"application/json",
				   dataType:"json",
				   success: function(data){
					   alert("ss");
					 console.log(typeof data);
					 console.log("msg:"+data.msg);
					 
				   }
			});
		});
		
		$("#btn4").on("click",function(){
			var json = {id:101,name:"tom",age:18,dob:"2018-11-19"};
			$.ajax({
				   type: "POST",
				   url: "request_body_param/test4",
				   data: JSON.stringify(json),
				   contentType:"application/json",
				   dataType:"text",
				   success: function(data){
					 console.log(data);
				   }
			});
		});
		
		
		$("#btn5").on("click",function(){
			var json = {id:101,name:"tom",age:18,dob:"2018-11-19"};
			$.ajax({
				   type: "POST",
				   url: "request_body_param/test5",
				   data: JSON.stringify(json),
				   contentType:"application/json",
				   dataType:"json",
				   success: function(user){
					 console.log(user);
					 console.log(user.id);
					// $("#id").val(user.id);
					 console.log(user.name);
					 console.log(user.age);
					 console.log(user.dob);
				   }
			});
		});
		
		
		$("#btn6").on("click",function(){
			var json = {id:101,name:"tom",age:18,dob:"2018-11-19"};
			$.ajax({
				   type: "POST",
				   url: "request_body_param/test6",
				   data: JSON.stringify(json),
				   contentType:"application/json",
				   dataType:"json",
				   success: function(user){
					console.log(user);
					//遍历数组
					for(var i=0;i<user.length;i++){
						console.log(user[i].id+"*"+user[i].name);
					}
				   }
			});
		});
		
		$("#btn7").on("click",function(){
			var json = {id:101,name:"tom",age:18,dob:"2018-11-19"};
			$.ajax({
				   type: "POST",
				   url: "request_body_param/test7",
				   data: JSON.stringify(json),
				   contentType:"application/json",
				   dataType:"json",
				   success: function(user){
					console.log(user);
					//遍历数组
					for(var i=0;i<user.length;i++){
						console.log(user[i].id+"*7*"+user[i].name);
					}
					/* for(var arr in user){
						 console.log(arr+": "+user[arr].name);
					} */
				   }
			});
		});
		
		$("#btn8").on("click",function(){
			var json = {id:101,name:"tom",age:18,dob:"2018-11-19"};
			$.ajax({
				   type: "POST",
				   url: "request_body_param/test8",
				   data: JSON.stringify(json),
				   contentType:"application/json",
				   dataType:"json",
				   success: function(user){
					console.log(user);
					//遍历数组
					/* for(var arr in user){
						 console.log(arr+": "+user[arr].name);
						 for(var u in user[arr]){
						    console.log(u+": "+user[arr].u);
					     } 
					} */  
					$.each(user,function(k,v){
						console.log(k+": "+v);
						$.each(v,function(a,b){
							console.log(a+": "+b);
						});
					}); 
				   }
			});
		});
		
		
		$("#btn9").on("click",function(){
			var json = {id:101,name:"tom",age:18,dob:"2018-11-19"};
			$.ajax({
				   type: "POST",
				   url: "request_param_type/test1",
				   data: JSON.stringify(json),
				   contentType:"application/json",
				   dataType:"text",
				   success: function(user){
				 		console.log(user);
				   }
			});
		});
		
		$("#btn10").on("click",function(){
			//var json = {id:101,name:"tom",age:18,dob:"2018-11-19"};
			var arr = [];
			arr.push("hello");
			arr.push("world");
			$.ajax({
				   type: "POST",
				   url: "request_param_type/test2",
				   data: JSON.stringify(arr),
				   contentType:"application/json",
				   dataType:"text",
				   success: function(user){
				 		console.log(user);
				   }
			});
		});
		
		$("#btn11").on("click",function(){
			var json = {id:101,name:"tom",age:18,dob:"2018-11-19"};
			$.ajax({
				   type: "POST",
				   url: "request_param_type/test3",
				   data: JSON.stringify(json),
				   contentType:"application/json",
				   dataType:"text",
				   success: function(user){
				 		console.log(user);
				   }
			});
		});
		
		$("#btn12").on("click",function(){
			$.ajax({
				   type: "GET",
				   url: "request_param_type/test4",
				   data: "id=101&name=zs&age=22&dob=2018-11-19",
				   dataType:"text",
				   success: function(user){
				 		console.log(user);
				   }
			});
		});
		
		$("#btn13").on("click",function(){
			var user1 = {id:101,name:"tom1",age:18,dob:"2018-11-19"};
			var user2 = {id:102,name:"tom2",age:22,dob:"2018-11-19"};
			var user3 = {id:103,name:"tom3",age:29,dob:"2018-11-19"};
			var arr = [];
			
			arr.push(user1);
			arr.push(user2);
			arr.push(user3);
			$.ajax({
				   type: "POST",
				   url: "request_param_type/test4",
				   data: JSON.stringify(arr),
				   contentType:"application/json",
				   dataType:"text",
				   success: function(user){
				 		console.log(user);
				   }
			});
		});
		
		$("#btn14").on("click",function(){
			var user1 = {id:101,name:"tom1",age:18,dob:"2018-11-19"};
			var user2 = {id:102,name:"tom2",age:22,dob:"2018-11-19"};
			var user3 = {id:103,name:"tom3",age:29,dob:"2018-11-19"};
			var arr = [];
			
			arr.push(user1);
			arr.push(user2);
			arr.push(user3);
			$.ajax({
				   type: "POST",
				   url: "request_param_type/test5",
				   data: JSON.stringify(arr),
				   contentType:"application/json",
				   dataType:"text",
				   success: function(user){
				 		console.log(user);
				   }
			});
		});
		
		$("#btn15").on("click",function(){
			var user1 = {id:101,name:"tom1",age:18,dob:"2018-11-19"};
			var user2 = {id:102,name:"tom2",age:22,dob:"2018-11-19"};
			var user3 = {id:103,name:"tom3",age:29,dob:"2018-11-19"};
			var map = {};
			map[user1.name]=user1;
			map[user2.name]=user2;
			map[user3.name]=user3;
			
			map["1"]=user1;
			map["2"]=user2;
			map["3"]=user3;
			
			$.ajax({
				   type: "POST",
				   url: "request_param_type/test6",
				   data: JSON.stringify(map),
				   contentType:"application/json",
				   dataType:"text",
				   success: function(user){
				 		console.log(user);
				   }
			});
		});
		
	});
	
	
	
</script>

</head>
<body>
	<h1>ajax.jsp</h1>
	
	<input id="btn1" type="button" value="按钮1">
	<input id="btn2" type="button" value="按钮2">
	<input id="btn3" type="button" value="按钮3">
	
	<input id="btn4" type="button" value="按钮4">
	<input id="btn5" type="button" value="按钮5">
	
	<input id="btn6" type="button" value="按钮6">
	<input id="btn7" type="button" value="按钮7">
	<input id="btn8" type="button" value="按钮8">
	
	<hr>
	
	<input id="btn9" type="button" value="按钮9">
	<input id="btn10" type="button" value="按钮10">
	<input id="btn11" type="button" value="按钮11">
	<input id="btn12" type="button" value="按钮12">
	
	<input id="btn13" type="button" value="按钮13">
	<input id="btn14" type="button" value="按钮14">
	<input id="btn15" type="button" value="按钮15">
	<input id="btn16" type="button" value="按钮16">
</body>
</html>