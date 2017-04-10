package com.zsx.web.service.Impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zsx.web.controller.AStudent;
import com.zsx.web.dao.ALoginDao;
import com.zsx.web.dao.AStudentDao;
import com.zsx.web.entity.admin;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;
import com.zsx.web.service.ALoginService;

@Service("ALoginService")
public class ALoginServiceImpl implements ALoginService{

	@Resource
	ALoginDao LoginDao;
	@Resource
	AStudentDao StudentDao;
	
	/*
	 * 根据admin名字查找用户是否存在
	 */
	@Override
	public admin findbyName(String name) throws Exception {
		
		
		return LoginDao.findbyname(name);
	}

	/**
	 * 根据student学号查找密码
	 */
	@Override
	public student findbynumber(String studentID) throws Exception {
		
		return StudentDao.findbynumber(studentID);
	}

	/**
	 * 修改学生登录密码
	 */
	@Override
	public void changpwd(student stu,String pwd) throws Exception {
		
		StudentDao.changpwd(stu,pwd);
	}

	

}
