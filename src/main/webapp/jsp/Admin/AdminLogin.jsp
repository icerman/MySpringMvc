<%--
  Created by IntelliJ IDEA.
  User: cyan
  Date: 16/7/7
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page ="../common/AHead.jsp" flush="true"/><!-- 动态导入页面 -->
    <title>管理员登陆</title>
    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin .checkbox {
            font-weight: normal;
        }
        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>
<body>

<script type="text/javascript">
   
    function checkcode(){
		var Ele = document.getElementById("code");
		Ele.src ="${pageContext.request.contextPath}/checkcode.do?"+Math.random();
	}

	//验证输入框是否为空
	function check(){
			var a = false;
			var b = $("#inputUsername").required("姓名不能为空",$("#errId"));
			if (b){
				var c = $("#inputPassword").required("密码不能为空",$("#errId"));
				if(c){
					a  = $("#inputVercode").required("验证码不能为空",$("#errcode")); 
				}
			}
			return a;
		}
		
	$(function(){
		$("#Submit").click(function(){
			var a = check();
			//先验证用户名、密码、验证码是否为空，然后在验证验证码是否正确，最后在进行用户名和密码的验证
			if(a){
				var UValue = $("#inputUsername").val();
				var PValue = $("#inputPassword").val();
				var CValue = $("#inputVercode").val();
				
				data ={'name':UValue,
						'pwd':PValue,
						'vercode':CValue}
				//alert(data);
				$.ajax({
					 type : "post",
					 url : "${pageContext.request.contextPath}/VeAdmin.do",
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
							window.location = "${pageContext.request.contextPath}/"+data;
						} 
					 }
				});
			}
		})	
	})
    </script>

<div class="container">

    <form class="form-signin"  method="post">
        <h2 class="form-signin-heading">管理员登录</h2>
        <span id ="errId" style ="color:red;"></span>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" name="username" id="inputUsername" class="form-control" placeholder="用户名" required autofocus><br/>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="密码" required>
        <input type="vercode" name="vcd" id="inputVercode"  style="padding: 10px;width:90px;" placeholder="验证码"/>
        <img style="height: 40px;width:95px;" id ="code" src="${pageContext.request.contextPath}/checkcode.do"  onclick ="this.src ='${pageContext.request.contextPath}/checkcode.do?'+Math.random();"/>&nbsp;<a href ="javascript:;" onclick ="checkcode()">看不清换一张？</a><br/><br/>
        <span id ="errcode" style ="color:red;"></span>
        <button class="btn btn-lg btn-primary btn-block" id = "Submit" type="button">登录</button>
    </form>

</div>
</body>
</html>
