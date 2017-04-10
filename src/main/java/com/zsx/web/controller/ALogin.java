package com.zsx.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zsx.web.entity.admin;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;
import com.zsx.web.service.AStudentService;
import com.zsx.web.service.ALoginService;

@Controller
public class ALogin {
	
	
	@Autowired
	private ALoginService LoginService;
	@Autowired
	private AStudentService CourseService;
	
	/**
	 * 管理员登录界面
	 * @return
	 */
	@RequestMapping(value ="AdminLogin" ,method =RequestMethod.GET)

	public String switchLogin(){
			
		return "jsp/Admin/AdminLogin";
	}
	
	 /**
	  * 管理员登录验证
	  * @param param 登录信息
	  * @param req 请求对象
	  * @return
	  */
	@RequestMapping(value ="VeAdmin" ,method =RequestMethod.POST)
	public @ResponseBody String VeAdminIndex(@RequestBody String param ,HttpServletRequest req){
		
		HttpSession se = req.getSession();
		JSONObject jsonObject =JSONObject.parseObject(param);
		String name = jsonObject.getString("name");
		String pwd = jsonObject.getString("pwd");
		String vercode = jsonObject.getString("vercode");
		//获取缓存中的验证码
		String code = (String) se.getAttribute("randNumber");
		
		if(name.length()>0 && name.length()<20 && pwd.length()>0 && pwd.length()<20 && vercode.length()>0 && vercode.length()<20){
			if (code.equalsIgnoreCase(vercode)) {
				try {
					//根据名字查找是否存在该管理员
					admin ad = LoginService.findbyName(name);
					if (ad.getPwd().equals(pwd)) {
						se.setAttribute("Admin", name);
						return "Tochsuccess";
					}else{
						return "usererror";
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else{
				return  "codeerror";
			}
		}
			return "usererror";		
	}
	
	/**
	 * admin登录验证成功、转到跳转页面
	 * @return
	 */
	@RequestMapping(value ="Tochsuccess",method =RequestMethod.GET)
	public String Tochsuccess(){
		return "jsp/common/regsuccess";
	}

	 /**
	  * 转到admin主界面
	  * @param req 请求对象
	  * @return
	  */
	@RequestMapping(value ="ToAdminIndex" ,method =RequestMethod.GET)
	public ModelAndView ToAdminIndex(HttpServletRequest req){
		ModelAndView MAV= new ModelAndView("jsp/Admin/AdminIndex");
		List<course> courses;
		try {
			courses = CourseService.findallcourse();
			List<String> listX=new ArrayList<String>();
			List<Integer> listSelected=new ArrayList<Integer>();
			List<Integer> listLeft=new ArrayList<Integer>();
			for(course cour:courses){
				listX.add(cour.getName());
				listSelected.add(cour.getSelected());
				listLeft.add(cour.getAmount()-cour.getSelected());
			}
			
			req.getSession().setAttribute("listX", JSON.toJSONString(listX));
			req.getSession().setAttribute("listSelected",JSON.toJSONString(listSelected));
			req.getSession().setAttribute("listLeft",JSON.toJSONString(listLeft));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MAV;
	}
	
	
	
	/**
	 * 学生主界面
	 * @return
	 */
	@RequestMapping(value ="StuIndex" ,method =RequestMethod.GET)
	public ModelAndView StuIndex(){
		
		ModelAndView MAV = new ModelAndView("jsp/student/StuIndex");
		List<course> cou = new ArrayList<course>();
		try {
			//查找热门的课程
			cou = CourseService.findhot();
			MAV.addObject("course", cou);
		} catch (Exception e) {
		}
		
		return MAV;
	}
	
	 /**
	  * 学生登录验证
	  * @param stu 登录信息
	  * @param req 请求对象
	  * @return
	  */
	
	@RequestMapping(value ="Stulogin" ,method =RequestMethod.POST)
	public @ResponseBody String  Stulogin(@RequestBody student stu, HttpServletRequest req){
		HttpSession se = req.getSession();
		String studentID = stu.getStudentID();
		String pwd = stu.getPwd();
		if(studentID.length()>0 && studentID.length()<20 && pwd.length()>0 && pwd.length()<20){
			try {
				//通过学号查找是否存在该学生
				student stusql = LoginService.findbynumber(studentID);
				if(stusql!= null){
					if (stusql.getPwd().equals(pwd)) {
						se.setAttribute("student", stusql);
						return "StuIndex.do";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return "unfind";
	}
	
	/**
	 * 学生注销登录
	 * @param req 请求对象
	 * @return
	 */
	@RequestMapping(value ="logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest req){
		
		HttpSession se = req.getSession();
		//注销所有的session
		se.invalidate();
		return "jsp/student/StuIndex";
	}
	
	/**
	 * student修改登录密码
	 */
	@RequestMapping(value ="ChangePwd",method =RequestMethod.POST)
	public @ResponseBody String ChangePwd(@RequestBody String param,HttpServletRequest req){
		
		JSONObject jb = JSONObject.parseObject(param);
		HttpSession se = req.getSession();
		String oldpwd = jb.getString("oldpwd");
		String newpwd = jb.getString("newpwd");
		String newagain = jb.getString("newagain");
		student stu = (student) se.getAttribute("student");
		if(oldpwd.length()>0 && oldpwd.length()<20 && newpwd.length()>0 && newpwd.length()<20&& newagain.length()>0 && newagain.length()<20){
			
			if(oldpwd.equals(stu.getPwd())){
				if(newpwd.equals(newagain)){
					try {
						LoginService.changpwd(stu, newpwd);
						se.removeAttribute("student");
						se.setAttribute("msg", "修改成功");
						return "StuIndex";
					} catch (Exception e) {
						se.setAttribute("msg", "修改失败");
					}
				}else{
					return "newerror";
				}
			}else{
				return "olderror";
			}
		}
		return "nullerror";
	}


}
