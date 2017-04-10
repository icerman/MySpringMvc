package com.zsx.web.service.Impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsx.web.dao.ACourseDao;
import com.zsx.web.dao.AStudentDao;
import com.zsx.web.dao.AStudyDao;
import com.zsx.web.entity.PageBean;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;
import com.zsx.web.entity.study;
import com.zsx.web.service.AStudentService;

@Service("AStudentService")
public class AStudentServiceImpl implements AStudentService{

	@Resource
	ACourseDao CourseDao;
	@Resource
	AStudyDao StudyDao;
	@Resource
	AStudentDao StudentDao;
	/**
	 * 查找最热门的课程
	 */
	@Override
	public List<course> findhot() throws Exception {
		
		return CourseDao.findhot();
	}

	/**
	 * 查找所有的课程
	 */
	@Override
	public PageBean<course> findallcourse(Integer pageNo,Integer pageSize) throws Exception {
		 	pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<course> list = CourseDao.findallcourse();
		    //用PageInfo对结果进行包装
		    PageBean<course> page = new PageBean<course>(list);
		    //测试PageInfo全部属性
		   /* System.out.println(page.getPageNum());
		    System.out.println(page.getPageSize());
		    System.out.println(page.getStartRow());
		    System.out.println(page.getEndRow());
		    System.out.println(page.getTotal());
		    System.out.println(page.getPages());
		    System.out.println(page.getFirstPage());
		    System.out.println(page.getLastPage());
		    System.out.println(page.isHasPreviousPage());
		    System.out.println(page.isHasNextPage());*/
		    return page;
	}

	/**
	 * 查看某一个课的详情
	 */
	@Override
	public course findbyId(Integer id) throws Exception {
		return CourseDao.findbyId(id);
	}

	/**
	 * 查看自己选的课程
	 */
	@Override
	public List<study> findbyName(String name) throws Exception {
		
		
		return StudyDao.findbyName(name);
	}

	/**
	 *添加课程
	 */
	@Override
	public void insertstudy(student stu, course cou) throws Exception {
		study sdy = new study();
		sdy.setSid(stu.getStudentID());
		sdy.setSname(stu.getName());
		sdy.setSmajor(stu.getMajor());
		sdy.setCid(String.valueOf(cou.getId()));
		sdy.setCbelong(cou.getBelong());
		sdy.setCcredit(cou.getCredit());
		sdy.setCtime(cou.getTime());
		sdy.setCname(cou.getName());
		
		StudyDao.insertstudy(sdy);
	}
	
	/**
	 *修改选课人数（增加）
	 */

	@Override
	public void updatecourse(course cou) throws Exception {
		int sted = cou.getSelected()+1;
		int id = cou.getId();
		CourseDao.updatecourse(sted,id);
	}
	
	/**
	 *修改选课人数(减少)
	 */
	@Override
	public void updatecourm(course cou) throws Exception {
		int sted = cou.getSelected()-1;
		int id = cou.getId();
		CourseDao.updatecourse(sted,id);
	}
	
	
	/**
	 *查找选择某一个课的学生列表
	 */
	
	@Override
	public List<student> findselectstudent(int id) throws Exception {
		
		List<study> stulist = new ArrayList<study>();
		List<student> stdlist = new ArrayList<student>();
		stulist =StudyDao.findselectstudent(id);
		for (study sud : stulist) {
			student std = new student();
			std.setStudentID(sud.getSid());
			std.setName(sud.getSname());
			std.setMajor(sud.getSmajor());
			stdlist.add(std);
		}
		
		return stdlist;
		
	}

	/**
	 * 删除已选择的课程
	 */
	@Override
	public void delcourse(String  cid,String sid) throws Exception {
		
		StudyDao.delcourse(cid,sid);
	}

	
	/**
	 * 查询所有学生
	 */
	@Override
	public List<student> findallstudent() throws Exception {
		return StudentDao.findallstudent();
	}


}
