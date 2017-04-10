package com.zsx.core.interceptors;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.zsx.web.entity.Newuser;

public class QualiafityInterceptor implements HandlerInterceptor {
	
	//注入不需要拦截路径的列表
	private List<String> excludeUrls;// 不需要拦截的资源
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	/**
	 * 在Controller的方法调用之后执行
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	/** 
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * SpringMVC中的Interceptor拦截器是链式的，可以同时存在多个Interceptor，
     * 然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在Controller方法调用之前调用。
     * SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返 
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。 
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		/*boolean flag = false;
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestURI.substring(contextPath.length() + 1);
		//获取请求路径
		String serelvetpath = request.getServletPath();
		System.out.println(requestURI);
		System.out.println(contextPath);
		System.out.println(serelvetpath);
		System.out.println(url);
		// 如果要访问的资源是不需要验证的
		for (String exurl : excludeUrls) {
			//System.out.println(exurl);
			if(serelvetpath.contains(exurl)){
				flag = true;
				break;
			}
		}		
		//验证用户权限
		if(!flag){
			//获取session
			HttpSession session = request.getSession();
			Newuser se = (Newuser) session.getAttribute("type");
			// 判断用户是否已经登录 
			if (se !=null) {
				System.out.println("AuthorizationInterceptor放行请求："+serelvetpath); 
				flag = true;				
			}else{
				 System.out.println("AuthorizationInterceptor拦截请求："+serelvetpath); 
				//重定向回登录界面
				response.sendRedirect("login");
			}		
		}
		return flag;*/
		return true;
   }
}
