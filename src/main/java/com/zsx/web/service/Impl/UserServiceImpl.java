package com.zsx.web.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zsx.web.dao.UserDao;
import com.zsx.web.entity.User;
import com.zsx.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Resource
	private UserDao userdao;
	
	
	@Override
	public List<User> search()  throws Exception{
		
		return userdao.search();
	}


	@Override
	public User findbyid(Integer id) throws Exception {
		
		
		return userdao.FindbyIdDao(id);
	}
	
	
}
