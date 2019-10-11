package com.jy.member;

import java.util.Scanner;

import com.jy.account.AccountController;
import com.jy.account.AccountDAO;
import com.jy.bankinput.Memberinput;
import com.jy.bankview.BankView;

public class MemberController {

	private Scanner sc;
	private MemberDAO memberDAO;
	private Memberinput memberinput;
	private BankView bankView;
	private AccountController accountController;
	
	public MemberController() {
		sc = new Scanner(System.in);
		memberDAO = new MemberDAO();
		memberinput = new Memberinput();
		bankView = new BankView();
		accountController = new AccountController();
		

	}

	public void start() throws Exception {
		boolean check = true;
		while (check) {
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.종료");
			int select = sc.nextInt();

			MemberDTO memberDTO = null;

			switch (select) {

			case 1:
				memberDTO = memberinput.memberJoin(sc);
				try {
					select = memberDAO.memberJoin(memberDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					select = 0;
				}
				String msg = "Member Join Fail";
				if (memberDTO !=null) {
					msg = "Member Join Success";
					
				}

				bankView.view(msg);

				break;

			case 2:
				memberDTO=memberinput.memberLogin(sc);
				try {
					memberDTO=memberDAO.memberLogin(memberDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					memberDTO=null;
				}
				String msg2 ="login fail";
				if(memberDTO !=null) {
					
					bankView.view("login success");
					accountController.start(memberDTO);
				}else {
					bankView.view("login fail");
					
				}
				break;
				
				
			default:
				check = false;
				// check =! check
				break;

			}

		}

	}
}