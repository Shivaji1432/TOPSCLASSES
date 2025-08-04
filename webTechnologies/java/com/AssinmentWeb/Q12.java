package com.AssinmentWeb;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Q12")
public class Q12 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		    out.println("<html><body>");
	        out.println("<h2>Received Data</h2>");
	        out.println("<p>Name: " + name + "</p>");
	        out.println("<p>Email: " + email + "</p>");
	        out.println("<p>Phone: " + phone + "</p>");
	        out.println("</body></html>");

	}

}
