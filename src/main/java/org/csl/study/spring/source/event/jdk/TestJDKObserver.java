package org.csl.study.spring.source.event.jdk;

public class TestJDKObserver {

	public static void main(String[] args) {
		
		
		IndexObservable observable = new IndexObservable();
		
		IndexObserver_A indexObserver_A = new IndexObserver_A();
		IndexObserver_B indexObserver_B = new IndexObserver_B();
		
		observable.addObserver(indexObserver_A);
		observable.addObserver(indexObserver_B);
		//设置改变标志
		observable.setChanged();
		//通知观察者们
		observable.notifyObservers();
		System.out.println("-------------");
	}

}
