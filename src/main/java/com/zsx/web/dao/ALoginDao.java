package com.zsx.web.dao;

import org.springframework.transaction.annotation.Transactional;

import com.zsx.web.entity.admin;
import com.zsx.web.entity.course;

@Transactional
public interface ALoginDao {
	
	/*
	 * 根据admin名字查找用户是否存在
	 */
	public admin findbyname(String name) throws Exception; 
	

	
}
