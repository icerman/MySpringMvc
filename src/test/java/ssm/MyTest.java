package ssm;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zsx.web.dao.ACourseDao;
import com.zsx.web.entity.PageBean;
import com.zsx.web.entity.course;

public class MyTest extends BaseTest {

	@Resource
	private ACourseDao CourseDao;
	
	@Before
	public void before(){
		System.out.println("准备测试！！！");
	}
	
	@After
	public void After(){
		System.out.println("测试结束！！！");
	}
	
	@Test
	public void get() {
		PageHelper.startPage(2, 2);
		List<course> selectAll;
		try {
			selectAll = CourseDao.findallcourse();
			System.out.println(selectAll.size());
			PageBean<course> pb = new PageBean<course>(selectAll);
			System.out.println(JSON.toJSONString(pb));
			for (course user : selectAll) {
				System.out.println(JSON.toJSONString(user));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
