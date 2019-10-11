package com.jy.account;

import java.util.ArrayList;
import java.util.Scanner;

import com.jy.accontinfo.AccountInfoController;
import com.jy.bankinput.AccountInput;
import com.jy.bankview.AccountView;
import com.jy.bankview.BankView;
import com.jy.member.MemberDTO;

public class AccountController {

	private Scanner sc;
	private AccountDAO accountDAO;
	private AccountInput accountInput;
	private AccountDTO accountDTO;
	private BankView bankView;
	private AccountView accountView;
	private AccountInfoController accountInfoController;

	public AccountController() {
		sc = new Scanner(System.in);
		accountDAO = new AccountDAO();
		accountInput = new AccountInput();
		bankView = new BankView();
		accountView = new AccountView();
		accountInfoController = new AccountInfoController();

	}

	public void start(MemberDTO memberDTO) throws Exception {

		boolean check = true;
		int select = 0;

		while (check) {
			System.out.println("1. 계좌생성");
			System.out.println("2. 계좌조회");
			System.out.println("3. 은행업무");
			System.out.println("4. 종료");
			select = sc.nextInt();

			switch (select) {

			case 1:
				accountDTO = accountInput.accountCreate(sc);
				accountDTO.setID(memberDTO.getId());
				try {
					select = accountDAO.accountCreate(accountDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					select = 0;
				}
				String str = "create fail";
				if (select > 0) {
					str = "reate success";
				}
				bankView.view(str);
				break;

			case 2:
				try {
					ArrayList<AccountDTO> ar = accountDAO.accountSelect(memberDTO.getId());
					accountView.view(ar);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			case 3:
				ArrayList<AccountDTO> ar = null;
				try {
					ar = accountDAO.accountSelect(memberDTO.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				for (int i = 0; i < ar.size(); i++) {
					System.out.println(i + 1 + ". " + ar.get(i).getAccountNumber());
				}
				select = sc.nextInt();
				
				accountInfoController.start(ar.get(select - 1).getAccountNumber());

				break;

			default:
				check = false;
				break;

			}

		}

	}

}
