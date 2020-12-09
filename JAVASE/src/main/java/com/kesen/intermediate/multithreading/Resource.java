package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/27 21:23
 * @Description:
 **/
public class Resource {

	private String name;
	private int count = 1;
	private boolean flag = false;

	public synchronized void set(String name) {
		while (flag)
			try {
				this.wait();
			} catch (InterruptedException e) {

			}
		this.name = name + count;
		count++;
		System.out.println((Thread.currentThread().getName() + "... 生产者..." + this.name));
		flag = true;
		notifyAll();

	}

	public synchronized void out() {
		while (!flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		System.out.println(Thread.currentThread().getName() + "... 消费者........" + this.name);
		flag = false;
		notifyAll();

	}
}
