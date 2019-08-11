package org.csl.study.spring.source.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class IndexBeanPostProcessor  implements BeanPostProcessor{


	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("IndexApplicationContextAware"))
		System.out.println("IndexBeanPostProcessor - postProcessBeforeInitialization Before :【"+beanName+"】");
		
		return bean;
	}

	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("IndexApplicationContextAware"))
		System.out.println("IndexBeanPostProcessor - postProcessAfterInitialization After :【"+beanName+"】");
		return bean;
	}

}
