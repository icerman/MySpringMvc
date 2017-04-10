package com.zsx.web.controller;
import java.awt.print.Printable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zsx.web.entity.User;
import com.zsx.web.service.UserService;


@Controller
public class mainLogin {
	
	@Autowired
	private UserService userservice;
	
	
	

	
	
	@RequestMapping(value ="studentManage" ,method =RequestMethod.GET)
	public String switchstudentMange(){
			
		return "jsp/addStudent";
	}
	
	
	@RequestMapping(value ="courseManage" ,method =RequestMethod.GET)
	public String switchcourseManage(){
			
		return "jsp/addCourse";
	}
	
	
	@RequestMapping(value ="index" ,method =RequestMethod.GET)
	public String switchindex(){
			
		return "jsp/index";
	}
	
	
	
	/*
	 * 登录成功跳转页面
	
	 */
	@RequestMapping(value ="regsuccess" ,method= RequestMethod.GET)
	public String ToRegSuccess(){
		
		return "jsp/common/regsuccess";
	}
	
	/*
	 * 转到主界面
	 */
	@RequestMapping(value ="mainlist" ,method =RequestMethod.GET)
	public ModelAndView switchMain(){
		ModelAndView mv = new ModelAndView();
		List<User> users = null;
		try {
			 users = userservice.search();
				
			 mv.setViewName("jsp/main");
			 mv.addObject("list",users);
		} catch (Exception e) {
			//添加日志
		}
		return mv;
	}
	
	
	/*
	 * 查看用户的详细信息
	 */
	@RequestMapping(value ="Detail" ,method = RequestMethod.GET)
	public ModelAndView Detail(String id){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("jsp/UserDetail");
		User user = new User();
		try {
			user = userservice.findbyid(Integer.valueOf(id));
			mView.addObject("User",user);
			
				//System.out.println(user);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return mView;
	}
	
	/*
	 * 删除教师课程
	 */
	
	//@RequestMapping(value ="Delete" ,method = RequestMethod.GET)
	
	
	
	
}
