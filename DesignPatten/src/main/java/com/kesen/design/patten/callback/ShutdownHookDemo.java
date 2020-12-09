package com.kesen.design.patten.callback;

/**
 * @Auther: kesen
 * @Date: 2020/5/11 20:55
 * @Description:
 **/
public class ShutdownHookDemo {

	private static class ShutdownHook extends Thread{
		@Override
		public void run() {
			System.out.println("I am called during shutting down.");
		}
	}

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new ShutdownHook());
	}
}
