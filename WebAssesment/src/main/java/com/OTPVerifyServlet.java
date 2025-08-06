package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OTPVerifyServlet")
public class OTPVerifyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String enteredOtp = request.getParameter("otp");
		HttpSession session = request.getSession();
		String generatedOtp = (String) session.getAttribute("otp");

		if (enteredOtp.equals(generatedOtp)) {
			// OTP correct - forward to reset password page
			response.sendRedirect("resetPassword.jsp");
		} else {
			response.setContentType("text/html");
			response.getWriter().println("<h3 style='color:red;'>Invalid OTP. Please try again.</h3>");
		}
	}
}
