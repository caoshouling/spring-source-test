package org.csl.study.spring.source.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.csl.study.spring.source.common.WebConstant;
import org.csl.study.spring.source.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    static  final  Set<String> allowUrls = new HashSet<String>();
    {
    	allowUrls.add("/login");
    	allowUrls.add("/vcode");
    	allowUrls.add("/register");
    	allowUrls.add("/forget");
    	allowUrls.add("/smsCode");
    }
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("登录拦截器----preHandle----");
		//获取请求的RUi:去除http:localhost:8080这部分剩下的
        String uri = request.getRequestURI();
        //UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
        for(String url_temp :allowUrls){
        	 if (uri.indexOf(url_temp) >= 0) {
                 return true;
             }
        }
        
        /** request.getSession(false) :false表示没有session，就返回null。
         *   request.getSession()和 request.getSession(true) ：获取Session，如果没有就创建一个session
         * **/ 
        HttpSession session = request.getSession(false);
        User user =  null;
        String errorStr = "还没有登陆，请先登录！";
        if(session != null){
        	
            user = (User) session.getAttribute(WebConstant.USER_SESSION);
            //判断session中是否有用户数据，如果有，则返回true，继续向下执行
            if (user != null) {
                return true;
            }
        }
        
        //中文部分转换成iso-8859-1字符用于网络传输。浏览器解可以自动解码
        String errorMessage = new String(errorStr.getBytes("utf-8"),"iso-8859-1");
        String redirectUrl =request.getContextPath()+"/login.ftl?"
        		+ "forwardUrl="+uri.substring(request.getContextPath().length())+"&"
        		+ "error="+errorMessage;
        response.sendRedirect(redirectUrl );

        return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("登录拦截器----postHandle----");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("登录拦截器----afterCompletion----");
	}

}
