package org.csl.study.spring.source.event.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class IndexEventPublisher implements ApplicationEventPublisherAware{

	private ApplicationEventPublisher applicationEventPublisher;
	
	
	public ApplicationEventPublisher getApplicationEventPublisher() {
		return applicationEventPublisher;
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		
		this.applicationEventPublisher = applicationEventPublisher;
		
	}

}
