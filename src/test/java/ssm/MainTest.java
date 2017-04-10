package ssm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.zsx.web.entity.User;
import com.zsx.web.entity.course;

import Util.UserMapper;

public class MainTest {

	public static void main(String[] args) {
/*		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext.xml", "classpath:/spring-mybatis.xml");
//		RedisTemplate redis = (RedisTemplate) ac.getBean("redisTemplate");
		bean = ac.getBean(Regiseter.class);
		User selectByPrimaryKey = bean.selectByPrimaryKey("1");
		System.out.println(JSON.toJSONString(selectByPrimaryKey));*/
		
		course cou = new course();  
		cou.setName("生物");  
		cou.setCredit(43);
		cou.setTeacher("李金玉");
		cou.setBelong("化工学院");
		cou.setPlace("地质楼");
		cou.setDetail("bean ac.getBean(Regiseter.class);User selectByPrimar;");
		cou.setAmount(45);
		cou.setTime("5645");
		course.createStudentAutoKey(entity);  
		System.out.println("新增学生ID: " + entity.getStudentId()); 
		
	}
}
