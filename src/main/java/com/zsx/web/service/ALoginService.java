package com.zsx.web.service;

import com.zsx.web.entity.admin;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;

public interface ALoginService {
	
	
	
	/**
	 * 根据admin名字查找密码
	 */
	public admin findbyName(String name) throws Exception;
	
	/**
	 * 根据student学号查找密码
	 */
	
	public student findbynumber(String studentID)throws Exception;
	
	/**
	 * 修改学生登录密码
	 */
	public void changpwd(student stu,String pwd) throws Exception;
}
