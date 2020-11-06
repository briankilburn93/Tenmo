package com.techelevator.tenmo.pojosWeCreated.models;

public class Transfer_Types {
	
	private int transferTypeId;
	private String transferTypeDescription;
	
	
	
	public int getTransferTypeId() {
		return transferTypeId;
	}
	public void setTransferTypeId(int transferTypeId) {
		this.transferTypeId = transferTypeId;
	}
	public String getTransferTypeDescription() {
		return transferTypeDescription;
	}
	public void setTransferTypeDescription(String transferTypeDescription) {
		this.transferTypeDescription = transferTypeDescription;
	}
	
	public String toString() {
		return transferTypeId + transferTypeDescription;
	}
	

}
