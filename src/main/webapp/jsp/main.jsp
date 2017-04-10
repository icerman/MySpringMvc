<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Login</title>
		<script type ="text/javascript" src ="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	    <script type ="text/javascript" src ="${pageContext.request.contextPath}/js/my.js"></script>
	</head>
	<body>
     <script type="text/javascript">
     	
    	//删除成功
     	function change(value){
     			alert(value);
     			console.log(value);
     			data ={id:value}
				$.ajax({
					 type : "post",
					 url :"<%=request.getContextPath() %>/Delete.do",
					 dataType : "json",
					 async:false,
					 data:JSON.stringify(data),//转JSON字符串
					 contentType:'application/json;charset=UTF-8',//contentType很重要   
					 
					 success : function(data) {
						
					  }
				 });
     	}

     
     </script>
    	<center>
    	
    	  <h4> 登录成功</h4>
    		<table border ="1"  width="80%">
    			<tr>
    				<td>编号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>电话</td>
					<td>备注</td>
					<c:if test="${type.name == '丽丽'}">
						<td>操作</td>
					 </c:if>
    	
    			</tr>
    		<c:forEach var ="usr" items ="${list}" varStatus ="un">
    			<tr>
    				<td>${un.index+1}</td>
    				<td><a href ="<%=request.getContextPath() %>/Detail.do?id=${usr.id}">${usr.name}</a></td>
    				<td>${usr.gender}</td>
    				<td>${usr.age}</td>
    				<td>${usr.phone}</td>
    				<td>${usr.demand}</td>
    				<td>
    				<a href ="<%=request.getContextPath() %>/Detail.do?id=${usr.id}">查看</a>
    					  <c:if test="${type.name == '丽丽'}">
    						<!--  <a href ="<%=request.getContextPath() %>/ChangeDetail.do?id=${user.id}">修改</a>&nbsp;-->
    						<a onclick ="return confirm('确定删除?')" href ="<%=request.getContextPath() %>/ChangeDetail.do?id=${user.id}">删除</a>
    					  </c:if>
    				</td>
    			</tr>
    		</c:forEach>
    		</table>
    	</center>
	</body>
</html>