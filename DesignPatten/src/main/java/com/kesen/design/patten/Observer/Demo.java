package com.kesen.design.patten.Observer;

/**
 * @Auther: kesen
 * @Date: 2020/5/8 22:04
 * @Description:
 **/
public class Demo {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		subject.registerObserver(new ConcreteObserverOne());
		subject.registerObserver(new ConcreteObserverTwo());
		subject.notifyObservers(new Message());
	}
}
