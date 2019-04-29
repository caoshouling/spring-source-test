package org.csl.study.spring.source.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
public class IndexBeanPostProcessor  implements BeanPostProcessor{


	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("indexDao"))
		System.out.println("IndexBeanPostProcessor - postProcessBeforeInitialization Before :【"+beanName+"】");
		
		return bean;
	}

	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("indexDao"))
		System.out.println("IndexBeanPostProcessor - postProcessAfterInitialization After :【"+beanName+"】");
		return bean;
	}

}
