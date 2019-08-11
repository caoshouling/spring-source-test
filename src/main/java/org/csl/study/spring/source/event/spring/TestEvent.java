package org.csl.study.spring.source.event.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestEvent {
	
	 public static void main(String[] args) {
		
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		 applicationContext.scan("org.csl.study.spring.source.event.spring");
		 applicationContext.refresh();
		 IndexEvent indexEvent = new IndexEvent(new TestEvent(),"applicationContext发布的事件- 收到邮件了");
		 //直接用applicationContext发布事件
		 applicationContext.publishEvent(indexEvent);
		 System.out.println("-----------11-----------");
		 IndexEventPublisher indexEventPublisher = applicationContext.getBean(IndexEventPublisher.class);
		 //说明：这里的applicationEventPublisher对象其实就是applicationContext对象（applicationContext对象实现了applicationEventPublisher接口），
		 //其实就是applicationContext的publishEvent方法
		 ApplicationEventPublisher applicationEventPublisher =  indexEventPublisher.getApplicationEventPublisher();
		 //用applicationEventPublisher发布事件
		 indexEvent = new IndexEvent(new TestEvent(),"applicationEventPublisher发布的事件- 收到邮件了");
		 applicationEventPublisher.publishEvent(indexEvent);
		 System.out.println("-----------22-----------");
		 applicationContext.close();
		 
	 }

}
