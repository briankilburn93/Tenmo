package com.techelevator.tenmo.accounts.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.tenmo.accounts.model.Accounts;

public class JdbcAccountsDao implements AccountsDao {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcAccountsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);  // Assign the JdbcTemplate object the data source sent in from the user
    }
	private Accounts mapRowToAccounts(SqlRowSet result) {  // result has the row to be mapped
        Accounts account = new Accounts();                // Create a Java object
        account.setAccountId(result.getInt("account_id")); 
        account.setUserId(result.getInt("user_id")); 
        account.setBalance(result.getDouble("balance")); //     Copy the data
        return account;   // Return the Java object containing the data from the row
    }
	@Override
	public void getAccountBalance(int id) {

	        // Create a Java object
			String sqlGetBalance = "SELECT balance FROM accounts WHERE account_id=? ";
	        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetBalance, id);
	}		
}
	


	
	
