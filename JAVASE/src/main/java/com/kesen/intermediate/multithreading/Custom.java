package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/27 07:20
 * @Description:
 **/
public class Custom implements Runnable {

	private Bank b = new Bank();
	@Override
	public void run() {
		for(int x=0; x<3; x++)
		{
			b.add(100);
		}
	}
}
