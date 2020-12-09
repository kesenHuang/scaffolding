package com.kesen.design.patten.Observer;

/**
 * @Auther: kesen
 * @Date: 2020/5/8 22:04
 * @Description:
 **/
public class ConcreteObserverTwo implements Observer {
	@Override
	public void update(Message message) {
		//TODO: 获取消息通知，执行自己的逻辑...
		System.out.println("ConcreteObserverTwo is notified.");
	}
}