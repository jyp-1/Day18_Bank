package com.jy.bankview;

import java.util.ArrayList;


import com.jy.accontinfo.AccountInfoDTO;

public class AccountInfoView {
	
	public void view(ArrayList<AccountInfoDTO> ar) {
		System.out.println("Tradenumber\tIncome\tBalance\tKind\tTradedate");
		for(AccountInfoDTO accountInfoDTO : ar) {
			System.out.print("\t"+accountInfoDTO.getTradenumber()+"\t");
			System.out.print(accountInfoDTO.getIncome()+"\t");
			System.out.print(accountInfoDTO.getAccountbalance()+"\t");
			System.out.print(accountInfoDTO.getIncomekind()+"\t");
			System.out.println(accountInfoDTO.getTradedate()+"\t");
		}
		
	}

}
