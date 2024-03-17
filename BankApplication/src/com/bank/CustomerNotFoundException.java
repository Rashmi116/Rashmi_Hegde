package com.bank;

class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException(String message) {
		System.out.println("customer not found");
	}
}
