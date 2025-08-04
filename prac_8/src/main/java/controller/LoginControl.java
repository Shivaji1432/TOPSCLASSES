package controller;

import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;


import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
@WebServlet("/login")
public class LoginControl extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	
	User user= new User();
	user.setEmail(email);
	user.setPass(pass);
	
	UserDao dao=new UserDao();
	User u=dao.isUserExist(user);	
	if(u==null){
		req.setAttribute("err", "Invalid user");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}else {
		HttpSession session=req.getSession();
		session.setAttribute("user", user);
		req.getRequestDispatcher("display").forward(req, resp);
		return;
	}
}
}
