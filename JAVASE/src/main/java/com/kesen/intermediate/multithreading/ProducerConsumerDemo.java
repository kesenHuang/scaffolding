package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/27 21:47
 * @Description:
 **/
public class ProducerConsumerDemo {
	public static void main(String[] args) {
/*
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);
		t0.start();
		t1.start();
		t2.start();
		t3.start();*/


		Food food = new Food();
		Producer1 pro = new Producer1(food);
		Consumer1 con = new Consumer1(food);
		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);
		t0.start();
		t1.start();
		t2.start();
		t3.start();

	}
}
