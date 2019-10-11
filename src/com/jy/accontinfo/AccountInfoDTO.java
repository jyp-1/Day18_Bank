package com.jy.accontinfo;

import java.sql.Date;

public class AccountInfoDTO {

	private long tradenumber;
	private String accountnumber;
	private long income;
	private long accountbalance;
	private int incomekind; // 0 출금, 1 입금
	private Date tradedate;

	public long getTradenumber() {
		return tradenumber;
	}

	public void setTradenumber(long tradenumber) {
		this.tradenumber = tradenumber;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public long getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(long accountbalance) {
		this.accountbalance = accountbalance;
	}

	public int getIncomekind() {
		return incomekind;
	}

	public void setIncomekind(int incomekind) {
		this.incomekind = incomekind;
	}

	public Date getTradedate() {
		return tradedate;
	}

	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}

}
