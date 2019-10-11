package com.jy.accontinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jy.utill.DBConnector;

public class AccountInfoDAO {

	// 내역조회 incomeSelect //최신순으로 출력(desc)
	


	public ArrayList<AccountInfoDTO> incomeSelect(String accountnumber) throws Exception {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AccountInfoDTO> ar = new ArrayList<AccountInfoDTO>();
		

		con = DBConnector.getConnection();
		String sql = "select * from accountinfo where accountnumber=? "
				+ "order by tradenumber desc ";
		st = con.prepareStatement(sql);
		st.setString(1, accountnumber);
		rs = st.executeQuery();

		while (rs.next()) {
			AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
			accountInfoDTO.setTradenumber(rs.getLong("tradenumber"));
			accountInfoDTO.setAccountnumber(rs.getString("accountnumber"));
			accountInfoDTO.setIncome(rs.getLong("income"));
			accountInfoDTO.setAccountbalance(rs.getLong("accountbalance"));
			accountInfoDTO.setIncomekind(rs.getInt("incomekind"));
			accountInfoDTO.setTradedate(rs.getDate("tradedate"));
			ar.add(accountInfoDTO);

		}

		rs.close();
		st.close();
		con.close();

		return ar;

	}

	// 입금,출금 업무

	public int income(AccountInfoDTO accountInfoDTO) throws Exception {

		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		con = DBConnector.getConnection();

		String sql = "insert into accountinfo values(trade_seq.nextval,?,?,?,?,sysdate) ";

		st = con.prepareStatement(sql);
		st.setString(1, accountInfoDTO.getAccountnumber());
		st.setLong(2, accountInfoDTO.getIncome());
		st.setLong(3, accountInfoDTO.getAccountbalance());   //0, 1 일때로 나누기  \ 한가지로 쓰는방법? if문?
		st.setInt(4, accountInfoDTO.getIncomekind());

		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		
		return result;

	}
}
