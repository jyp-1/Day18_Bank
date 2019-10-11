package com.jy.bank;

import java.util.ArrayList;

import com.jy.accontinfo.AccountInfoController;
import com.jy.accontinfo.AccountInfoDAO;
import com.jy.accontinfo.AccountInfoDTO;
import com.jy.account.AccountController;
import com.jy.account.AccountDTO;
import com.jy.bankview.AccountInfoView;
import com.jy.member.MemberController;
import com.jy.member.MemberDAO;
import com.jy.member.MemberDTO;

public class BankMain {

	public static void main(String[] args) throws Exception {

		MemberController memberController = new MemberController();
		memberController.start();
	}

}
