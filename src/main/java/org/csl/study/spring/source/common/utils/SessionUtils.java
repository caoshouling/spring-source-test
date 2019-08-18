package org.csl.study.spring.source.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.csl.study.spring.source.common.WebConstant;
import org.csl.study.spring.source.po.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtils {

	/**
	 * 获取当前用户
	 * @return
	 */
	public static User getCurrentUser(){
		
		HttpServletRequest request =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    	if(request != null){
    		HttpSession session = request.getSession(false);
        	if(session != null){
        		return ((User)request.getSession().getAttribute(WebConstant.USER_SESSION));
        		
        	}
    	}
    	return null;
		
	}
}
