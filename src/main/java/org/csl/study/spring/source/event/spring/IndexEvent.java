package org.csl.study.spring.source.event.spring;

import org.springframework.context.ApplicationEvent;

public class IndexEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;

	private String message;
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public IndexEvent(Object source) {
		super(source);
	}

	public IndexEvent(Object source,String message) {
		super(source);
		this.message = message;
	}

}
