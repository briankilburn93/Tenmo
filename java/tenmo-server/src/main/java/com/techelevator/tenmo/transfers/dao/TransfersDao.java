package com.techelevator.tenmo.transfers.dao;

import java.util.List;

import com.techelevator.tenmo.transfers.model.Transfers;

public interface TransfersDao {

	public List<Transfers> getAllTransfers();

	public Transfers addTransfer(Transfers transfer, int transfer_type_id, int transfer_status_id, int accountFrom, int accountTo, double amount);
}
