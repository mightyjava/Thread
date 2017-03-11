package com.mightyjava.thread.basic;

public class DependentThread {
	public static void main(String[] args) {
		ThreadB threadB = new ThreadB(); 
		threadB.setName("Thread B");
		threadB.start();
	}
}

class ThreadA extends Thread {
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

class ThreadB extends Thread {
	@Override
	public void run() {
		ThreadA threadA = new ThreadA();
		threadA.setName("Thread A");
		threadA.start();
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
