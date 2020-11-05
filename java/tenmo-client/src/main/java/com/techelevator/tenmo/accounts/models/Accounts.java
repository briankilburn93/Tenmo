package com.techelevator.tenmo.accounts.models;

import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.AuthenticatedUser;

public class Accounts {
	private String API_BASE_URL = "";
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

