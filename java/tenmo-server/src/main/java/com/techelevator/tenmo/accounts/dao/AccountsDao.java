package com.techelevator.tenmo.accounts.dao;

import java.util.List;

import com.techelevator.tenmo.accounts.model.Accounts;

public interface AccountsDao {

	public Accounts getAccountById(int id);

	public List<Accounts> getAllAccounts();

	public void updateBalance(int id, double balance);
}
