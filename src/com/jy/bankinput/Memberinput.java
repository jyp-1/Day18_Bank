package com.jy.bankinput;

import java.util.Scanner;

import com.jy.member.MemberDTO;

public class Memberinput {
	
	//로그인 입력
	public MemberDTO memberLogin(Scanner sc) {
		
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("id 입력하세요");
		memberDTO.setId(sc.next());
		System.out.println("pw 입력하세요");
		memberDTO.setPw(sc.next());
		return memberDTO;
		
	}
	
	

	// 회원가입시 입력 받을 것들

	public MemberDTO memberJoin(Scanner sc) {

		MemberDTO memberDTO = new MemberDTO();
		System.out.println("ID를 입력하세요");
		memberDTO.setId(sc.next());
		System.out.println("PW를 입력하세요");
		memberDTO.setPw(sc.next());
		System.out.println("이름을 입력하세요");
		memberDTO.setName(sc.next());
		System.out.println("핸드폰번호를 입력하세요");
		memberDTO.setPhone(sc.next());
		System.out.println("이메일을 입력하세요");
		memberDTO.setEmail(sc.next());
		
			return memberDTO;	
	}

	
	
}
