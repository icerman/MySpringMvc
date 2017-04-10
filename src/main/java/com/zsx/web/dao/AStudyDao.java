package com.zsx.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zsx.web.entity.admin;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;
import com.zsx.web.entity.study;

@Transactional
public interface AStudyDao {
	

	/*
	 * 查看自己选的课程
	 */
	public List<study> findbyName(String name) throws Exception;
	
	
	/*
	 * 添加课程
	 */
	public void insertstudy(@Param("sdy")study sdy) throws Exception;
	
	
	
	/**
	 * 查找选择某一个课的学生列表
	 */
	public List<study> findselectstudent(int id)throws Exception;
	
	

	/**
	 * 删除选的课
	 */
	public void delcourse(@Param("cid")String  cid,@Param("sid")String sid) throws Exception;
	
	/**
	 * 查看所有的课程
	 * @return
	 * @throws Exception
	 */
	public List<study> findallstudy()throws Exception;
	
	/**
	 * 按照id查看所选的课程
	 * @return
	 * @throws Exception
	 */
	public study findStudyById(@Param("id")int id)throws Exception;
	

	
}
