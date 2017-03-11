package com.mightyjava.thread.basic;

public class UsingRunnable {
	public static void main(String[] args) {
		RunnableDemo runnableDemo = new RunnableDemo();
		Thread thread = new Thread(runnableDemo);
		thread.start();
		Thread thread2 = new Thread(runnableDemo);
		thread2.start();
	}
}

class RunnableDemo implements Runnable {

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