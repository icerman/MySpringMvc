package com.zsx.web.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zsx.web.entity.PageBean;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;
import com.zsx.web.entity.study;

public interface AStudentService {
	
	
	
	/**
	 * 查找最热门的课程
	 */
	public List<course> findhot() throws Exception;

	/**
	 * 查找所有的课程
	 */
	public PageBean<course> findallcourse(Integer pageNo,Integer pageSize) throws Exception;
	
	/**
	 * 查看某一个课的详情
	 */
	public course findbyId(Integer id) throws Exception;
	
	/**
	 * 查看自己选的课程
	 */
	public List<study> findbyName(String name) throws Exception;
	
	/**
	 * 删除自己选的课程
	 */
	public void delcourse(String  cid,String sid)throws Exception;
	
	/**
	 *修改选课人数（增加）
	 */
	public void updatecourse(course cou)throws Exception;
	
	/**
	 *修改选课人数(减少)
	 */
	public void updatecourm(course cou)throws Exception;
	
	
	
	/**
	 *添加课程
	 */
	public void insertstudy(student stu,course cou)throws Exception;
	
	/**
	 *查找选择某一个课的学生列表
	 */
	public List<student> findselectstudent(int id)throws Exception;
	
	/**
	 *查找所有的学生
	 */
	public List<student> findallstudent()throws Exception;
	

	
}
