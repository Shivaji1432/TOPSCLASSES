package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
@WebServlet("/edit")
public class UpdateUId extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
	String email=req.getParameter("email");
	String phone=req.getParameter("phone");
	String pass=req.getParameter("pass");
	
	Users users=new Users();
	users.setId(id);
	users.setFname(fname);
	users.setLname(lname);
	users.setEmail(email);
	users.setPhone(phone);
	users.setPass(pass);
	
	UserDao dao=new UserDao();
	int i=dao.updateUser(users);
	if(i>0)
	{
		req.setAttribute("msg", "Update successfully !!!");
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}
}
}
