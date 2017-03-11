package com.mightyjava.thread.future;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Long> {
	private int number;

	public Factorial(int number) {
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		return calculate();
	}
	
	private Long calculate() {
		long result = 1;
		if (this.number < 0) {
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		while (this.number > 0) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result *= this.number;
			this.number--;
		}
		return result;
	}
}
