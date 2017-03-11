package com.mightyjava.thread.latch2;

import java.util.concurrent.CountDownLatch;

public class CacheHealthChecker extends BaseHealthChecker {

	public CacheHealthChecker(CountDownLatch latch, String serviceName) {
		super(latch, serviceName);
	}

	@Override
	public void verifyService() {
		System.out.println("Checked cache status");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName()+" is up");
	}
	
}
