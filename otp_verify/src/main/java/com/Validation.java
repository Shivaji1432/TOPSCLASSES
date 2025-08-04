package com;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/otp")
public class Validation extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String otp = req.getParameter("otp");

		ServletContext cx = req.getServletContext();
		String o_otp = (String) cx.getAttribute("otp");

		if (otp.equals(o_otp)) {
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "Invalid otp");
			req.getRequestDispatcher("otp.jsp").forward(req, resp);
		}
	}
}
