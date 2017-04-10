package com.zsx.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zsx.web.entity.admin;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;

@Transactional
public interface AStudentDao {
	

	/*
	 * 根据student学号查找密码(学生是否存在)
	 */
	public student findbynumber(String studentID) throws Exception;
	
	/*
	 *修改学生登录密码 
	 */
	public void changpwd(@Param("stu")student stu,@Param("pwd")String pwd) throws Exception;
	
	
	/************************************admin操作**********************************************/
	
	/**
	 * 添加学生
	 * @throws Exception
	 */
	public void AddStudent(@Param("stu") student stu)throws Exception;
	
	/**
	 * 查询所有学生
	 * @param cou
	 * @throws Exception
	 */
	public List<student> findallstudent()throws Exception;
}
