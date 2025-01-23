package com.anotherpage;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginPage extends HttpServlet{
//	String DataFname;
//	String DataLname;
//	String DataEmail;
//	
//	public void save(UserClass user) {
//		DataFname = user.getFname();
//		DataLname = user.getLname();
//		DataEmail = user.getEmail();	
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname= req.getParameter("fname");
		String lname= req.getParameter("lname");
		String email= req.getParameter("email");

		UserClass user = new UserClass(fname, lname, email);
		DriverLogin dl = new DriverLogin();
		boolean flag = dl.retrive(user);
		
		PrintWriter out = resp.getWriter();
		
		if(flag) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>");
			out.println("Login Successful");
			out.println("</h1>");
			out.println("<h1>");
			out.println("Welcome Page");
			out.println("</h1>");
			out.println("<h3>Name: "+fname+" "+lname+" </h3>");
			out.println("<h3>Email: "+email+" </h3>");
			out.println("</body>");
			out.println("</html>");
		
		}
		else {
			String errorMessage = "Login Failed!!!";
	        req.setAttribute("Error", errorMessage);

	        RequestDispatcher rd = req.getRequestDispatcher("/userLogin.html");
	        rd.include(req, resp);

	        PrintWriter o = resp.getWriter();
	        o.println("<html>");
	        o.println("<body>");
	        o.println("<div style='color: red;'>");
	        o.println(req.getAttribute("Error"));
	        o.println("</div>");
	        o.println("</body>");
	        o.println("</html>");
		}
			
	}

}
