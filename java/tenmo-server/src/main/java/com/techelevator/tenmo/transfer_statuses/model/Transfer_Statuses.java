package com.techelevator.tenmo.transfer_statuses.model;

public class Transfer_Statuses {

	private int transferStatusId;
	private int transferStatusDescription;

	public int getTransferStatusId() {
		return transferStatusId;
	}

	public void setTransferStatusId(int transferStatusId) {
		this.transferStatusId = transferStatusId;
	}

	public int getTransferStatusDescription() {
		return transferStatusDescription;
	}

	public void setTransferStatusDescription(int transferStatusDescription) {
		this.transferStatusDescription = transferStatusDescription;
	}

	public String toString() {
		return "Your Transfer Status is:" + transferStatusId + " " + transferStatusDescription;
	}

}
