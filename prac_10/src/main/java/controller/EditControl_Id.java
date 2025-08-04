package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
@WebServlet("/edit")
public class EditControl_Id extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String Name=req.getParameter("username");
	String email=req.getParameter("email");
	String pass=req.getParameter("pass");
	
	User user=new User();
	user.setId(id);
	user.setUserName(Name);
	user.setEmail(email);
	user.setPass(pass);
	
	UserDao dao= new UserDao();
	int i=dao.updateUser(user);
	if(i>0) {
	req.setAttribute("msg", "User Updated");
	req.getRequestDispatcher("update.jsp").forward(req, resp);
}else {
	req.setAttribute("err", "User Updated");
	req.getRequestDispatcher("update.jsp").forward(req, resp);
}
}
}
