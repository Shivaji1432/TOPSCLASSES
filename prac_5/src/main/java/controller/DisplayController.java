package controller;

import java.io.IOException;
import java.util.List;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
@WebServlet("/display")
public class DisplayController extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	UserDao dao=new UserDao();
	List<User>user=dao.viewusers();
	
	req.setAttribute("user", user);
	req.getRequestDispatcher("display.jsp").forward(req, resp);
}
}
