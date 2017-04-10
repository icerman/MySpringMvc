
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <jsp:include page ="../common/AHead.jsp" flush="true"/><!-- 动态导入页面 -->
    <title>新学生信息</title>
    <style>
        body {
            padding-top: 100px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        form {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">学生社团管理系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/ToAdminIndex">主页</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/StudentManage">学生管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/CourseManage">课程管理</a></li>
                <li><a href="${pageContext.request.contextPath}/ChooseManage">选课管理</a> </li>
                <li><a href="${pageContext.request.contextPath}/StuIndex">返回学生版主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->

    </div>
</nav>

 <c:if test="${Addstumsg != null}">
        <center>
        	<div style="color:blue;font-size:130%;">
    		<strong >
            	${Addstumsg}
        	</strong>
        	</div>
        </center>
 		<%
                session.removeAttribute("Addstumsg");
        %>
 </c:if>

<div class="container">
    <form action="${pageContext.request.contextPath}/AddStudent" method="post">
        <h3>新学生信息</h3>
        <div class="form-group">
            <label for="studentID">学生学号&nbsp;<span id ="errId" style ="color:red;"></span></label>
            <input type="text" class="form-control" id="studentID" name="studentID" placeholder="学号" required>
        </div>
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="姓名" required>
        </div>
        <div class="form-group">
            <label for="pwd">密码</label>
            <input type="text" class="form-control" id="pwd" name="pwd" placeholder="密码" required>
        </div>
        <div class="form-group">
            <label for="boy">性别</label>&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="gender" value="男" id="boy" checked="true">男
            <input type="radio" name="gender" value="女" id="girl">女
        </div>
         <div class="form-group">
            <label for="age">密码</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="年龄" required>
        </div>
        <div class="form-group">
            <label for="major">学院专业</label>
            <input type="text" class="form-control" id="major" name="major" placeholder="学院专业" required>
        </div>

        <div class="form-group">
            <label for="year">学年</label>
            <input type="text" class="form-control" id="year" name="year" placeholder="学年" required>
        </div>
        <button type="submit" class="btn btn-success">提交</button>
        <a href="${pageContext.request.contextPath}/StudentManage" class="btn btn-default">返回</a>
    </form>
</div>
<script type="text/javascript">

$(function(){
	$("#studentID").blur(function(){
			var UValue = $("#studentID").val();
			
			data ={'studentID':UValue
					}
			//alert(data);
			$.ajax({
				 type : "post",
				 url : "${pageContext.request.contextPath}/CheckStudent",
				 dataType : "text",
				 async:false,
				 data:JSON.stringify(data),//转JSON字符串
				 contentType:'application/json;charset=UTF-8', //contentType很重要   
				 success : function(data){
				  	if("ok" == data){
						$("#errId").text("该学号已经存在");
					}else{
						$("#errId").text("");
					}
				 }
			});
	});
});

</script>
</body>
</html>
