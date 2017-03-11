package com.mightyjava.thread.basic;

public class UsingThread {
	public static void main(String[] args) {
		//System.out.println(Thread.currentThread().getName());
		ThreadDemo threadDemo = new ThreadDemo();
		threadDemo.start();
		ThreadDemo threadDemo1 = new ThreadDemo();
		threadDemo1.start();
		//threadDemo.run();
	}
}

class ThreadDemo extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i); 
		}
	}
}
