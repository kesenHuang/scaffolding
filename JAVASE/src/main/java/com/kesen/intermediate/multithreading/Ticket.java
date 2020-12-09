package com.kesen.intermediate.multithreading;

/**
 * @Auther: kesen
 * @Date: 2020/4/27 07:28
 * @Description:
 **/
public class Ticket implements Runnable {

	private int num = 100;
	Object obj = new Object();
	boolean flag = true;

	@Override
	public void run() {
		if (flag) {
			while (true){
				synchronized (obj){
					show();
				}
			}
		} else {
			while (true)
				this.show();
		}

	}

	public synchronized void show() {
		synchronized (obj) {
			if(num > 0) {
				try{Thread.sleep(10);}catch (InterruptedException e){}
				System.out.println(Thread.currentThread().getName()+".....sale...."+num--);

			}
		}
	}
}
