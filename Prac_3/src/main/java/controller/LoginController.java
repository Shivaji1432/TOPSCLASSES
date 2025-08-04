package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Users;
@WebServlet("/login")
public class LoginController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	
	Users users=new Users();
	users.setEmail(email);
	users.setPass(pass);
	UserDao dao=new UserDao();
	Users u=dao.isUserExist(users);
	if(u==null) {
		req.setAttribute("err", "invalid user");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}else {
		HttpSession session=req.getSession();
		session.setAttribute("users", u.getEmail());
		req.getRequestDispatcher("display").forward(req, resp);
		return;
	}
	
}
}
