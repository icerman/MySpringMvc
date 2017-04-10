<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page ="../common/application.jsp" flush="true"/>
    <title>我的课程</title>
</head>
<body>

<jsp:include page ="../common/mainpwd.jsp" flush="true"/>
<jsp:include page ="../common/pwd.jsp" flush="true"/>
    <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/StuIndex.do">主页</a></li>
                <li><a href="${pageContext.request.contextPath}/ShowAllClasses">所有课程</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/ShowMyClasses">我的课程</a></li>
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
    <c:if test ="${Delete !=null}">
    	<div class="alert alert-success" style="margin-top: 50px" role="alert">
    	<strong>
            	${Delete}已从选课列表里删除!
        </strong>
         </div>
        <%
           session.removeAttribute("Delete");
        %>
    </c:if> 
<jsp:include page ="../common/changpwd.jsp" flush="true"/>	
        
<div class="container theme-showcase" role="main">

    <ol class="breadcrumb" style="margin-top: 100px">
        <li><a href="${pageContext.request.contextPath}/StuIndex.do">首页</a></li>
        <li class="active">我的课程</li>
    </ol>
    <c:choose>
    	<c:when test="${student ==null}">
    		<div class="alert alert-success" style="margin-top: 50px;" role="alert">
       	 	 	<strong>
					您还未登录！
      	 	 	</strong>
    		</div>
		</c:when>
    	<c:otherwise>
    		<c:choose>
    			<c:when test="${empty coumylist}">
    	     		<div class="well">
        				还未选课!
    				</div>
    			</c:when>
    			<c:otherwise>
    				<table class="table table-striped">
        				<thead>
        					<tr>
           	 					<th>编号</th>
            					<th>课程名称</th>
            					<th>所属社团</th>
            					<th>学分</th>
            					<th>开课学期</th>
            					<th>操作</th>
        					</tr>
        				</thead>
        			<tbody>
        				<c:forEach var ="cou" items ="${coumylist}" varStatus ="p">
        					 <tr>
            					<td>${p.index+1}</td>
            					<td>${cou.cname}</td>
            					<td>${cou.cbelong}</td>
            					<td>${cou.ccredit}</td>
            					<td>${cou.ctime}</td>
            					<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/ShowDetail?id=${cou.cid}">详情</a>
            						<a class="btn btn-danger" href="javascript:if(window.confirm('是否确认删除？')){window.location.href = '${pageContext.request.contextPath}/Delete?id=${cou.cid}';}">删除</a>
            					</td>
        					</tr>
        
        			   </c:forEach>
        	 	   </tbody>
    	  	       </table>
    		  </c:otherwise>
    	   </c:choose>
         </c:otherwise>
    </c:choose> 
</div>
</body>
</html>
