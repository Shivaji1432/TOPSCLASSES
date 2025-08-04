package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;

@WebServlet("/update")
public class UpdateCon extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		int id = Integer.parseInt(req.getParameter("id"));
		UserDao dao=new UserDao();
		if(action.equals("delete")) {
			int i=dao.deleteuser(id);
			if(i>0) {
				req.getRequestDispatcher("display").forward(req, resp);
			}
		}else if(action.equals("update")) {
			Users users=dao.getUserById(id);
			req.setAttribute("users", users);
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
		
		
	}
}
