<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page ="../common/application.jsp"/>
    <title>首页</title>
</head>

<body >
	
 <jsp:include page ="../common/mainpwd.jsp" flush="true"/>
 <jsp:include page ="../common/pwd.jsp" flush="true"/>	
     <div id="navbar" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
             <li  class="active"><a href="${pageContext.request.contextPath}/StuIndex">主页</a></li>
             <li ><a href="${pageContext.request.contextPath}/ShowAllClasses">所有课程</a></li>
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

    <c:if test="${msg != null}">
    	<c:choose>
    		<c:when test="${msg =='修改成功'}">
                 <div class="alert alert-success" style="margin-top: 50px" role="alert">
    		</c:when>
        	<c:otherwise>
     			   <div class="alert alert-danger" style="margin-top: 50px" role="alert">
        	</c:otherwise>
    	</c:choose>
    	<strong>
            	${msg}
        </strong>
                </div>
 		<%
                session.removeAttribute("msg");
            
        %>
    </c:if>
      
 <jsp:include page ="../common/changpwd.jsp" flush="true"/>	
        
        <div class="jumbotron"style="height: 350px; width:1140px ;" >
        	<img  alt="" src="${pageContext.request.contextPath}/static/pic/homepage-bg.jpg"style="height: 350px; width:1140px ;color: #f0efee;text-align:center;" />
        </div>

        <div class="container">
            <ol class="breadcrumb" style="margin-top: 10px">
                <li class="active">热门课程</li>
            </ol>
            <!-- Example row of columns -->
            
        	<div class="row">

				<c:forEach var ="cou" items ="${course}" varStatus ="p">
                	<div class="col-md-4">
                    	<h2>
                    		${cou.name}
                    	</h2>
                    	<p>
                    		所属社团:${cou.belong}
                    	</p>
                    	<p>
                    		${cou.detail}
                    	</p>
                    	<p>
                    	<a class="btn btn-default" href="${pageContext.request.contextPath}/ShowDetail?id=${cou.id}" role="button">
                    		View details &raquo;</a>
                        </p>
                	</div>
				</c:forEach>
               
            </div>
        </div>
    </div>

   
</div>


</body>
</html>
