package com.anotherpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.Driver;

public class DriverRegister {
	
	public static final String url = "jdbc:postgresql://localhost:5432/ipdata?user=postgres&password=123";
	public static final String sql = "insert into register(fname,lname,email) values(?,?,?)";
	static {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean save(UserClass usr) {
		String fname = usr.getFname();
		String lname = usr.getLname();
		String email = usr.getEmail();
		
		Connection con = null;
		PreparedStatement pstm = null;
		int n = 0;
		
		try {
			con = DriverManager.getConnection(url);
			pstm = con.prepareStatement(sql);
			pstm.setString(1, fname);
			pstm.setString(2, lname);
			pstm.setString(3, email);
			n= pstm.executeUpdate();
			if(n>0) return true;
			
		} catch (SQLException e) {
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
