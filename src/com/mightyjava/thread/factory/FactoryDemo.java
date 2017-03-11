package com.mightyjava.thread.factory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class FactoryDemo {
	public static void main(String[] args) {
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool(threadFactory);
		for (int i = 0; i < 5; i++) {
			threadPoolExecutor.execute(new RunnableDemo(i));
		}
		threadPoolExecutor.shutdown();
	}
}

class RunnableDemo implements Runnable {

	private int count;

	public RunnableDemo(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":" + count);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
