package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newPassword = request.getParameter("password");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE student SET password = ? WHERE email = ?");
			ps.setString(1, newPassword);
			ps.setString(2, email);

			int result = ps.executeUpdate();

			if (result > 0) {
				// Password updated, clear OTP session, redirect to login
				session.removeAttribute("otp");
				session.removeAttribute("email");
				response.sendRedirect("login.jsp");
			} else {
				response.getWriter().println("<h3 style='color:red;'>Error updating password.</h3>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("<h3 style='color:red;'>Exception: " + e.getMessage() + "</h3>");
		}
	}
}
