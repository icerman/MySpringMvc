package com.zsx.web.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;
import com.zsx.web.entity.study;
import com.zsx.web.service.AStudentService;
import com.zsx.web.service.AdminService;

@Controller
public class Admin {
	
	
	@Autowired
	AdminService admin;
	@Autowired
	AStudentService StudentService;
	
	/**
	 * 跳转到学生管理页面
	 * @return
	 */
	@RequestMapping(value ="StudentManage",method =RequestMethod.GET)
	public ModelAndView  StudentManage(){

		ModelAndView MAV = new ModelAndView("jsp/Admin/allStudents");
		try {
			List<student> stulist = StudentService.findallstudent();
			MAV.addObject("stulist", stulist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MAV;
	}
	
	/**
	 * 跳转到课程管理页面
	 * @return
	 */
	
	@RequestMapping(value ="CourseManage",method =RequestMethod.GET)
	public ModelAndView  CourseManage(){
		ModelAndView MAV = new ModelAndView("jsp/Admin/allCourses");
		
		try {
			List<course> coulist = StudentService.findallcourse();
			MAV.addObject("coulist", coulist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MAV;
	}
	
	/**
	 * 通过学号查找该学生是否存在
	 * @param stId
	 * @return
	 */
	@RequestMapping(value ="CheckStudent",method=RequestMethod.POST)
	public @ResponseBody String CheckStudent(@RequestBody String stId){
		if (stId !=null) {
			JSONObject jsonObject = JSONObject.parseObject(stId);
			String  studentId =jsonObject.getString("studentID");
			try {
				student stu =admin.findbystubyID(studentId);
				if (stu !=null) {
					return "ok";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "err";
	}
	
	/**
	 * 添加课程
	 * @param cou
	 * @param req
	 */
	@RequestMapping(value ="AddCourse",method =RequestMethod.POST)
	public String AddCourse(@RequestParam MultipartFile myfile,@ModelAttribute course cou,HttpServletRequest req){
		
		if (cou != null) {
			 //这里封装了读取配置文件的方法 配置文件中有图片的存放地址和获取地址
            /*Properties properties = PropertiesUtil.getProperties("configure/driverpicurl.properties");
            picDir = properties.getProperty("savePicUrl");*/
			String realpath = req.getSession().getServletContext().getRealPath("upload");
			String path= req.getSession().getServletContext().getRealPath("upload")+File.separator+cou.getTeacher();
			File targetfile = new File(realpath,cou.getTeacher());
			ServletContext stc = req.getServletContext();
			if (!targetfile.exists()) {
				targetfile.mkdirs();
			}
			try {
				if (myfile!=null) {
					FileUtils.copyInputStreamToFile(myfile.getInputStream(),new File(path, myfile.getOriginalFilename()));
					//myfile.transferTo(targetfile);
					System.out.println("文件上传完毕***"+targetfile);
				}
				admin.AddCourse(cou);
				req.getSession().setAttribute("coumsg", cou.getName()+"添加成功！");
			} catch (Exception e) {
				e.printStackTrace();
				req.getSession().setAttribute("coumsg", cou.getName()+"添加失败！");
			}
		}
		return "redirect:/CourseManage";
	}
	
	/**
	 * 添加新学生
	 * @param stu 学生实体
	 * @param req 请求对象
	 */
	@RequestMapping(value ="AddStudent",method =RequestMethod.POST)
	public String  AddStudent (@ModelAttribute student stu,HttpServletRequest req){
		 
		if (stu != null) {
			try {
				admin.AddStudent(stu);
				req.getSession().setAttribute("stumsg", stu.getName()+"添加成功！");
			} catch (Exception e) {
				e.printStackTrace();
				req.getSession().setAttribute("stumsg", stu.getName()+"添加失败！");
			}
		}
		return "redirect:/StudentManage";
	}
	
	/**
	 * 转到选课管理页面
	 * @return
	 */
   @RequestMapping(value ="ChooseManage",method =RequestMethod.GET)
   public ModelAndView ChooseManage(){
	   ModelAndView MAV = new ModelAndView("jsp/Admin/allChoose");
	   try {
		List<study> studylist = admin.findallstudy();
		MAV.addObject("studylist", studylist);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return MAV;
   }
   /**
    * 删除已选的课程
    * @param id
    * @return
    */
   @RequestMapping(value ="DelStudyInfo",method =RequestMethod.GET)
   public String DelStudyInfo(@RequestParam String id,HttpServletRequest req){
	   HttpSession ses = req.getSession();
	   try {
		study stud = admin.findStudyById(Integer.parseInt(id));
		if (stud !=null) {
			String cid = stud.getCid();
			String sid = stud.getSid();
			StudentService.delcourse(cid, sid);
			course cou = StudentService.findbyId(Integer.parseInt(cid));
			StudentService.updatecourm(cou);
			ses.setAttribute("studymsg", "删除成功！");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return "redirect:/ChooseManage";
   }
   
   /**
    * 添加所选的课程
    * @return
    */
   @RequestMapping(value ="AddChoose",method =RequestMethod.POST)
   public String AddChoose(HttpServletRequest req){
	   HttpSession ses = req.getSession();
	   try {
		String stuId = req.getParameter("stuId");
		String clzId = req.getParameter("clzId");
		student stu = admin.findbystubyID(stuId);
		course cou = StudentService.findbyId(Integer.parseInt(clzId));
		StudentService.insertstudy(stu, cou);
		StudentService.updatecourse(cou);
		ses.setAttribute("studymsg", "添加成功！");
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return "redirect:/ChooseManage";
   }
   
   
   
}
