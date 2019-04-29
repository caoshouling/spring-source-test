package org.csl.study.spring.source.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@EnableAspectJAutoProxy//默认是proxyTargetClass为false -JDK动态代理。proxyTargetClass为true时表示使用CGLIB
@ComponentScan(basePackages = "org.csl.study.spring.source")
@ImportResource(locations={"classpath:applicationContext.xml"})
public class AopConfig {

	
}
