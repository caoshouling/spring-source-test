package org.csl.study.spring.source.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextTools implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(this.getClass().getSimpleName()+" - 实现了ApplicationContextAware接口，对属性ApplicationContext赋值-->");
		ApplicationContextTools.applicationContext = applicationContext;
		
	}
	
	public static <T> T getBean(Class<T> requiredType){
		return applicationContext.getBean(requiredType);
		
	}
	public static Object getBean(String name){
		return applicationContext.getBean(name);
		
	}
}
