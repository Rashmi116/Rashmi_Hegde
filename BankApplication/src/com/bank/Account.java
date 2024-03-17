package com.bank;

abstract class Account {
	protected long accountNumber;
	protected long bsbCode;
	protected String bankName;
	protected double balance;
	protected String openingDate;
	protected double interestEarned;

	public Account(long accountNumber, long bsbCode, String bankName, double balance, String openingDate) {
		this.accountNumber = accountNumber;
		this.bsbCode = bsbCode;
		this.bankName = bankName;
		this.balance = balance;
		this.openingDate = openingDate;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getBsbCode() {
		return bsbCode;
	}

	public void setBsbCode(long bsbCode) {
		this.bsbCode = bsbCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public double getInterestEarned() {
		return interestEarned;
	}

	public void setInterestEarned(double interestEarned) {
		this.interestEarned = interestEarned;
	}

	// Abstract method for calculating interest
	public abstract void calculateInterest();

	@Override
	public String toString() {
		return "Account Number: " + accountNumber + "\nBSB Code: " + bsbCode + "\nBank Name: " + bankName
				+ "\nBalance: " + balance + "\nOpening Date: " + openingDate + "\nInterest Earned: " + interestEarned
				+ "\n";
	}

	
}

