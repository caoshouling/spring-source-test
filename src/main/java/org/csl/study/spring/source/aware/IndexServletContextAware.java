package org.csl.study.spring.source.aware;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

@Component
public class IndexServletContextAware implements ServletContextAware{
	
    static ServletContext servletContext;

	/**
	 * @return the servletContext
	 */
	public static ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		
		System.out.println("------------servletContext-----------------");
		
		this.servletContext =  servletContext;
	}
	


	
}
