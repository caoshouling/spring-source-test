package org.csl.study.spring.source.event.spring.annotation;

import org.csl.study.spring.source.event.spring.IndexEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
/**
 * 监听器类 - 基于注解的
 *     也可以用@Async开启异步支持,当然，需要注意@Async需要额外的配置
 * @author Administrator
 *
 */
@Component
public class IndexAnnotationListener {
	
	@EventListener
	@Async  //开启异步支持，需要配置@Async
	public void onApplicationEvent_MyMethod(IndexEvent event) {
		
		System.out.println( "注解方式-检测到["+event.getClass().getSimpleName()+"]消息："+event.getMessage());
	}

}
