package com.zsx.web.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zsx.web.entity.Newuser;


@Transactional
public interface NewuserDao {
	
	//按姓名查找是否存在用户
	public Newuser findbyName(String name);
	
	//注册用户，插入数据
	public void addnewuser(@Param("user") Newuser newuser);
	
}
