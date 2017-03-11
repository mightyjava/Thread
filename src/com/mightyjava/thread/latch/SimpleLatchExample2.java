package com.mightyjava.thread.latch;

import java.util.concurrent.CountDownLatch;

public class SimpleLatchExample2 {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(4);
		new Worker(1000, latch).start();
		new Worker(2000, latch).start();
		new Worker(3000, latch).start();
		new Worker(4000, latch).start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("At last "+Thread.currentThread().getName()+" is done");
	}
}

class Worker extends Thread {
	private int delay;
	private CountDownLatch latch;
	
	public Worker(int delay, CountDownLatch latch) {
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(this.delay);
			System.out.println(Thread.currentThread().getName()+" is done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.latch.countDown();
	}
}
