package com.zsx.web.service;

import java.util.List;

import com.zsx.web.entity.course;
import com.zsx.web.entity.student;
import com.zsx.web.entity.study;

public interface AdminService {
	
	/**
	 * 添加课程
	 * @throws Exception
	 */
	public void AddCourse(course cou) throws Exception;
	
	/**
	 * 通过学号查找学生是否已经存在
	 */
	public student findbystubyID(String studentId)throws Exception;
	
	
	/**
	 * 添加学生
	 * @throws Exception
	 */
	public void AddStudent(student stu) throws Exception;
	

	/**
	 * 查看所有的选课
	 */
	public List<study> findallstudy() throws Exception;
	/**
	 * 按id查找所选的课程
	 */
	public study findStudyById(int id)throws Exception;
	
}
