package com.techelevator.tenmo.pojosWeCreated.models;

public class Accounts {

	private int accountId;
	private int userId;
	private double balance;
	/***********************************
	 * Methods
	 **********************************/

	@Override
	public String toString() {
		return " You have a balance of: " + balance + " in your account.";

	}

	/***********************************
	 * Gets and Sets
	 **********************************/
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


}
