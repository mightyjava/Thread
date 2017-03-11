package com.mightyjava.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		//ExecutorService executorService = Executors.newCachedThreadPool();
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		//ExecutorService executorService = Executors.newWorkStealingPool();
		//ExecutorService executorService = Executors.newScheduledThreadPool(5);
		//ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new RunnableDemo(i));
		} 
		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}
		System.out.println("Execution Completed");
	}
}

class RunnableDemo implements Runnable {
	private int i;
	public RunnableDemo(int i) {
		this.i = i;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":" + i);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}