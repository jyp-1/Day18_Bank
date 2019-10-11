package com.jy.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jy.accontinfo.AccountInfoDTO;
import com.jy.utill.DBConnector;

public class AccountDAO {

	// updateBalance

	public int updateBalance(AccountInfoDTO accountInfoDTO) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		con = DBConnector.getConnection();

		String sql = "update account set accountbalnace=? where accountnumber=?";

		st = con.prepareStatement(sql);

		st.setLong(1, accountInfoDTO.getAccountbalance());
		st.setString(2, accountInfoDTO.getAccountnumber());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	// accountBalance

	public long getAccountBalance(String accountnumber) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		long balance = 0;

		con = DBConnector.getConnection();
		String sql = "select accountbalance from account where accountnumber=? ";

		st = con.prepareStatement(sql);
		st.setString(1, accountnumber);

		rs = st.executeQuery();

		if (rs.next()) {
			balance = rs.getLong("accountbalance");

		}

		rs.close();
		st.close();
		con.close();

		return balance;
	}

	// 계좌 조회 accountSelect -> view 로 보내기

	public ArrayList<AccountDTO> accountSelect(String id) throws Exception {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		AccountDTO accountDTO = null;
		ArrayList<AccountDTO> ar = new ArrayList<AccountDTO>();

		con = DBConnector.getConnection();
		String sql = "select * from account " + "where id=?"; // 로그인 한 사람것만
		st = con.prepareStatement(sql);
		st.setString(1, id); // 매개변수로 String id 받아옴
		rs = st.executeQuery();

		while (rs.next()) {
			accountDTO = new AccountDTO();
			accountDTO.setAccountNumber(rs.getString("ACCOUNTNUMBER"));
			accountDTO.setAccountName(rs.getString("ACCOUNTNAME"));
			accountDTO.setAccountBalance(rs.getInt("ACCOUNTBALANCE"));
			accountDTO.setID(rs.getString("ID"));
			ar.add(accountDTO);
		}

		rs.close();
		st.close();
		con.close();

		return ar;

	}

	// 계좌생성

	public int accountCreate(AccountDTO accountDTO) throws Exception {

		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		con = DBConnector.getConnection();
		String sql = "insert into account values(?,?,0,?)";
		st = con.prepareStatement(sql);
		st.setString(1, accountDTO.getAccountNumber());
		st.setString(2, accountDTO.getAccountName());
		st.setString(3, accountDTO.getID());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

}
