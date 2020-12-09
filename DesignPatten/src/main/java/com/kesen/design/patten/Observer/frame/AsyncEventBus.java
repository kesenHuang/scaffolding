package com.kesen.design.patten.Observer.frame;


import java.util.concurrent.Executor;

/**
 * @Auther: kesen
 * @Date: 2020/5/10 22:11
 * @Description:
 **/
public class AsyncEventBus extends  EventBus {

	public AsyncEventBus(Executor executor) {
		super(executor);
	}
}
