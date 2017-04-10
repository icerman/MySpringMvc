package com.zsx.web.service;

import java.util.List;

import com.zsx.web.entity.User;

public interface UserService {
	
	/***
	 * 查找所用用户信息
	 * @return
	 * @throws Exception
	 */
	public List<User> search()throws Exception;
	
	/***
	 * 查看某一用户详细信息
	 */
	public User findbyid(Integer id)throws Exception;
	
}
