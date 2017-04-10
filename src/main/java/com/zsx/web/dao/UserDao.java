package com.zsx.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zsx.web.entity.User;

@Transactional
public interface UserDao {
	
	public List<User> search() throws Exception;
	
	
	
	/***
	 * 查找某一用户的详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	public User FindbyIdDao(@Param("id")Integer id) throws Exception;
	
}
