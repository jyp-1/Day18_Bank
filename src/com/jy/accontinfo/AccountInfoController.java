package com.jy.accontinfo;

import java.util.ArrayList;
import java.util.Scanner;

import com.jy.account.AccountDAO;
import com.jy.bankinput.AccountInfoInput;
import com.jy.bankview.AccountInfoView;
import com.jy.bankview.BankView;

public class AccountInfoController {
	private Scanner sc;
	private AccountInfoDAO accountInfoDAO;
	private AccountInfoView accountInfoView;
	private AccountInfoInput accountInfoInput;
	private AccountDAO accountDAO;
	private BankView bankview;
	

	public AccountInfoController() {
		sc = new Scanner(System.in);
		accountInfoDAO = new AccountInfoDAO();
		accountInfoView = new AccountInfoView();
		accountInfoInput = new AccountInfoInput();
		accountDAO = new AccountDAO();
		bankview = new BankView();
	}

	public void start(String accountnumber) {

		boolean check = true;
		while (check) {
			System.out.println("1. 입출금내역조회");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 종료");

			int select = sc.nextInt();

			switch (select) {

			case 1:

			
				try {
					ArrayList<AccountInfoDTO> ar = accountInfoDAO.incomeSelect(accountnumber);
					accountInfoView.view(ar);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;

			case 2:
				try {
					long income = accountInfoInput.incomeInput(sc);
					long balance = accountDAO.getAccountBalance(accountnumber);
					AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
					accountInfoDTO.setIncomekind(1);
					accountInfoDTO.setAccountnumber(accountnumber);
					accountInfoDTO.setIncome(income);
					accountInfoDTO.setAccountbalance(balance + income);
					select = accountInfoDAO.income(accountInfoDTO);
					if (select > 0) {
						select = accountDAO.updateBalance(accountInfoDTO);
					}
				} catch (Exception e) {
					e.printStackTrace();
					select = 0;
				}
				if (select > 0) {
					bankview.view("입금성공");
				} else {
					bankview.view("입금실패");
				}

				break;

			case 3:
				try {
					long income = accountInfoInput.incomeInput(sc);
					long balance = accountDAO.getAccountBalance(accountnumber);
					AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
					accountInfoDTO.setIncomekind(0);
					accountInfoDTO.setAccountnumber(accountnumber);
					accountInfoDTO.setIncome(income);
					accountInfoDTO.setAccountbalance(balance - income);
					select = accountInfoDAO.income(accountInfoDTO);
					if (select > 0) {
						select = accountDAO.updateBalance(accountInfoDTO);
					}
				} catch (Exception e) {
					select = 0;
				}
				if (select > 0) {
					bankview.view("출금성공");
				} else {
					bankview.view("출금실패");
				}

				break;

			default:
				check = false;
				break;
			}

		}

	}
}