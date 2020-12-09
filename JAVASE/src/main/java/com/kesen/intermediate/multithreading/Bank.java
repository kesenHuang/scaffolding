package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/27 07:17
 * @Description:
 **/
public class Bank {
	private int sum;

	public  synchronized void add(int num) {
		sum += num;
		try {
			Thread.sleep(1000);
			System.out.println("sum=" + sum);
		} catch (InterruptedException e) {
			System.out.println(" interruptedException sum=" + sum);
		}
	}
}
