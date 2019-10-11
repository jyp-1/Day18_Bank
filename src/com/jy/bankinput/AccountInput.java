package com.jy.bankinput;

import java.util.Calendar;
import java.util.Scanner;
import com.jy.account.AccountDTO;

public class AccountInput {
	private Scanner sc;

	public AccountInput() {
		sc = new Scanner(System.in);
	}

	public AccountDTO accountCreate(Scanner sc) {
		AccountDTO accountDTO = new AccountDTO();

		System.out.println("계좌명");
		accountDTO.setAccountName(sc.next());
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis();
		accountDTO.setAccountNumber(String.valueOf(l));
		return accountDTO;

	}

}
