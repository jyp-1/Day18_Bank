package com.jy.account;

public class AccountDTO {
	
	private String AccountNumber;
	private String AccountName;
	private int AccountBalance;
	private String ID;
	
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public int getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		AccountBalance = accountBalance;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

}
