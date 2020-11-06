package com.techelevator.tenmo.accounts.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.accounts.model.Accounts;

@Component // This tells Spring to dependency inject where it's needed
public class JdbcAccountsDao implements AccountsDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcAccountsDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); // Assign the JdbcTemplate object the data source sent in from
															// the user
	}

	private Accounts mapRowToAccounts(SqlRowSet result) { // result has the row to be mapped
		Accounts account = new Accounts(); // Create a Java object
		account.setAccountId(result.getInt("account_id"));
		account.setUserId(result.getInt("user_id"));
		account.setBalance(result.getDouble("balance")); // Copy the data
		return account; // Return the Java object containing the data from the row
	}

	@Override
	public List<Accounts> getAllAccounts() {
		List<Accounts> allAccounts = new ArrayList<>();
		String sqlGetAllAccounts = "SELECT * FROM accounts";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllAccounts);

		while (results.next()) {
			Accounts accountResult = mapRowToAccounts(results);
			allAccounts.add(accountResult);
		}
		return allAccounts;
	}

	@Override
	public Accounts getAccountById(int id) {
		String sqlGetAccount = "SELECT * FROM accounts WHERE account_id=? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAccount, id);
		if (results.next()) {
			return mapRowToAccounts(results);
		} else {
			return null;
		}
	}

	public void updateBalance(int id, double balance) {
		String sqlSetAccount = "UPDATE accounts SET balance=? WHERE user_id=?";
		jdbcTemplate.update(sqlSetAccount, balance, id);

	}

}
