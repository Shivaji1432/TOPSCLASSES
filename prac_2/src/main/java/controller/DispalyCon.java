package controller;

import java.io.IOException;
import java.util.List;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;

@WebServlet("/display")
public class DispalyCon extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
	String email=req.getParameter("email");
	String phone=req.getParameter("phone");
	String pass=req.getParameter("pass");
	
	UserDao dao= new UserDao();
	List<Users> users=dao.getUser();
	
	req.setAttribute("users", users);
	req.getRequestDispatcher("display.jsp").forward(req, resp);;
}
}
