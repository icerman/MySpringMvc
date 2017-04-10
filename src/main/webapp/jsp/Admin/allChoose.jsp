<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page ="../common/AHead.jsp" flush="true"/><!-- 动态导入页面 -->
    <title>选课记录</title>
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
                <li><a href="${pageContext.request.contextPath}/AdminIndex">主页</a></li>
                <li><a href="${pageContext.request.contextPath}/StudentManage">学生管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/CourseManage">课程管理</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/ChooseManage">选课管理</a> </li>
                <li><a href="${pageContext.request.contextPath}/StuIndex">返回学生版主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->

    </div>
</nav>

<div class="container theme-showcase" role="main">

    <ol class="breadcrumb" style="margin-top: 100px">
        <li><a href="${pageContext.request.contextPath}/AdminIndex">首页</a></li>
        <li class="active">选课管理</li>
    </ol>
<c:if test="${studymsg != null}">
    	<c:choose>
    		<c:when test="${studymsg =='添加成功!'||studymsg =='删除成功!'}">
                 <div class="alert alert-success" style="margin-top: 50px" role="alert">
    		</c:when>
        	<c:otherwise>
     			   <div class="alert alert-danger" style="margin-top: 50px" role="alert">
        	</c:otherwise>
    	</c:choose>
            <strong>${studymsg}
            </strong>
        </div>

        <%
        	session.removeAttribute("studymsg");
        %>
</c:if>
        <table class="table table-striped">
            <thead>
            <tr>
           		<th>编号</th>
             	<th>课程名/课程编号</th>
                <th>所属社团</th>
                <th>学分</th>
                <th>开课学期</th>
                <th>学生姓名</th>
                <th>学号</th>
                <th>学院专业</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
               <c:forEach var ="cou" items ="${studylist}" varStatus ="p">
        	  	 <tr>
        	  	 	<td>${p.index+1}</td>
            		<td>${cou.cname}/${cou.cid}</td>
            		<td>${cou.cbelong}</td>
            		<td>${cou.ccredit}</td>
            		<td>${cou.ctime}</td>
            		<td>${cou.sname}</td>
            		<td>${cou.sid}</td>
            		<td>${cou.smajor}</td>
            		
                <td>
                    <a class="btn btn-danger" href="javascript:if(window.confirm('是否确认删除？')){window.location.href = '${pageContext.request.contextPath}/DelStudyInfo?id=${cou.id}';}">删除</a>
                </td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="8">&nbsp;</td>
                <td>
                    <button class="btn btn-success" data-toggle="modal"
                            data-target="#myModal">添加选课记录
                    </button>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                       		 添加选课记录
                    </h4>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/AddChoose" method="post">
                        <div class="form-group">
                            <label for="stuId">学生学号</label>
                            <input type="text" class="form-control" id="stuId" name="stuId" placeholder="学号" required>
                        </div>
                        <div class="form-group">
                            <label for="clzId">课程编号</label>
                            <input type="text" class="form-control" id="clzId" name="clzId" placeholder="课程编号" required>
                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-success" value="提交">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">关闭
                            </button>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
</body>
</html>
