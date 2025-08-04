package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class Login extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("uname");
	String pass=req.getParameter("pass");
	
	if(name.equals("admin") && pass.equals("admin"))
			{
		HttpSession session =req.getSession();
		session.setAttribute("uname", name);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
			}else {
		
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
}
