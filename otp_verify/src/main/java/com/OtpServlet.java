package com;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sendotp")
public class OtpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Random r = new Random();
		int otp = r.nextInt(100, 999);

		EmailSender.sendmail(email, "Otp verification", "Your otp is" + otp);

		ServletContext cx = req.getServletContext();
		cx.setAttribute("otp", otp + "");

		req.getRequestDispatcher("otp.jsp").forward(req, resp);
	}
}
