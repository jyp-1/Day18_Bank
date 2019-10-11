package com.jy.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jy.utill.DBConnector;

public class MemberDAO {

	private Scanner sc;

	public MemberDAO() {
		sc = new Scanner(System.in);
	}

	// 회원가입
	public int memberJoin(MemberDTO memberDTO) throws Exception {

		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		con = DBConnector.getConnection();
		String sql = "insert into member values(?,?,?,?,?) ";
		st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	// 로그인
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		con = DBConnector.getConnection();
		String sql = "select * from member " + "where id=? and pw=?";

		st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		rs = st.executeQuery();

		if (rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getNString("phone"));
			memberDTO.setEmail(rs.getString("email"));
		} else {
			memberDTO = null;
		}

		rs.close();
		st.close();
		con.close();

		return memberDTO;

	}

}
