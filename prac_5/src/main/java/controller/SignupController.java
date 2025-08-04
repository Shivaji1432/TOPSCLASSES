package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
@WebServlet("/reg")
public class SignupController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String uname=req.getParameter("uname");
	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	
	User user=new User();
	user.setUname(uname);
	user.setEmail(email);
	user.setPass(pass);
	
	UserDao dao=new UserDao();
	if(dao.isEmailExist(email)) {
		req.setAttribute("err", "invalid User");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}else {
	
		int i= dao.adduser(user);
		
		if(i>0) {
			req.setAttribute("msg", "User added....");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
}
}
