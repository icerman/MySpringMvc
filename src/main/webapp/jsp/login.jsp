<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Login</title>
		<script type ="text/javascript" src ="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	    <script type ="text/javascript" src ="${pageContext.request.contextPath}/js/my.js"></script>
	</head>
	<body>
		<script type="text/javascript">
			
					
			$(document).ready(function(){
				$("#UName").blur(function(){
					var value = $("#UName").val();
					data ={name:value}
					$.ajax({
						 type : "post",
						 url : "./user/FName.do",
						 dataType : "json",
						 async:false,
						 data:JSON.stringify(data),//转JSON字符串
						 contentType:'application/json;charset=UTF-8',//contentType很重要   
						 
						 success : function(data) {
							var d = eval(data);
							//console.log(d.message);
							 if ("存在" != d.message) {
								$("#errId").text("用户名不存在");
								$("#UName").focus();
							 }else{
							 	$("#errId").text("");
							 }
						  }
					 });
				})
			})
			
		//验证输入框是否为空
		function check(){
				var a = false;
				var b = $("#UName").required("姓名不能为空",$("#errId"));
				if (b){
					var c = $("#Passw").required("密码不能为空",$("#errId"));
					if(c){
						a  = $("#VCode").required("验证码不能为空",$("#errId")); 
					}
				}
				return a;
			}
			
		$(function(){
			$("#Submit").click(function(){
				var a = check();
				//先验证用户名、密码、验证码是否为空，然后在验证验证码是否正确，最后在进行用户名和密码的验证
				if(a){
					var UValue = $("#UName").val();
					var PValue = $("#Passw").val();
					var CValue = $("#VCode").val();
					data ={'name':UValue,
							'password':PValue,
							'vercode':CValue}
					//alert(data);
					$.ajax({
						 type : "post",
						 url : "./user/VeCode.do",
						 dataType : "text",
						 async:false,
						 data:JSON.stringify(data),//转JSON字符串
						 contentType:'application/json;charset=UTF-8', //contentType很重要   
						 success : function(data){
						 	if ("codeerror" == data) {
						 		$("#errId").text("");
								$("#errcode").text("验证码错误");
								
							}else if("usererror" == data){
								$("#errcode").text("");
								$("#errId").text("用户名或密码错误");
							} else{
								window.location = data;
							} 
						 }
					});
				}
			})	
		})
		
		function checkcode(){
			var Ele = document.getElementById("code");
			Ele.src ="checkcode.do?"+Math.random();
		}
		
    	</script>
    	
    	
    	<form id ="Form"  method ="post">
    		<span id ="errId" style ="color:red;"></span><br/><br/>
    		姓&nbsp;名：<input id ="UName" name ="name"/><br/><br/>
    		密&nbsp;码：<input id ="Passw" name ="password"/><br/><br/>
    		<span id ="errcode" style ="color:red;"></span><br/><br/>
    		验证码：<input id ="VCode" name ="vercode"/>
    		<img id ="code" src="checkcode.do"  onclick ="this.src ='checkcode.do?'+Math.random();"/><a href ="javascript:;" onclick ="checkcode()">看不清换一张？</a><br/><br/>
    		<input type ="button" id ="Submit" name ="sm" value ="go"/>&nbsp; &nbsp; &nbsp;<a href ="registform.do" >注册账户</a>
    	</form>
    	
    	
	</body>
</html>