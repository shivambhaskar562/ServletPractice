package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstPage extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		
//		PrintWriter out = resp.getWriter();
//		out.println(fname);
//		out.println(lname);
//		out.println(email);
//		out.println(age);
		
		Student std = new Student(fname, lname, email, age);
		ServiceStudent serv = new ServiceStudent();
		serv.save(std);
		
	}
}
