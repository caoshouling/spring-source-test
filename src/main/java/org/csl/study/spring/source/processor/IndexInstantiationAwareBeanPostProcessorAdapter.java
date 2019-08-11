package org.csl.study.spring.source.processor;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;
@Component
public class IndexInstantiationAwareBeanPostProcessorAdapter  extends InstantiationAwareBeanPostProcessorAdapter implements InstantiationAwareBeanPostProcessor{

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter#postProcessBeforeInstantiation(java.lang.Class, java.lang.String)
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if(beanName.equals("indexApplicationContextAware"))
		System.out.println(this.getClass().getSimpleName()+" - postProcessBeforeInstantiation- :"+beanName);
		return super.postProcessBeforeInstantiation(beanClass, beanName);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter#postProcessAfterInstantiation(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if(beanName.equals("indexApplicationContextAware"))
			System.out.println(this.getClass().getSimpleName()+" - postProcessAfterInstantiation- :"+beanName);
		return super.postProcessAfterInstantiation(bean, beanName);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter#postProcessPropertyValues(org.springframework.beans.PropertyValues, java.beans.PropertyDescriptor[], java.lang.Object, java.lang.String)
	 */
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		if(beanName.equals("indexApplicationContextAware"))System.out.println(this.getClass().getSimpleName()+" - postProcessPropertyValues- :"+beanName);
		return super.postProcessPropertyValues(pvs, pds, bean, beanName);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("indexApplicationContextAware"))System.out.println(this.getClass().getSimpleName()+" - postProcessBeforeInitialization- :"+beanName);
		return super.postProcessBeforeInitialization(bean, beanName);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter#postProcessAfterInitialization(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("indexApplicationContextAware"))System.out.println(this.getClass().getSimpleName()+" - postProcessAfterInitialization- :"+beanName);
		return super.postProcessAfterInitialization(bean, beanName);
	}

}
