package com.zsx.web.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zsx.web.entity.admin;
import com.zsx.web.entity.course;

@Transactional
public interface ACourseDao {
	
	
/************************************student操作**********************************************/
	/**
	 * 查找最热门的课程
	 */
	public List<course> findhot() throws Exception;
	
	/**
	 * 查找所有的课程
	 */
	
	public List<course> findallcourse() throws Exception;
	/**
	 * 查看某一个课的详情
	 */
	public course findbyId(Integer id) throws Exception;
	
	/**
	 * 修改选课人数
	 */
	public void updatecourse(@Param("sted")int sted,@Param("id")int id)throws Exception;

	
/************************************admin操作**********************************************/
	
	/**
	 * 添加课程
	 * @param cou
	 * @throws Exception
	 */
	
	public void AddCourse(@Param("cou")course cou)throws Exception;


	
	
	
}
