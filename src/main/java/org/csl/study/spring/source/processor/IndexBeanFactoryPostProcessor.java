package org.csl.study.spring.source.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;

@Component
public class IndexBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println(this.getClass().getSimpleName()+" -Bean工厂后置处理器- postProcessBeanFactory");
		
	}

	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		
		System.out.println(this.getClass().getSimpleName()+" -Bean工厂注册后置处理器- postProcessBeanDefinitionRegistry");
	}

}
