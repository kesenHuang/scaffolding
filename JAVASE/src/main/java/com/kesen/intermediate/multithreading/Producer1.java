package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/29 07:07
 * @Description:
 **/
public class Producer1 implements Runnable {
	private Food food;

	Producer1(Food food) {
		this.food =  food;
	}
	@Override
	public void run() {
		while (true) {
			food.set("鸡排");
		}
	}
}
