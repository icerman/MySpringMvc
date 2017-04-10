<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <jsp:include page ="../common/AHead.jsp" flush="true"/><!-- 动态导入页面 -->
    <title>新课程信息</title>
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
                <li ><a href="${pageContext.request.contextPath}/StudentManage">学生管理</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/CourseManage">课程管理</a></li>
                <li><a href="${pageContext.request.contextPath}/ChooseManage">选课管理</a> </li>
                <li><a href="${pageContext.request.contextPath}/StuIndex">返回学生版主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->

    </div>
</nav>


<div class="container">
    <form action="${pageContext.request.contextPath}/AddCourse" method="post" enctype="multipart/form-data">
        <h3>新课程信息</h3>
        <div class="form-group">
            <label for="name">课程名</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="课程名" required>
        </div>
        <div class="form-group">
            <label for="time">开课学期</label>
            <input type="text" class="form-control" id="time" name="time" placeholder="开课学期" required>
        </div>
        <div class="form-group">
            <label for="credit">课程学分</label>
            <input type="text" class="form-control" id="credit" name="credit" placeholder="课程学分" required>
        </div>
        <div class="form-group">
            <label for="teacher">任课老师</label>
            <input type="text" class="form-control" id="teacher" name="teacher" placeholder="任课老师" required>
        </div>
        <div class="form-group">
            <label for="belong">所属社团</label>
            <input type="text" class="form-control" id="belong" name="belong" placeholder="所属社团" required>
        </div>
        <div class="form-group">
            <label for="place">开课地点</label>
            <input type="text" class="form-control" id="place" name="place" placeholder="开课地点" required>
        </div>
        <div class="form-group">
            <label for="amount">课程容量</label>
            <input type="text" class="form-control" id="amount" name="amount" placeholder="课程容量" required>
        </div>
        <div class="form-group">
            <label for="detail">课程描述</label>
            <input type="text" class="form-control" id="detail" name="detail" placeholder="课程描述" required>
        </div>
        <div class="form-group">
            <input type="file" id="myfile" name="myfile" required>
        </div>
        <button type="submit" class="btn btn-success">提交</button>
        <a href="${pageContext.request.contextPath}/CourseManage" class="btn btn-default">返回</a>
    </form>
</div>
</body>
</html>
