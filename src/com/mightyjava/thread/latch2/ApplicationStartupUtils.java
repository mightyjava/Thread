package com.mightyjava.thread.latch2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApplicationStartupUtils {
	private static List<BaseHealthChecker> services;
	private static CountDownLatch latch;
	
	private static final ApplicationStartupUtils instance = new ApplicationStartupUtils();
	
	private ApplicationStartupUtils() {
		//singleton
	}
	
	public static ApplicationStartupUtils getInstance() {
		return instance;
	}
	
	public static boolean checkServiceHealth() {
		latch = new CountDownLatch(3);
		services = new ArrayList<BaseHealthChecker>();
		services.add(new NetworkHealthChecker(latch, "network service"));
		services.add(new CacheHealthChecker(latch, "cache service"));
		services.add(new DatabaseHealthChecker(latch, "db service"));
		Executor executor = Executors.newFixedThreadPool(3);
		for (BaseHealthChecker baseHealthChecker : services) {
			executor.execute(baseHealthChecker);
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (BaseHealthChecker baseHealthChecker : services) {
			if(!baseHealthChecker.getServiceStatus())
				return false;
		}
		return true;
	}
}
