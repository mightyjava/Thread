package com.mightyjava.thread.pool;

import java.util.concurrent.ThreadPoolExecutor;

public class Monitor implements Runnable {
	private boolean run = true;
	private int delayInSeconds;
	private ThreadPoolExecutor poolExecutor;

	public Monitor(int delayInSeconds, ThreadPoolExecutor poolExecutor) {
		this.delayInSeconds = delayInSeconds;
		this.poolExecutor = poolExecutor;
	}

	@Override
	public void run() {
		while (run) {
			System.out.println("Thread Monitor");
			System.out.println("Core Pool Size : "+this.poolExecutor.getCorePoolSize());
			System.out.println("Maximum Pool Size : "+this.poolExecutor.getMaximumPoolSize());
			System.out.println("Active Count : "+this.poolExecutor.getActiveCount());
			System.out.println("Task Count : "+this.poolExecutor.getTaskCount());
			System.out.println("Is Shutdown : "+this.poolExecutor.isShutdown());
			System.out.println("Is Terminated : "+this.poolExecutor.isTerminated());
			try { 
				Thread.sleep(delayInSeconds * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		this.run = false;
	}

}
