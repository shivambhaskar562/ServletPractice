package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.Driver;

public class ServiceStudent  {
	private static final String url = "jdbc:postgresql://localhost:5432/studentdatabase?user=postgres&password=123";
	private static final String sqlQ1 = "insert into student(fname, lname, email, age) VALUES (?, ?, ?, ?);";
	
	
	static {
		try {
			DriverManager.registerDriver(new Driver());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	int n = -1;
	public int save(Student std) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		 
		try {
			con = DriverManager.getConnection(url);	
			pstm = con.prepareStatement(sqlQ1);
			
			pstm.setString(1, std.getFname());
			pstm.setString(2, std.getLname());
			pstm.setString(3, std.getEmail());
			pstm.setInt(4, std.getAge());
		
			n = pstm.executeUpdate();
			return n;	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		finally {
			try {
				pstm.close();
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
}
