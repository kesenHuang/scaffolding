package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/29 07:09
 * @Description:
 **/
public class Consumer1 implements Runnable {

	private Food food;
	Consumer1(Food food) {
		this.food = food;
	}

	@Override
	public void run() {
		while(true)
		{
			food.out();
		}

	}
}
