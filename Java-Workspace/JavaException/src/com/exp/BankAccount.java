package com.exp;

public class BankAccount {
	private int balance=100;
	
	public void withdraw(int amt) throws InsufficientFundsException  {
		if(amt<balance) {
			balance=balance-amt;
		}
		else {
			InsufficientFundsException exc=new InsufficientFundsException("not sufficient money");
			throw exc;
		}
		
	}

}
