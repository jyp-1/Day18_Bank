package com.jy.utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

	// getConnection

	public static Connection getConnection() throws Exception {
		Connection con = null;
		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pw);
		
		return con;

	}

}
