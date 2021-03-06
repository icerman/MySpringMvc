package com.zsx.AopLog;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zsx.web.entity.Log;

/*
 * 切点类
 */
@Aspect
@Component
public class SystemLogAspect {

	
	//本地异常日志记录对象
	private static final Logger logger = Logger.getLogger(SystemLogAspect.class.getName());
	
	//Service层切点
	@Pointcut("@annotation(com.zsx.AopLog.SystemServiceLog)")
	public void serviceAspect(){
		
	}
	
	//Controller层切点
	@Pointcut("@annotation(com.zsx.AopLog.SystemControllerLog)")
	public void controllerAspect(){
		
	}
	
	/***
	 * 前置通知，用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint切点
	 */
	
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint){
		
		  HttpServletRequest request = 
				 ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
		  
		  HttpSession session = request.getSession();
		  
		  //读取session中的用户
		  //session.getAttribute(CURRENT_USER);
		  //请求的ip
		  String IP = request.getRemoteAddr();
		  try {
			  //*========控制台输出=========*
			  System.out.println("=====前置通知开始=====");
			  System.out.println("请求方法："+ (joinPoint.getTarget().getClass().getName()+""+joinPoint.getSignature().getName()+"()"));
			  System.out.println("方法描述："+""+getControllerMethodDescription(joinPoint));
			 // System.out.println("请求人"+);
			  System.out.println("请求ip:"+IP);
			//*========数据库日志=========*
			  Log log = new Log();
			  log.setDescription(getControllerMethodDescription(joinPoint));
			  log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
			  log.setType("0");
			  log.setReuquestIp(IP);
			  log.setExceptionCode(0);
			  log.setExceptionDetail(null);
			  log.setParams(null);
			  log.setCreateBy(null);
			  //TODO时间
			  //log.setCreateDate(Date);
			  //保存数据库
			  
			  System.out.println("=====前置通知结束=====");  
		  } catch (Exception e) {
			  //用log4j记录本地异常日志
			  logger.error("====前置通知异常====");
			  logger.error("异常信息："+e.getMessage());
		  }
	}
	   /** 
		* 异常通知 用于拦截service层记录异常日志 
		* 
	   * @param joinPoint 
	   * @param e 
       */  
	  @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
      public void doAfterThrowing(JoinPoint joinPoint, Throwable e){
		  
		  HttpServletRequest request = 
					 ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
			  
		  HttpSession session = request.getSession();
			  
		  //读取session中的用户
		  //session.getAttribute(CURRENT_USER);
		  //请求的ip
		  String IP = request.getRemoteAddr();
		//获取用户请求方法的参数并序列化为JSON格式字符串   
		  String params = ""; 
		
		  
		  if (joinPoint.getArgs() != null && joinPoint.getArgs().length>0) {
			 for (int i = 0; i < joinPoint.getArgs().length; i++) {
				//params +=
				//params += JSONUtil.toJsonString(joinPoint.getArgs()[i]) + ";";    

			 }
		  }
	      try{
			              
	          System.out.println("=====异常通知结束=====");  
			          
	      }catch (Exception ex) {  
			  //用log4j记录本地异常日志  
			 logger.error("==异常通知异常==");  
			 logger.error("异常信息:{}"+ ex.getMessage());  
		  }  
			           /*==========记录本地异常日志==========*/  
	        /* logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}",
	         joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(),
	         e.getClass().getName(), e.getMessage(),params);  */
		  
			 
	  }
		  
		  

    /** 
     * 获取注解中对方法的描述信息 用于Controller层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
     */ 
	
	public static String getControllerMethodDescription(JoinPoint joinPoint)throws Exception{
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods(); 
		String description = "";
		for(Method method:methods){
			if(method.getName().equals(methodName)){
				Class[] clazzs = method.getParameterTypes();
			
				if (clazzs.length==arguments.length) {
					description = method.getAnnotation(SystemControllerLog. class).description();
					break;
				}
			}
		}
		return description;
	}
	
	/**
	 * 获取注解中对方法的描述信息 用于service层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
	 */
	public static String getServiceMthodDescription(JoinPoint joinPoint)throws Exception{
		
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
        Class targetClass = Class.forName(targetName);  
        Method[] methods = targetClass.getMethods();  
        String description = "";  
        for (Method method : methods) {  
        	if (method.getName().equals(methodName)) {  
        	    Class[] clazzs = method.getParameterTypes();  
        	    if (clazzs.length == arguments.length) {  
        	          description = method.getAnnotation(SystemServiceLog. class).description();  
        	          break;  
        	     }  
        	  }  
         }  
         return description;
		
	}
	
	
	
	
}
