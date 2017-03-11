package com.mightyjava.thread.inter;

public class Account {
	int balance = 10000;

	synchronized void withdraw(int amount) {
		System.out.println("Available balance " + balance + " and going to withdraw " + amount);
		if (balance < amount) {
			System.out.println("Insufficient balance");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		balance -= amount;
		System.out.println("After withdraw balance " + balance);
	} 

	synchronized void deposit(int amount) {
		System.out.println("Deposit amount " + amount);
		balance += amount;
		System.out.println("Available balance " + balance);
		notify();
	}
}
