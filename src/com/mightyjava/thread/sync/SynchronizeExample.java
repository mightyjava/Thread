package com.mightyjava.thread.sync;

public class SynchronizeExample {
	public static void main(String[] args) {
		ThreadDemo threadDemo = new ThreadDemo();
		threadDemo.start();
		ThreadDemo threadDemo1 = new ThreadDemo();
		threadDemo1.start();
		/*Printer printer = new Printer();
		ThreadDemo threadDemo = new ThreadDemo(printer);
		threadDemo.start();
		ThreadDemo threadDemo1 = new ThreadDemo(printer);
		threadDemo1.start();*/
	}
}

class ThreadDemo extends Thread {
	/*private Printer printer;
	public ThreadDemo(Printer printer) {
		this.printer = printer;
	}*/
	
	@Override
	public void run() {
		new Printer().printing(5);
		/*synchronized (printer) {
			printer.printing(5);
		}*/
		//Printer.printing(5); 
	}
}

class Printer {
	/*public void printing(int count) {
		synchronized (Printer.class) {
			for (int i = count; i > 0; i--) {
				System.out.println("Printing.. Document no for " + Thread.currentThread().getName() + " : " + i);
			} 
		}
	}*/
	public void printing(int count) {
		for (int i = count; i > 0; i--) {
			System.out.println("Printing.. Document no for " + Thread.currentThread().getName() + " : " + i);
		} 
	}
	/*public static synchronized void printing(int count) {
		for (int i = count; i > 0; i--) {
			System.out.println("Printing.. Document no for " + Thread.currentThread().getName() + " : " + i);
		} 
	}*/
}