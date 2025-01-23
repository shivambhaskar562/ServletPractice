package com.anotherpage;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.ServiceStudent;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RegisterPage extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		
		UserClass user = new UserClass(fname, lname, email);
		DriverRegister dr = new DriverRegister();
		boolean flag = dr.save(user);
		
		if(flag) {
			RequestDispatcher rd = req.getRequestDispatcher("/userLogin.html");
			rd.forward(req, resp);
		}
		else {
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>");
			out.println("Register Failed!!!");
			out.println("</h1>");
			out.println("<h3>Name: "+fname+" "+lname+" </h3>");
			out.println("<h3>Email: "+email+" </h3>");
			out.println("</body>");
			out.println("</html>");
		}
		
		
		
		
	}
}
