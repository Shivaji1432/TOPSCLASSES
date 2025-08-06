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

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// Email found, generate OTP
				String otp = String.valueOf((int) (Math.random() * 900000) + 100000);

				// Send Email (mock version or use SMTP if needed)
				// You can use JavaMail API for actual sending
				EmailUtil.sendEmail(email, "Your OTP", "Your OTP is: " + otp);

				// Save to session
				HttpSession session = request.getSession();
				session.setAttribute("otp", otp);
				session.setAttribute("email", email);

				response.sendRedirect("otpVerify.jsp");
			} else {
				response.getWriter().println("<h3 style='color:red;'>Email not registered!</h3>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
