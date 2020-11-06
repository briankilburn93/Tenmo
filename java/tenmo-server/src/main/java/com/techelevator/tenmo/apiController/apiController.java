package com.techelevator.tenmo.apiController;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.accounts.dao.JdbcAccountsDao;
import com.techelevator.tenmo.accounts.model.Accounts;
import com.techelevator.tenmo.transfers.dao.JdbcTransfersDao;
import com.techelevator.tenmo.transfers.model.Transfers;
import com.techelevator.tenmo.users.dao.JdbcUsersDao;
import com.techelevator.tenmo.users.model.Users;

@RestController
public class apiController {
	
	private JdbcAccountsDao accountsDao;
	private JdbcUsersDao usersDao;
	private JdbcTransfersDao transferDao;
	
	// Spring will dependency inject the JdbcAccountsDao into the constructor
	public apiController(JdbcAccountsDao accDao, JdbcUsersDao usersDao, JdbcTransfersDao transferDao) {
		this.accountsDao = accDao;
		this.usersDao = usersDao;
		this.transferDao = transferDao;
	}
	
	@RequestMapping(path = "/accounts/searchUserId", method = RequestMethod.GET)
	public Accounts getAccount(@RequestParam(value="userId") int id) {
		return accountsDao.getAccountById(id);
	}
	
	@RequestMapping(path="/users", method=RequestMethod.GET)
	public List<Users> getAllUsers() {
		return usersDao.getAllUsers();
	}
	
	@RequestMapping(path="/transfers", method = RequestMethod.GET)
	public List<Transfers> getAllTransfers(){
		return transferDao.getAllTransfers();
	}
	
	@RequestMapping(path="/transfers", method=RequestMethod.POST)
	public Transfers addTransfer(@RequestBody Transfers transfers, @RequestParam (value="transfer_type_id") int transfer_type_id, @RequestParam (value="transfer_status_id") int transfer_status_id, @RequestParam (value="account_from") int accountFrom, @RequestParam (value="account_to") int accountTo, @RequestParam (value="amount") double amount) {
		return transferDao.addTransfer(transfers, transfer_type_id, transfer_status_id, accountFrom, accountTo, amount);
	}
	
	
}
