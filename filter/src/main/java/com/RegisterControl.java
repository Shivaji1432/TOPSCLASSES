package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class RegisterControl extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.write("<h2>"+name+"</h2>");
		pw.write("<h2>"+email+"</h2>");
		pw.write("<h2>"+pass+"</h2>");
	}
}
