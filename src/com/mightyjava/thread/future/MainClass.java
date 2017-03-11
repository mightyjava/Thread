package com.mightyjava.thread.future;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {
	public static void main(String[] args) {
		Random random = new Random();
		int number = random.nextInt(20);
		Factorial factorial = new Factorial(number);
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<Long> future = (Future) executorService.submit(factorial);
		System.out.println("Task is submitted");
		while(!future.isDone()){
			System.out.println("Task not yet completed");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Task is completed");
		try {
			System.out.println(number + " : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}
}
