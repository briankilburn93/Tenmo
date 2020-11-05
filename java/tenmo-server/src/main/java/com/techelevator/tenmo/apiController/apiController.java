package com.techelevator.tenmo.apiController;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.tenmo.accounts.dao.JdbcAccountsDao;
import com.techelevator.tenmo.accounts.model.Accounts;

@RestController
public class apiController {
	
	private JdbcAccountsDao accountsDao;
	
	// Spring will dependency inject the JdbcAccountsDao into the constructor
	public apiController(JdbcAccountsDao accDao) {
		this.accountsDao = accDao;
	}
	
	@RequestMapping(path = "/accounts/searchUserId", method = RequestMethod.GET)
	public Accounts getAccount(@RequestParam(value="userId") int id) {
		return accountsDao.getAccountById(id);
	}
	
	@RequestMapping(path="/accounts", method=RequestMethod.GET)
	public List<Accounts> getAllAccounts() {
		return accountsDao.getAllAccounts();
	}

}
