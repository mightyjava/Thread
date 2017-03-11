package com.mightyjava.thread.latch2;

import java.util.concurrent.CountDownLatch;

public class DatabaseHealthChecker extends BaseHealthChecker {

	public DatabaseHealthChecker(CountDownLatch latch, String serviceName) {
		super(latch, serviceName);
	}

	@Override
	public void verifyService() {
		System.out.println("Checked database status");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getServiceName()+" is up");
	}

}
