package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/27 21:42
 * @Description:
 **/

public  class Consumer implements Runnable {
	private Resource resource;
	Consumer (Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while(true)
		{
			resource.out();
		}

	}
}