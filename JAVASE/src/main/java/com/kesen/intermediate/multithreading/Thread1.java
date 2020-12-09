package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/26 22:38
 * @Description:
 **/
public class Thread1 extends  Thread {

	private String name;

	public Thread1(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("name:" + name);
	}
}
