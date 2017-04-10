<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Login</title>
		<script type ="text/javascript" src ="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
	    <script type ="text/javascript" src ="${pageContext.request.contextPath}/js/my.js"></script>
	</head>
	<body>
		
    	<h4> 登录成功</h4>
    	
    	<table border ="1" cellpadding ="0" cellspacing ="0">
    	
    	<tr>
    		<td>序号</td>
    		<td>用户名</td>
    		<td>名字</td>
    		<td>年龄</td>
    		<td>性别</td>
    		<td>电话</td>
    		<td>备注</td>
    		<td>操作</td>
    	</tr>
		
    	
    	</table>
    	<c:if test="true">
    			<h3>srgew</h3>
    	</c:if>
	</body>
</html>