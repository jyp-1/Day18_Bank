package com.jy.bankview;

import java.util.ArrayList;

import com.jy.account.AccountDTO;

public class AccountView {

	public void view(ArrayList<AccountDTO> ar) {
		for (AccountDTO accountDTO : ar) {
			System.out.println("계좌번호\t\t계좌명\t잔액");
			System.out.print(accountDTO.getAccountNumber() + "\t");
			System.out.print(accountDTO.getAccountName() + "\t");
			System.out.print(accountDTO.getAccountBalance() + "\t");

		}

	}

}
