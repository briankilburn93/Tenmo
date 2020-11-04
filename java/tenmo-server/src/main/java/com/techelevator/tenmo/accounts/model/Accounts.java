package com.techelevator.tenmo.accounts.model;

public class Accounts {

	private Long accountId;
	private Long userId;
	private double balance;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return " You have a balance of: " + balance + " in your account.";

	}

}
