package com.mightyjava.thread.inter;

public class MainClass {
	public static void main(String[] args) {
		Account account = new Account();
		new Thread() {
			public void run() {
				account.withdraw(15000);
			};
		}.start();
		new Thread() {
			public void run() {
				account.deposit(20000); 
			};
		}.start();
	}
}
