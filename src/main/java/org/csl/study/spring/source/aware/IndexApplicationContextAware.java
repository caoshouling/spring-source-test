package org.csl.study.spring.source.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class IndexApplicationContextAware implements ApplicationContextAware{
	
	static ApplicationContext applicationContext;
	
	/**
	 * @return the applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}



	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("------------applicationContext-----------------");
		this.applicationContext = applicationContext;
	}

}
