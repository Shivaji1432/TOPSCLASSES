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
public class RegisterControl extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		User user = new User();
		user.setUserName(name);;
		user.setEmail(email);
		user.setPass(pass);

		UserDao dao = new UserDao();
		int i = dao.addUser(user);
		if (i > 0) {
			req.setAttribute("msg", "User is Added");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			req.setAttribute("err", "User is not added");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
