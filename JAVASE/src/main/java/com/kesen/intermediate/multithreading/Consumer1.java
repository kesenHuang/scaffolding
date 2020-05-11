package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/29 07:09
 * @Description:
 **/
public class Consumer2 implements Runnable {

	private Food food;
	Consumer2 (Food food) {
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
