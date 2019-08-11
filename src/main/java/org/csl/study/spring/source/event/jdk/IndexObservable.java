package org.csl.study.spring.source.event.jdk;

import java.util.Observable;

/**
 * 被观察者
 * @author Administrator
 *
 */
public class IndexObservable extends Observable{

	@Override
	protected synchronized void setChanged() {
		
		super.setChanged();
	}

}
