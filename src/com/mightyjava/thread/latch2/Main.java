package com.mightyjava.thread.latch2;

public class Main {
	public static void main(String[] args) {
		boolean result = ApplicationStartupUtils.checkServiceHealth();
		System.out.println("Health check up complete status : " + result); 
	}
}
