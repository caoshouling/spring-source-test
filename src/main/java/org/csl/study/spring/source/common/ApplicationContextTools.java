package org.csl.study.spring.source.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextTools implements ApplicationContextAware{
	private ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(this.getClass().getSimpleName()+" - 实现了ApplicationContextAware接口，对属性ApplicationContext赋值-->");
		this.applicationContext = applicationContext;
		
	}

}
