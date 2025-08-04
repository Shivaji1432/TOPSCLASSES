package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/nav")
public class NavCon extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String action=req.getParameter("action");
	
	if(action.equals("home")) {
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}else if(action.equals("about")) {
		req.getRequestDispatcher("about.jsp").forward(req, resp);
	}
}
}
