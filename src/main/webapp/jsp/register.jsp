<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>Register</title>
		<script type ="text/javascript" src ="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	    <script type ="text/javascript" src ="${pageContext.request.contextPath}/js/my.js"></script>
	</head>
	<body>
		<script type="text/javascript">
		function  change(){
			var code = document.getElementById("VC");
			code.src = "checkcode.do?"+Math.random();	
		}
		//验证用户名是否存在
		$(document).ready(function(){
			$("#NM").blur(function(){
				var value = $("#NM").val();
				data = {name:value}
				$.ajax({
					 type : "post",
					 url : "./user/FName.do",
					 dataType : "json",
					 async:false,
					 data:JSON.stringify(data),//转JSON字符串
					 contentType:'application/json;charset=UTF-8',//contentType很重要
					 
					 success:function(data){
						var result = eval(data)
						//console.log(result.messsage);
						if("存在" !=result.message){
							$("#errId").text("");
						}else{
							$("#errId").text("用户名已存在");
							$("#NM").focus();
						}
					 }
				});			
			})
		})
		$(document).ready(function(){
			$("#PW").blur(function(){
				var result = $("#PW").lenstr("密码长度应为6~16个字符",$("#warnp"));
			})
			$("#SPW").blur(function(){
				var pw = $("#PW").val();
				var spw =$("#SPW").val();
				if(pw == spw){
					$("#warns").text("");
				}else{
					$("#warns").text("两次密码要一致");
					$("#SPW").text("");
				}
					
			})		
		})
		</script>
		
		
		<form action="./user/veregister.do" method ="post">
		       <span id ="errId" style ="color:red;"></span><br/><br/>
			姓名：&nbsp;<input id ="NM" name ="name"/><br/><br/>
			性别：&nbsp;男<input type ="radio" value ="男" name="gender" />&nbsp;女<input type ="radio" value ="女" name="gender" /><br/><br/>
			密码：&nbsp;<input type ="password" id="PW" name ="password"/><br/>
				 &nbsp;&nbsp;&nbsp;&nbsp;<span id ="warnp" style ="font-size:10px">6~16个字符，区分大小写</span><br/><br/>
		 确认密码：  &nbsp;<input type ="password" id ="SPW" name ="Spassword"/><br/>
		   		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id ="warns" style ="font-size:10px">请再次填写密码</span><br/><br/>
	      输入验证码：     &nbsp;<input id ="VCode" name ="vercode"/><img src ="checkcode.do" id ="VC" name ="vercode" onclick ="this.src ='checkcode.do?'+Math.random();"/><a  onclick="change()" href ="javascript:;">看不清？换一张</a><br/><br/>
		   		&nbsp;&nbsp;&nbsp;&nbsp;<input type ="submit" id ="Submit" name ="sm" value ="go!!!"/>
		</form>
		
		
	</body>
</html>