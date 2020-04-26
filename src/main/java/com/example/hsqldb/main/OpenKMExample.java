
package com.example.hsqldb.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.hsqldb.HSQLDBConnection;

public class OpenKMExample {

	public static void main(String[] args) {
		Connection con = HSQLDBConnection.getConnection();
		System.out.println("Connection Obtained");

		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM okm_user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("USR_ID = " + rs.getString("USR_ID") + 
						", USR_NAME = " + rs.getString("USR_NAME") + " "
						+ "USR_PASSWORD " + rs.getString("USR_PASSWORD"));
			}
			rs.close();
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}