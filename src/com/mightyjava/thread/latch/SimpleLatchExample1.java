package com.mightyjava.thread.latch;

import java.util.concurrent.CountDownLatch;

public class SimpleLatchExample1 {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		new Thread(new ServiceOne(latch)).start();
		new Thread(new ServiceTwo(latch)).start();
		try {
			latch.await();
			System.out.println("starting main thread " + latch.getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
	}
}

class ServiceOne implements Runnable {
	private CountDownLatch latch;

	public ServiceOne(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Starting service one " + latch.getCount());
		this.latch.countDown();
	}
}

class ServiceTwo implements Runnable {
	private CountDownLatch latch;

	public ServiceTwo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Starting service two " + latch.getCount());
		this.latch.countDown();
	}
}
