package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
@WebServlet("/signup")
public class Signupcontrol extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		String pass=req.getParameter("pass");
		
		Users users=new Users();
		users.setFname(fname);
		users.setLname(lname);
		users.setEmail(email);
		users.setPhone(phone);
		users.setPass(pass);
		
		UserDao dao=new UserDao();
		if(dao.isEmailExist(email)) {
			req.setAttribute("err", "User email is already register try another email.");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else {
		int i=dao.adduser(users);
		
		req.setAttribute("msg", "User Added..");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
}
