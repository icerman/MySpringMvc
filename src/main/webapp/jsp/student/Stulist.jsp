<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
     <jsp:include page ="../common/application.jsp" flush="true"/>
    <title>学生列表</title>
</head>
<body>

<jsp:include page ="../common/mainpwd.jsp" flush="true"/>
<jsp:include page ="../common/pwd.jsp" flush="true"/>	
     <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/StuIndex.do">主页</a></li>
                <li><a href="${pageContext.request.contextPath}/ShowAllClasses">所有课程</a></li>
                <li><a href="${pageContext.request.contextPath}/ShowMyClasses">我的课程</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminLogin.do">管理员登录</a></li>
            </ul>   
       
       
            <c:choose>
            	<c:when test="${student != null}">
            		<ul class="nav navbar-nav navbar-right">
                		<li>
                			<a>${student.name} 欢迎您!</a>
                		</li>
                		<li><a id="change" href="#" data-toggle="modal"
                      	 	data-target="#myModal">修改密码</a></li>
                		<li><a href="${pageContext.request.contextPath}/logout">退出登录</a></li>
            		</ul>
            	
            	</c:when>
            	<c:otherwise>
            		<form class="navbar-form navbar-right">
                		<div class="form-group">
                			<span id ="errId" style ="color:red;"></span>
                    		<input type="text" id = "inputUsername" placeholder="学号" class="form-control" name="studentID" required>
                		</div>
                		<div class="form-group">
                    		<input type="password" id = "inputPassword" placeholder="密码" class="form-control" name="pwd" required>
                		</div>
                			<button type = "button" id = "Submit"  class="btn btn-success">登录</button>
            		</form>
            	</c:otherwise>
              </c:choose>
        </div><!--/.nav-collapse -->

    </div>
</nav>

<div class="container theme-showcase" role="main">
   
  <jsp:include page ="../common/changpwd.jsp" flush="true"/>	
  
<div class="container theme-showcase" role="main">
    <ol class="breadcrumb" style="margin-top: 100px">
        <li><a href="${pageContext.request.contextPath}/StuIndex.do">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/ShowDetail?id=${coudetail.id}">${coudetail.name}</a></li>
        <li class="active">已选学生列表</li>
    </ol>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>编号</th>
            <th>学生姓名</th>
            <th>学号</th>
            <th>学院专业</th>
        </tr>
        </thead>
        <tbody>
	<c:forEach var ="cou" items ="${stulist}" varStatus ="p">
	   <tr>
            <td>${p.index+1}</td>
            <td>${cou.name}</td>
            <td>${cou.studentID}</td>
            <td>${cou.major}</td>
        </tr>
	 
	 </c:forEach>	
        </tbody>
    </table>
</html>
