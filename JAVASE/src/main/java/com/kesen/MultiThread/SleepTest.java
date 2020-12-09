package com.kesen.MultiThread;

/**
 * @Auther: kesen
 * @Date: 2020/9/28 22:38
 * @Description:
 **/
public class SleepTest {

	public static void main(String[] args) throws Exception{

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("child thread is in sleep");
					Thread.sleep(10000);

					System.out.println("child thread is in awaked");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		thread.start();

		Thread.sleep(2000);
		System.out.println("main thread is in awaked");
		thread.interrupt();
	}


}
