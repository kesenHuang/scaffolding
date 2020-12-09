package com.kesen.intermediate.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: kesen
 * @Date: 2020/4/29 06:56
 * @Description:
 **/

/**
 * 总结：一个监视器con和signaAll搭配使用，和this.wait/notifyAll类似
 *      多个监视器，对单独是监视器进行await和signal
 */


/*class BoundedBuffer {
	final Lock lock = new ReentrantLock();
	final Condition notFull  = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];
	int putptr, takeptr, count;

	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[putptr] = x;
			if (++putptr == items.length) putptr = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			Object x = items[takeptr];
			if (++takeptr == items.length) takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}*/

public class Food {
	private String name;
	private int count;
	private boolean flag = false;

	Lock lock = new ReentrantLock();

	//通过已有的锁获取该锁上的监视器对象。
	Condition con = lock.newCondition();

	//通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者。
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();

	public void set(String name) {
		lock.lock();
		try {
			//
			while (flag)
				try {
					//con.await();
					producer_con.await();
				} catch (InterruptedException e) {

				}
			this.name = name + count;
			count++;
			String message = "%s...生产者...%s";
			System.out.println(String.format(message, Thread.currentThread().getName(), this.name));
			flag = true;
			//con.signalAll();
			consumer_con.signal();
		} finally {
			lock.unlock();
		}

	}


	public void  out() {
		lock.lock();
		try {
			//
			while (!flag)
				try {
					//con.await();
					consumer_con.await();
				} catch (InterruptedException e) {

				}
			String message = "%s...消费者...%s";
			System.out.println(String.format(message, Thread.currentThread().getName(), this.name));
			flag = false;
			//con.signalAll();
			producer_con.signal();
		} finally {
			lock.unlock();
		}

	}
}
