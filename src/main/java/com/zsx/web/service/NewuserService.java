package com.zsx.web.service;

import com.zsx.web.entity.Newuser;

public interface NewuserService {
	
	/***
	 * 
	 * @param 通过名称查找数据库
	 * @return
	 * @throws Exception
	 */
	public  Newuser findbyName(String name)throws Exception;
	
	/***
	 * 
	 * @param 注册新用户，插入数据库
	 * @throws Exception
	 */
	public void insertuser(Newuser newuser) throws Exception;
	
	
	
	
	
}
