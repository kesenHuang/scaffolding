package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/27 21:39
 * @Description:
 **/
public class Producer implements Runnable {
	private Resource resource;

	Producer(Resource resource) {
		this.resource =  resource;
	}
	@Override
	public void run() {
		while (true) {
			resource.set("烤鸭");
		}
	}
}

