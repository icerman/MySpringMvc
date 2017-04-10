<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html> 
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
                <li class="active"><a href="${pageContext.request.contextPath}/ToAdminIndex">主页</a></li>
                <li><a href="${pageContext.request.contextPath}/StudentManage">学生管理</a></li>
                <li><a href="${pageContext.request.contextPath}/CourseManage">课程管理</a></li>
                <li><a href="${pageContext.request.contextPath}/ChooseManage">选课管理</a></li>
                <li><a href="${pageContext.request.contextPath}/StuIndex">返回学生版主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->

    </div>
</nav>
 </body>
 </html> 