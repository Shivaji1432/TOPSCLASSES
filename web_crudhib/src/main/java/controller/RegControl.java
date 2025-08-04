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
public class RegControl extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String uid = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");

//		int id = 0;
//		if (!uid.equals(" ")) {
//			id = Integer.parseInt(uid);
//		}

		User user = new User();
//		user.setId(id);
		user.setName(name);
		user.setEmail(email);

		UserDao dao = new UserDao();
		int i = dao.addUser(user);
		if (i > 0) {
			req.setAttribute("msg", "user added");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			req.setAttribute("err", "user not added");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
