package com.mightyjava.thread.latch2;

import java.util.concurrent.CountDownLatch;

public abstract class BaseHealthChecker implements Runnable {
	private CountDownLatch latch;
	private String serviceName;
	private Boolean serviceStatus;
	
	public BaseHealthChecker(CountDownLatch latch, String serviceName) {
		this.latch = latch;
		this.serviceName = serviceName;
	}
	
	public String getServiceName() {
		return serviceName;
	}

	public Boolean getServiceStatus() {
		return serviceStatus;
	}
	
	public abstract void verifyService();

	@Override
	public void run() {
		try {
			verifyService();
			serviceStatus = true;
		} catch(Exception ex) {
			ex.printStackTrace();
			serviceStatus = false;
		} finally {
			if(latch != null) {
				latch.countDown();
			}
		}
	}
}