package com.techelevator.tenmo.apiController;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.tenmo.accounts.dao.JdbcAccountsDao;
import com.techelevator.tenmo.accounts.model.Accounts;
import com.techelevator.tenmo.users.dao.JdbcUsersDao;
import com.techelevator.tenmo.users.model.Users;

@RestController
public class apiController {
	
	private JdbcAccountsDao accountsDao;
	private JdbcUsersDao usersDao;
	
	// Spring will dependency inject the JdbcAccountsDao into the constructor
	public apiController(JdbcAccountsDao accDao, JdbcUsersDao usersDao) {
		this.accountsDao = accDao;
		this.usersDao = usersDao;
	}
	
	@RequestMapping(path = "/accounts/searchUserId", method = RequestMethod.GET)
	public Accounts getAccount(@RequestParam(value="userId") int id) {
		return accountsDao.getAccountById(id);
	}
	
	@RequestMapping(path="/users", method=RequestMethod.GET)
	public List<Users> getAllUsers() {
		return usersDao.getAllUsers();
	}

}
