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
		姓名：<span>${User.name}</span>&nbsp;&nbsp;性别：<span>${User.gender}</span><br/><br/>
		年龄：<span>${User.age}</span>&nbsp;&nbsp;电话：<span>${User.phone}</span><br/><br/>
		要求：<span>${User.demand}</span><br/><br/>
		<img src="" alt="XX" />
		
		<input type = ""/>
		
	</body>
</html>