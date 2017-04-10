package com.zsx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.zsx.web.entity.Newuser;
import com.zsx.web.service.Impl.NewuserServiceImpl;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class NewUser {
	
	@Autowired
	private NewuserServiceImpl newuserService;
	
	/***
	 *页面要使用jquery的ajax请求Controller
	 *
	 consumes 其实就是当请求的HTTP 头是何种格式的时候,进行应对,
     @responsebody表示该方法的返回结果直接写入HTTP response body中一般在异步获取数据时使用，在使用@RequestMapping
           后，返回值通常解析为跳转路径，加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response 
    body中。比如异步获取json数据，加上@responsebody后，会直接返回json数据。POST模式下，使用@RequestBody绑定请求   对象，
    Spring会帮你进行协议转换，将Json、Xml协议转换成你需要的对象。

	 * @throws JSONException 
	*/
	
	@RequestMapping(value ="FName",method =RequestMethod.POST,consumes ="application/json")
	@ResponseBody
	public Object FindU(@RequestBody Newuser user){
		
		JSONObject jspj = new JSONObject();
		if(user.getName() != null || user.getName() != ""){
			
			try {
				Newuser use = newuserService.findbyName(user.getName());
				if(use != null){
					jspj.put("message","存在");
				}
			} catch (JSONException e) {
				e.printStackTrace();
				System.out.println(e.getStackTrace());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//System.out.println(jspj);
		return jspj;
	}
	
	
	/***
	 * 用户注册
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="veregister" ,method = RequestMethod.POST)
	public String  adduser(HttpServletRequest request){
		String url = request.getRequestURI();//资源路径
		String url2 = request.getContextPath();//项目名称
		//System.out.println(url+"\\\\"+url2);
		Newuser user = new Newuser();
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		
		user.setName(name);
		user.setGender(gender);
		user.setPassword(password);
		/*user.setName("黎明的");
		user.setGender("男");
		user.setPassword("123456");*/
		//System.out.println(name+gender+password);
		try {
			newuserService.insertuser(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			//return "error";
		}
		return "jsp/login";
	}
	
	/***
	 * 登录验证
	 * @param str
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="VeCode",method = RequestMethod.POST)
	public @ResponseBody String vecode(@RequestBody String str,HttpServletRequest request,HttpServletResponse response){
		
		//json字符串转换为json对象 
		JSONObject jsonObject = JSONObject.parseObject(str); 
		String name = jsonObject.getString("name");
		String password = jsonObject.getString("password");
		String vercode = jsonObject.getString("vercode");
		HttpSession se = request.getSession();
		String code = (String) se.getAttribute("randNumber");
		//判断验证码是否正确
		if(code.equalsIgnoreCase(vercode)){
			try {
				Newuser use = newuserService.findbyName(name);
				System.out.println(use.getPassword());
				if(use.getPassword().equals(password)){
					se.setAttribute("type", use);
					//System.out.println(request.getContextPath()+"/"+"mainlist.do");
					//request.getRequestDispatcher(request.getContextPath()+"/"+"mainlist.do").forward(request, response);
					/*文件上传到服务器
					 * String path = request.getSession().getServletContext().getRealPath("upload");
					System.out.println(path);
					File file = new File(path,name);
					if (!file.exists()) {
						file.mkdirs();
						System.out.println("ok");
					}*/
					
					return "regsuccess";
				}
					
			} catch (Exception e) {
				
			}
			return "usererror";
		}else{
			return "codeerror";
		}
		
	}
	
	
	
}
