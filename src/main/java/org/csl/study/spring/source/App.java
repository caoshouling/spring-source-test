package org.csl.study.spring.source;

import org.csl.study.spring.source.config.AopConfig;
import org.csl.study.spring.source.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
		IndexService IndexService = applicationContext.getBean(IndexService.class);
		IndexService.setParam();
		
		System.out.println("返回name = "+IndexService.getName());
	}
}
