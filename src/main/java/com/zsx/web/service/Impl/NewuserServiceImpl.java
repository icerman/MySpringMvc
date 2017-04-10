package com.zsx.web.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zsx.web.dao.NewuserDao;
import com.zsx.web.entity.Newuser;
import com.zsx.web.service.NewuserService;

@Service("NewuserService")
public class NewuserServiceImpl implements NewuserService{

	@Resource
	NewuserDao NewuserDao;
	
	@Override
	public Newuser findbyName(String name) throws Exception {
		
		return NewuserDao.findbyName(name);
	}

	@Override
	public void insertuser(Newuser newuser) throws Exception {

		 NewuserDao.addnewuser(newuser);
	}

		
}
