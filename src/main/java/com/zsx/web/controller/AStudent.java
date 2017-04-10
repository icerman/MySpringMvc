package com.zsx.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zsx.web.entity.PageBean;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;
import com.zsx.web.entity.study;
import com.zsx.web.service.AStudentService;

@Controller
public class AStudent {
	
	
	@Autowired
	AStudentService CourseService;
	
	/**
	 *  student查询所有课程
	 * @return
	 */
	@RequestMapping(value ="ShowAllClasses",method =RequestMethod.GET)
	public ModelAndView  ShowAllClasses(){
		ModelAndView MAV = new ModelAndView("jsp/student/CouList");
		try {
			//查询所有的课程
			PageBean<course> pageBean = CourseService.findallcourse(1,6);
			List<course> coulist = pageBean.getList();
			MAV.addObject("coulist", coulist);
			MAV.addObject("pageBean",pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MAV;
	}
	
	/**
	 * student查询课程详情
	 * @param id 课程的id
	 * @param req 请求对象
	 * @return
	 */

	@RequestMapping(value ="ShowDetail",method =RequestMethod.GET)
	public ModelAndView  ShowDetail(@RequestParam String id,HttpServletRequest req){
		ModelAndView MAV = new ModelAndView("jsp/student/Detail");
		HttpSession se = req.getSession();
		student stu  = (student) req.getSession().getAttribute("student");
		//判断是否已经登录
		if (stu !=null) {
			try {
				Integer Id = Integer.parseInt(id);
				//根据id查找某一个课程
				course coudetail = CourseService.findbyId(Id);
				//根据学生名字查找该学生选择课程的列表
				List<study> coumylist = CourseService.findbyName(stu.getName());
				//判断在该学生选课的列表中是否已经选择了该课
				if (coumylist !=null) {
					for (study stulist : coumylist) {
						if (stulist.getCid().equals(id)) {
							MAV.addObject("semsg", "已选！");
							break;
						}
					}
				}
				//MAV.addObject("coudetail", coudetail);
				se.setAttribute("coudetail", coudetail);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return MAV;
	}
	 
    /** 
     * 显示老师图片 
     * @param model 
     * @param request 
     * @return 
     * @throws Exception  
     */  
    @RequestMapping(value ="ShowImage",method =RequestMethod.GET )  
    public void showImageByType(HttpServletRequest req,HttpServletResponse rep) throws Exception{  
        InputStream inputStream = null;  
        OutputStream writer = null; 
        //对于GET请求方式，获得参数会出现乱码问题？？
        String filename=new String((req.getParameter("filename")).getBytes("iso-8859-1"),"utf-8");
        String realpath = req.getSession().getServletContext().getRealPath("upload")+File.separator+filename;
        System.out.println(realpath);
        try {  
            inputStream = new FileInputStream(new File(realpath+"\\"+filename+".jpg"));  
            writer = rep.getOutputStream();  
                byte[] buf = new byte[1024];  
                int len = 0;  
                while ((len = inputStream.read(buf)) != -1) {  
                     writer.write(buf, 0, len);//写  
                }  
               inputStream.close();  
            } catch (Exception e) {  
            	e.printStackTrace();
             //logger.error(e.getMessage(),e);
            } finally{  
             try {  
                 if(inputStream != null){  
                     inputStream.close();  
                 }  
                 if(writer != null){  
                     writer.close();  
                 }  
            } catch (IOException e) {  
                //logger.error(e.getMessage(),e); 
            }
            }  
    }  
	
	
	
	/**
	 * student查询自己选的课程
	 * @param req 请求对象
	 * @return
	 */
	
	@RequestMapping(value ="ShowMyClasses",method =RequestMethod.GET)
	public ModelAndView ShowMyClasses(HttpServletRequest req){
		ModelAndView MAV = new ModelAndView("jsp/student/MyClzs");
		HttpSession se = req.getSession();
		student stu = (student) se.getAttribute("student");
		if (stu != null){
			String name = stu.getName();
			try {
				//根据学生名字查找该学生选课的列表
				List<study> coumylist = CourseService.findbyName(name);
				MAV.addObject("coumylist", coumylist);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return MAV;
	}
	
	 /**
	  * 删除已经选的课
	  * @param id 课程的id
	  * @param req 请求对象
	  * @return
	  */
	@RequestMapping(value ="Delete",method =RequestMethod.GET)
	public String Delete(@RequestParam String id,HttpServletRequest req){
		HttpSession se = req.getSession();
		student stu = (student) se.getAttribute("student");
		if (stu != null){
			try {
				//根据id查找某一个课程
				course cour = CourseService.findbyId(Integer.parseInt(id));
				//修改选课的人数（减少一位）
				CourseService.updatecourm(cour);
				//删除的选的课
				CourseService.delcourse(id,stu.getStudentID());
			     se.setAttribute("Delete", cour.getName());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/ShowMyClasses";
	}
	
	
	/**
	 * student选课
	 * @param id 课程的id
	 * @param req 请求对象
	 * @return
	 */
	@RequestMapping(value ="SelectClz",method =RequestMethod.GET)
	public String  SelectClz(@RequestParam String id,HttpServletRequest req){
		//查看是否已经登录
		student stu  = (student) req.getSession().getAttribute("student");
		HttpSession se = req.getSession();
		if (stu !=null) {
			try{
				//根据id查找某一个课程
				course cou = CourseService.findbyId(Integer.parseInt(id));
				if (cou.getSelected()==cou.getAmount()) {
					se.setAttribute("selectmsg", "课程人数已满");
				}else{
					//添加课程
					CourseService.insertstudy(stu,cou);
					//更新课程表中选课的人数
					CourseService.updatecourse(cou);
					se.setAttribute("selectmsg", "选课成功!");
				}
			}catch (Exception e) {
				e.printStackTrace();
				se.setAttribute("selectmsg", "选课失败!");
			}
		}
		return "redirect:/ShowDetail?id="+id;
	}
	
	/**
	 * student查看选课的学生
	 * @param id 课程id
	 * @return
	 */
	@RequestMapping(value ="ShowStudent",method =RequestMethod.GET)
	public ModelAndView ShowStudent(@RequestParam String id){
		ModelAndView MAV = new ModelAndView("jsp/student/Stulist");
		try {
			//根据课程的cid查询选择改课的学生列表
			List<student> stulist =CourseService.findselectstudent(Integer.parseInt(id));
			MAV.addObject("stulist", stulist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MAV;
	}
	
}
