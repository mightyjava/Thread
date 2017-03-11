package com.mightyjava.thread.inter;

import java.util.ArrayList;
import java.util.List;

public class UsingSynchronized {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Thread producerThread = new Thread(new Producer(list));
		Thread consumerThread = new Thread(new Consumer(list));
		producerThread.start();
		consumerThread.start();
	}
}

class Producer implements Runnable {
	List<Integer> list;

	public Producer(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (list) {
				System.out.println("Adding in list " + Thread.currentThread().getName() + ":" + ++i);
				list.add(i);
				if (i > 4)
					break;
			}
		}
	}
}

class Consumer implements Runnable {
	List<Integer> list;

	public Consumer(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (list) {
				if(!list.isEmpty()) {
					System.out.println("Getting from list " + Thread.currentThread().getName() + ":" + list.get(0));
					if(list.get(0) == 5) break;
					list.remove(0);
				}
			}
		}
	}
}
