package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO student (first_name, last_name, email, mobile, address, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, mobile);
			ps.setString(5, address);
			ps.setString(6, gender);
			ps.setString(7, password); // Plain text for demo only. You should hash in real apps.

			int i = ps.executeUpdate();
			if (i > 0) {
				response.sendRedirect("login.jsp?msg=Registered Successfully!");
			} else {
				response.getWriter().println("Registration failed!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		}
	}
}
