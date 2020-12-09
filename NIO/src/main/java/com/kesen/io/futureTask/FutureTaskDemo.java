package com.kesen.io.futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Auther: kesen
 * @Date: 2020/8/9 14:56
 * @Description:
 **/
public class FutureTaskDemo {
	public static final int SLEEP_GAP = 500;

	public static String getCurThreadName() {
		return Thread.currentThread().getName();
	}

	static class HotWaterJob implements Callable<Boolean> {
		@Override
		public Boolean call() throws Exception {

			try {
				System.out.println("洗水壶");
				System.out.println("倒凉水");
				System.out.println("放在火上");

				Thread.sleep(SLEEP_GAP);
				System.out.println("水烧好了");

			} catch (InterruptedException e) {
				System.out.println(" hot water failed");
				return false;
			}

			return true;
		}
	}

	static class WashJob implements Callable<Boolean> {
		@Override
		public Boolean call() throws Exception {

			try {
				System.out.println("洗茶壶");
				System.out.println("洗茶杯");
				System.out.println("放茶叶");

				Thread.sleep(SLEEP_GAP);
				System.out.println("洗ending");

			} catch (InterruptedException e) {
				System.out.println(" wash failed");
				return false;
			}

			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		// 启动烧水线程任务
		Callable<Boolean> hotWaterJob  = new HotWaterJob();
		FutureTask<Boolean> hTask = new FutureTask<>(hotWaterJob);
		Thread hThread = new Thread(hTask);
		hThread.start();
		// 启动清洗茶杯任务
		Callable<Boolean> washJob  = new WashJob();
		FutureTask<Boolean> wTask = new FutureTask<>(washJob);
		Thread wThread = new Thread(wTask);
		wThread.start();

		//
		hThread.join();
		wThread.join();


		boolean waterOk = hTask.get();
		boolean cupOk = wTask.get();
		drinkTea(waterOk, cupOk);
	}

	static void drinkTea(boolean waterOk, boolean cupOk) {
		if (waterOk &&cupOk) {
			System.out.println(" 泡茶喝");
		} else if (!waterOk) {
			System.out.println(" 烧水任务失败");
		} else if (!cupOk) {
			System.out.println(" 杯子清洗工作失败");
		}
	}
}
