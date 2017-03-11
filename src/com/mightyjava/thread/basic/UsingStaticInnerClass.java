package com.mightyjava.thread.basic;

public class UsingStaticInnerClass {
	static class ThreadDemo extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static class RunnableDemo implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		RunnableDemo runnableDemo = new RunnableDemo();
		Thread thread = new Thread(runnableDemo);
		thread.start();
		Thread thread2 = new Thread(runnableDemo);
		thread2.start();
		
		ThreadDemo threadDemo = new ThreadDemo();
		threadDemo.start();
		ThreadDemo threadDemo2 = new ThreadDemo();
		threadDemo2.start();
	}
}
