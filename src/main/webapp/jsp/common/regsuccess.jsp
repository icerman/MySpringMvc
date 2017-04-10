<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>Register</title>
		<script type ="text/javascript" src ="${pageContext.request.contextPath}/static/js/jquery-3.0.0.min.js"></script>
	    <script type ="text/javascript" src ="${pageContext.request.contextPath}/static/js/my.js"></script>
	</head>
	<body>
		<script type="text/javascript">
			var tim = 5;
			$(function(){
				setInterval("jump();",1000);
				//setTimeout()不能满足5-4-3-2-1的跳转
				//alert(tim);
			});
			
			function jump(){
				tim= tim-1;
				if(tim >0){
					//var text = document.getElementById("info");
					//text.innerHTML = "本窗口将在"+tim+"秒后自动关闭";
					$("#info").text("本窗口将在"+tim+"秒后自动关闭");
					
					//alert(text);
				}else{
					window.location="<%= request.getContextPath()%>/ToAdminIndex";
				}
				
			}
		</script>
	<center>
	登录成功！即将跳转到主页面<p>
	<div id="info">本窗口将在5秒后跳转</div>
	<a href ="<%= request.getContextPath()%>/ToAdminIndex.do">如没跳转，点击这里</a>
</center>
		
</html>