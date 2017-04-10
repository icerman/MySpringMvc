# 搭建ssm框架

> 记录一步步的过程

## 一、编写pom.xml文件

声明

	<modelVersion>4.0.0</modelVersion>
	<groupId>com</groupId>
	<artifactId>zsx</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>ssm maven web</name>
	<description>null</description>

## 二、添加web.xml

日志管理
文件上传-----ok
添加用户-----ok
错误页面404,405，-----ok
页面跳转-----ok
多参数与表单其他参数往后台传递的方式
分页---解决一部分
mybatis动态sql
组合查询
单元测试-----ok


## 三、创建maven文件结构tree目录
2017年3月18日
补充登录验证、登录和注册的验证码验证

2017年3月20日

全部查询（出现问题空指针---是命名空间错误，实体类错误）

2017年3月22日
部署Aop添加日志

2017年3月22日
main.jsp--添加jstl时报错，已解决。使用了几个语法
<c:forEach var ="user" items ="${list}" varStatus ="un">

2017年3月24日
1、mybatis的动态sql
2、返回主键值。

2017年3月26日

1、查看某个用户的详细信息（含有图片）
2、新建用户时新建文件夹---但是项目目录里看不到？
3、GET请求不要使用@requestbody。2、如果仅传入一个类型为String的参数问题的处理
4、使用拦截器用户验证

2017年3月30日

1、整合项目，admin登录完成
2、实体类完成

2017年3月30日

1、学生主界面基本完成，除了图片？
2、select * from course order by selected desc limit 3
3、jsp中if...else 使用
            	

问题：
	1、在mybatis中操作不同的表，mapper怎么安排?
	

2017年4月2日

1、学生部分基本完成

剩余：
	 1、详情中选课、查看选课情况
	 2、删除已选课程
	 3、选课时，课程人数已满的处理
问题：主页图片问题
	文件整合。ok
	
2017年4月2日

剩余:删除已选课程

问题：
  mybatis 对于传入两个对象的方式，在service层将两个对象的值封装到实体里面，可以解决对象获取的变量类型转换的问题（字符串转成整型，会出现？？？？？）。解决
   
2017年4月3日   2017年4月4日
   
 1、删除时弹出对话框：  
 <a class="btn btn-danger" href="javascript:if(window.confirm('是否确认删除？')){window.location.href = '${pageContext.request.contextPath}/Delete?id=${cou.cid}';}">删除</a>
 
 问题：
 表单提交的字段很多，还要验证为非空？只需验证必要的字段，其他字段在插入数据库时会以null的方式插入（数据库该字段不要设置为非null）
 
2017年4月4日----2017年4月9日

获取虚拟路径对应的服务器的绝对路径
E:\计算机\Java\springmvc\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\webapps\ssm-master\upload
String path= req.getSession().getServletContext().getRealPath("upload")+File.separator+cou.getTeacher();
jsp获取服务器的图片（而不是本地的方式） 是以数据流的方式获取。

问题：
 对于GET请求方式，获得参数会出现乱码问题？？