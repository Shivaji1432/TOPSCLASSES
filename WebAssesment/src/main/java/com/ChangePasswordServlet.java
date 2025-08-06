package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("userEmail");

		try {
			Connection con = DBConnection.getConnection();
			// Verify old password
			PreparedStatement check = con.prepareStatement("SELECT * FROM student WHERE email = ? AND password = ?");
			check.setString(1, email);
			check.setString(2, oldPassword);
			ResultSet rs = check.executeQuery();

			if (rs.next()) {
				// Old password correct → update new password
				PreparedStatement update = con.prepareStatement("UPDATE student SET password = ? WHERE email = ?");
				update.setString(1, newPassword);
				update.setString(2, email);
				int result = update.executeUpdate();

				if (result > 0) {
					response.sendRedirect("main.jsp");
				} else {
					response.getWriter().println("<h3 style='color:red;'>Password update failed.</h3>");
				}
			} else {
				response.getWriter().println("<h3 style='color:red;'>Old password is incorrect.</h3>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("<h3 style='color:red;'>Exception: " + e.getMessage() + "</h3>");
		}
	}
}
