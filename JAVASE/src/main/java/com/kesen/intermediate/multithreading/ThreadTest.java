package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/27 07:14
 * @Description:
 **/
public class ThreadTest {
	public static void main(String[] args) {
		/*Thread1 thread1 = new Thread1("kesen");
		thread1.start();*/
		//custom 看做是任务
		Custom c = new Custom();
		Thread t1 = new Thread(c);
		Thread t2= new Thread(c);
		t1.start();
		t2.start();
	}
}
