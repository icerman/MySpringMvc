<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html> 
	<body>
<script type="text/javascript">
		
	function check(){
		var a = false;
		var b = $("#inputUsername").required("学号不能为空",$("#errId"));
		if (b){
			var a = $("#inputPassword").required("密码不能为空",$("#errId"));
			
		}
		return a;
	}
	
	$(function(){
			$("#Submit").click(function(){
				var a = check();
				if(a){
					var UValue = $("#inputUsername").val();
					var PValue = $("#inputPassword").val();
					
					data ={'studentID':UValue,
							'pwd':PValue,
							}
					//alert(data);
					$.ajax({
						 type : "post",
						 url : "${pageContext.request.contextPath}/Stulogin.do",
						 dataType : "text",
						 async:false,
						 data:JSON.stringify(data),//转JSON字符串
						 contentType:'application/json;charset=UTF-8', //contentType很重要   
						 success : function(data){
						  	if("unfind" == data){
								$("#errId").text("用户名或密码错误");
							} else{
								window.location = "${pageContext.request.contextPath}/"+data;
							} 
						 }
					});
				}
			});
		});
	$(function(){
		$("#Subm").click(function(){
		
			var oldpwd = $("#old").val();
			var newpwd = $("#newpwd").val();
			var newagain = $("#newagain").val();

			data ={'oldpwd':oldpwd,
					'newpwd':newpwd,
					'newagain':newagain,
			         }
			$.ajax({
				type : "post",
				 url : "${pageContext.request.contextPath}/ChangePwd.do",
				 dataType : "text",
				 async:false,
				 data:JSON.stringify(data),//转JSON字符串
				 contentType:'application/json;charset=UTF-8', //contentType很重要   
				 success : function(data){
				  	if("olderror" == data){
						$("#errId").text("旧密码不正确");
					}else if("newerror" == data){
						$("#errId").text("两次密码输入不一致");
					}else if("nullerror" ==data){
						$("#errId").text("输入框不能为空");
					}
					else{
						window.location = "${pageContext.request.contextPath}/"+data;
					} 
				 }
			});
		});
		
	});
	</script>
</body>

</html> 