package com.zsx.web.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zsx.web.dao.ACourseDao;
import com.zsx.web.dao.AStudentDao;
import com.zsx.web.dao.AStudyDao;
import com.zsx.web.entity.course;
import com.zsx.web.entity.student;
import com.zsx.web.entity.study;
import com.zsx.web.service.AdminService;

@Service("AdminService")
public class AdminServiceImpl  implements AdminService{

	@Resource
	ACourseDao CourseDao;
	@Resource
	AStudentDao StudentDao;
	@Resource
	AStudyDao StudyDao;
	
	/**
	 * 添加课程
	 */
	@Override
	public void AddCourse(course cou) throws Exception {
		
		CourseDao.AddCourse(cou);
	}

	/**
	 * 通过学号查找学生是否已经存在
	 */
	@Override
	public student findbystubyID(String studentId) throws Exception {
		
		
		return StudentDao.findbynumber(studentId);
	}

	/**
	 * 添加学生
	 * @throws Exception
	 */
	@Override
	public void AddStudent(student stu) throws Exception {
		StudentDao.AddStudent(stu);
	}

	/**
	 * 查看所有的选课
	 */
	@Override
	public List<study> findallstudy() throws Exception {
		return StudyDao.findallstudy();
	}

	/**
	 * 按照id查看所选的课程
	 */
	@Override
	public study findStudyById(int id) throws Exception {
		return StudyDao.findStudyById(id);
	}


}
