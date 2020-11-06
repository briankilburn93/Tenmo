package com.techelevator.tenmo.transfers.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.transfers.model.Transfers;

@Component
public class JdbcTransfersDao implements TransfersDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTransfersDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	private Transfers mapRowToTransfers(SqlRowSet result) {  // result has the row to be mapped
        Transfers transfer = new Transfers();                // Create a Java object
        transfer.setTransferId(result.getInt("transfer_id")); 
        transfer.setTransferTypeId(result.getInt("transfer_type_id"));
        transfer.setTransferStatusId(result.getInt("transfer_status_id"));
        transfer.setAmount(result.getDouble("amount"));
        transfer.setAccountTo(result.getInt("account_to"));
        transfer.setAccountFrom(result.getInt("amount_from"));
        
        return transfer;   // Return the Java object containing the data from the row
    }
	@Override
	public List<Transfers> getAllTransfers() {
		List<Transfers> allTransfers = new ArrayList<>();
		String sqlGetAllTransfers = "SELECT * FROM Transfers";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllTransfers);
		
		while (results.next()) {
			Transfers transfersResult = mapRowToTransfers(results);
			allTransfers.add(transfersResult);
		}
		return allTransfers;
	}
	public Transfers addTransfer(Transfers transfer, int transfer_type_id, int transfer_status_id, int accountFrom, int accountTo, double amount) {
		String sqlAddTransfer = "INSERT INTO transfers (transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (?,?,?,?,?)";
		Integer id = jdbcTemplate.queryForObject(sqlAddTransfer, Integer.class, transfer.getTransferTypeId(), transfer.getTransferStatusId(), transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
		
		return addTransfer(transfer, id, id, id, id, amount);
		//return null;
	}
}
