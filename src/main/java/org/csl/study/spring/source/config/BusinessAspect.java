package org.csl.study.spring.source.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.csl.study.spring.source.common.WebConstant;
import org.csl.study.spring.source.common.utils.HttpKit;
import org.csl.study.spring.source.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class BusinessAspect {
	
	
	private static final String OperateIp     = "operateIp";
	
    
    
    private static Logger logger = LoggerFactory.getLogger(BusinessAspect.class);

	
	@Pointcut("execution(public * org..*..dao.*Mapper.insert*(..))")
	public void insert() {
	}
	
	@Pointcut("execution(public * org..*..controller.*Controll.*(..))")
	public void loger() {
	}
	@Before("insert()")
	public void beforeInsert(JoinPoint joinPoint) throws Throwable {
		
		
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            Object argument = args[0];
            BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
            // 用户IP
            if (beanWrapper.isWritableProperty(OperateIp)) {
            	if(RequestContextHolder.getRequestAttributes() != null){
            		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
                    if(request != null){
                    	beanWrapper.setPropertyValue("operateIp",HttpKit.getIpAddr(request));
                    	
                    	String operator = "visitor";
                    	HttpSession session  = request.getSession(false);
                    	if(session != null && session.getAttribute(WebConstant.USER_SESSION) != null){
                    		User user = (User) session.getAttribute(WebConstant.USER_SESSION);
                    		operator = user.getUserName();
                    	}
                    	beanWrapper.setPropertyValue("operator",operator);
                    }
            	}
            	
            }
            
            
        }
    
	}
	
	@Around("loger()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		String target = pjp.getTarget().getClass().getName();
		System.out.println(target+"---开始-->");
        Object result = pjp.proceed();
        System.out.println(target+"---结束-->");
        return result;
    }

    
}
