package com.bank;

public class FixedDepositAccount extends Account {
	private double depositAmount;
	private int tenure;

	public FixedDepositAccount(long accountNumber, long bsbCode, String bankName, double balance, String openingDate,
			double depositAmount, int tenure) {
		super(accountNumber, bsbCode, bankName, balance, openingDate);
		this.depositAmount = depositAmount;
		this.tenure = tenure;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	@Override
	public void calculateInterest() {
		// Interest calculation for FixedDepositAccount (8% per annum, times the tenure,
		// on the deposit)
		interestEarned = 0.08 * depositAmount * tenure;
	}

	@Override
	public String toString() {
		return super.toString() + "Deposit Amount: " + depositAmount + "\nTenure: " + tenure + " years\n";
	}
}
