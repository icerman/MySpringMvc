
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page ="../common/application.jsp" flush="true"/>
    <title>课程详情</title>
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
        <li class="active">课程详情</li>
    </ol>
   
     <c:if test="${selectmsg != null}">
    	<c:choose>
    		<c:when test="${selectmsg =='选课成功!'}">
                 <div class="alert alert-success" style="margin-top: 50px" role="alert">
    		</c:when>
        	<c:otherwise>
     			   <div class="alert alert-danger" style="margin-top: 50px" role="alert">
        	</c:otherwise>
    	</c:choose>
    	<strong>
            	${selectmsg}
        </strong>
                </div>
 		<%
                session.removeAttribute("selectmsg");
            
        %>
    </c:if>
    
    
    <div class="container">

        <div class="page-header">
            <h1>${coudetail.name}
            </h1>
        </div>
        <div class="col-md-8">
            <div class="well">
                ${coudetail.detail}
            </div>
			
			 <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">任课教师</h3>
                </div>
                <div class="panel-body">
                   ${coudetail.teacher}
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">课程所属社团</h3>
                </div>
                <div class="panel-body">
                   ${coudetail.belong}
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">课程学分</h3>
                </div>
                <div class="panel-body">
                   ${coudetail.credit}
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">课程已选人数/容量</h3>
                </div>
                <div class="panel-body">
                    ${coudetail.selected}&nbsp;/&nbsp;${coudetail.amount}
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">上课地点</h3>
                </div>
                <div class="panel-body">
                    ${coudetail.place}
                </div>
            </div>
        </div>

        <div class="col-md-4">
        	<img  src="${pageContext.request.contextPath}/ShowImage?filename=${coudetail.teacher}" style="height: 280px; width:350px;"alt="####"/>
            <br/><br/><br/>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">课程操作</h3>
                </div>
                <div class="panel-body">
                    <c:choose>
                    	<c:when test="${empty student}">
                    			 请先登录!
                    	</c:when>
                    	<c:otherwise>
                    		<div class="row" style="text-align: center">
                      		  			<div class="col-sm-2">
                    	  <c:choose>
                    	  		<c:when test="${empty semsg}">
                            	    <a class="btn btn-primary" href="${pageContext.request.contextPath}/SelectClz?id=${coudetail.id}">选课</a>
								</c:when>
                    	  		<c:otherwise>
                    	  			<button class="btn btn-primary">${semsg}</button>
                    	  		</c:otherwise>
                    	  </c:choose>
                    				</div>
                        		<div class="col-sm-2">
                            	<a class="btn btn-default" href="${pageContext.request.contextPath}/ShowStudent?id=${coudetail.id}">查看已选名单</a>
                        	</div>
                    	</div>
                    	</c:otherwise>
                    </c:choose>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
