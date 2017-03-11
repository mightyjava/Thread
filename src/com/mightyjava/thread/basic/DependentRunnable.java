package com.mightyjava.thread.basic;

public class DependentRunnable {
	public static void main(String[] args) {
		Thread thread = new Thread(new RunnableB());
		thread.start();
	}
}

class RunnableA implements Runnable {
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

class RunnableB implements Runnable {
	@Override
	public void run() {
		Thread thread = new Thread(new RunnableA());
		thread.start();
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
