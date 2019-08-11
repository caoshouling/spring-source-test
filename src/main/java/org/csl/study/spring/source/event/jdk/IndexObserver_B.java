package org.csl.study.spring.source.event.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 * @author Administrator
 *
 */
public class IndexObserver_B implements Observer{

	public void update(Observable o, Object arg) {
		
		System.out.println("IndexObserver_B检测到["+o.getClass().getSimpleName()+"]变更 --> 执行响应操作");
	}

}
