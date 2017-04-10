<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <jsp:include page ="../common/AHead.jsp" flush="true"/><!-- 动态导入页面 -->
    <title>所有课程</title>
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
                <li  class="active"><a href="${pageContext.request.contextPath}/CourseManage">课程管理</a></li>
                <li><a href="${pageContext.request.contextPath}/ChooseManage">选课管理</a> </li>
                <li><a href="${pageContext.request.contextPath}/StuIndex">返回学生版主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->

    </div>
</nav>

<div class="container theme-showcase" role="main">

    <ol class="breadcrumb" style="margin-top: 100px">
        <li><a href="${pageContext.request.contextPath}/ToAdminIndex">首页</a></li>
        <li class="active">课程管理</li>
    </ol>
     <c:if test="${coumsg != null}">
    	<c:choose>
    		<c:when test="${coumsg =='修改成功!' ||coumsg =='删除成功!'||coumsg =='添加成功!'}">
                 <div class="alert alert-success" style="margin-top: 50px" role="alert">
    		</c:when>
        	<c:otherwise>
     			   <div class="alert alert-danger" style="margin-top: 50px" role="alert">
        	</c:otherwise>
    	</c:choose>
            <strong>${coumsg}
            </strong>
        </div>

        <%
        	session.removeAttribute("coumsg");
        %>
   </c:if>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>编号</th>
                <th>课程编号</th>
                <th>课程名</th>
                <th>任课教师</th>
                <th>开课学期</th>
                <th>课程学分</th>
                <th>所属社团</th>
                <th>开课地点</th>
                <th>已选人数/课程容量</th>
                <%--<th>课程描述</th>--%>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
           		<c:forEach var ="cou" items ="${coulist}" varStatus ="p">
        	  	 <tr>
            		<td>${p.index+1}</td>
            		<td>${cou.id}</td>
            		<td>${cou.name}</td>
            		<td>${cou.teacher}</td>
            		<td>${cou.time}</td>
            		<td>${cou.credit}</td>
            		<td>${cou.belong}</td>
            		<td>${cou.place}</td>
            		<td>${cou.selected}/${cou.amount}</td>
                <td><a href="${pageContext.request.contextPath}/ChangeCourse?id=${cou.id}" class="btn btn-primary">修改</a>
                	<a class="btn btn-danger" href="javascript:if(window.confirm('是否确认删除？')){window.location.href = '${pageContext.request.contextPath}/AdminDelCourse?id=${cou.id}';}">删除</a>
                </td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="9">&nbsp;</td>
                <td><a href="${pageContext.request.contextPath}/jsp/Admin/addCourse.jsp" class="btn btn-success">添加课程</a></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>

<script type="text/javascript" src="static/js/jquery-3.0.0.min.js"></script>

</body>
</html>
