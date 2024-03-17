package com.bank;

public class SavingsAccount extends Account {
	private boolean isSalaryAccount;
	private double minimumBalance = 100; // default value

	public SavingsAccount(long accountNumber, long bsbCode, String bankName, double balance, String openingDate,
			boolean isSalaryAccount) {
		super(accountNumber, bsbCode, bankName, balance, openingDate);
		this.isSalaryAccount = isSalaryAccount;
	}

	@Override
	public void calculateInterest() {
		// Interest calculation for SavingsAccount (4% of the balance)
		interestEarned = 0.04 * balance;
	}

	public void deposit(double depositAmount) {
		if (depositAmount > 0) {
			this.balance += depositAmount;
			System.out.println("Deposit successful. New balance: " + this.balance);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(double withdrawalAmount) throws InsufficientBalanceException {
		if (withdrawalAmount > 0) {
			if (this.balance < withdrawalAmount) {
				System.out.println("balance is not suffcient" + this.balance);
			} else {
				this.balance -= withdrawalAmount;
			}
		} else {
			throw new InsufficientBalanceException(
					"Insufficient balance for withdrawal. Minimum balance should be maintained.");
		}

	}

	public void checkBalance() {
		 System.out.println("Current balance: " + this.balance);
	}

	@Override
	public String toString() {
		return "SavingsAccount [isSalaryAccount=" + isSalaryAccount + ", minimumBalance=" + minimumBalance + "]";
	}

}

