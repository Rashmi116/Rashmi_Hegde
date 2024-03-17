package com.bank;

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		System.out.println("insufficient balance");
	}
}