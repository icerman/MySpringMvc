package ssm;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zsx.web.controller.NewUser;
import com.zsx.web.entity.Newuser;

public class test {

	@Autowired // 注入
	private NewUser addr;
	@Test
	public void test() {
		
		Newuser user = new Newuser();
		user.setName("黎明的");
		user.setGender("男");
		user.setPassword("123456");
		HttpServletRequest reS = null;
		
		addr.adduser(reS);
		
	}

}
