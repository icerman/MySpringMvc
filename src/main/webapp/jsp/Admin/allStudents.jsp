<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <jsp:include page ="../common/AHead.jsp" flush="true"/><!-- 动态导入页面 -->
    <title>所有学生</title>
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
                <li  class="active"><a href="${pageContext.request.contextPath}/StudentManage">学生管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/CourseManage">课程管理</a></li>
                <li><a href="${pageContext.request.contextPath}/ChooseManage">选课管理</a> </li>
                <li><a href="${pageContext.request.contextPath}/StuIndex">返回学生版主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->

    </div>
</nav>

<div class="container theme-showcase" role="main">

    <ol class="breadcrumb" style="margin-top: 100px">
        <li><a href="${pageContext.request.contextPath}/ToAdminIndex">首页</a></li>
        <li class="active">学生管理</li>
    </ol>
     <c:if test="${stumsg != null}">
    	<c:choose>
    		<c:when test="${stumsg =='修改成功!' ||stumsg =='删除成功!'||stumsg =='添加成功!'}">
                 <div class="alert alert-success" style="margin-top: 50px" role="alert">
    		</c:when>
        	<c:otherwise>
     			   <div class="alert alert-danger" style="margin-top: 50px" role="alert">
        	</c:otherwise>
    	</c:choose>
            <strong>${stumsg}
            </strong>
        </div>

        <%
        	session.removeAttribute("stumsg");
        %>
   </c:if>


        <table class="table table-striped">
            <thead>
            <tr>
                <th>编号</th>
                <th>学生姓名</th>
                <th>学号</th>
                <th>密码</th>
                <th>学院专业</th>
                <th>性别</th>
                <th>入学年份</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
           <c:forEach var ="stu" items ="${stulist}" varStatus ="p">
        	  	 <tr>
            		<td>${p.index+1}</td>
            		<td>${stu.name}</td>
            		<td>${stu.studentID}</td>
            		<td>${stu.pwd}</td>
            		<td>${stu.major}</td>
            		<td>${stu.gender}</td>
            		<td>${stu.year}</td>
                </td>
                <%--<td><a href="/changeStudent?id=<%=s.getId()%>" class="btn btn-primary" id="changeStu">修改</a>--%>
                <td><a href="${pageContext.request.contextPath}/ChangeStudent?id=${stu.id}" class="btn btn-primary" id="changeStu">修改</a>
                    <a href = "javascript:if(window.confirm('是否确认删除？')){window.location.href ='${pageContext.request.contextPath}/DelStudent?id=${stu.id}';}"class="btn btn-danger">删除</a>
                </td>
            </tr>
			</c:forEach>
            <tr>
                <td colspan="7">&nbsp;</td>
                <td><a href="${pageContext.request.contextPath}/jsp/Admin/addStudent.jsp" class="btn btn-success">添加新学生</a></td>
            </tr>

            </tbody>
        </table>
    </div>

</div>
<script type="text/javascript" src="static/js/jquery-3.0.0.min.js"></script>

</body>
</html>
