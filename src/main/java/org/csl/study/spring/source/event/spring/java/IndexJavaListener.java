package org.csl.study.spring.source.event.spring.java;

import org.csl.study.spring.source.event.spring.IndexEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
/**
 * 监听器类 -基于接口的
 * @author Administrator
 *
 */
@Component
public class IndexJavaListener implements ApplicationListener<IndexEvent> {
	
	public void onApplicationEvent(IndexEvent event) {
		
		System.out.println( "接口方式-检测到["+event.getClass().getSimpleName()+"]消息："+event.getMessage());
	    
	}

}
