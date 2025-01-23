package com.anotherpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.Driver;

public class DriverLogin {
	private static final String url = "jdbc:postgresql://localhost:5432/ipdata?user=postgres&password=123";
	private static final String sql = "select * from register where email = ? and fname= ? and lname=?";
	
	static {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean retrive(UserClass user) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = DriverManager.getConnection(url);
			pstm = con.prepareStatement(sql);
			
			
			pstm.setString(1,user.email);
			pstm.setString(1,user.fname);
			pstm.setString(1,user.lname);
			
			ResultSet rs = pstm.getResultSet();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

