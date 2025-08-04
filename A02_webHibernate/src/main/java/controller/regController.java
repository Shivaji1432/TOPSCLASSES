package controller;

import java.io.IOException;

import dao.Userdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/reg")
public class regController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uid = req.getParameter("id");
		int id = 0;
		if (!uid.equals(" ")) {
			id = Integer.parseInt(uid);
		}

		String name = req.getParameter("uname");
		String email = req.getParameter("email");

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);

		Userdao dao = new Userdao();
		int result = dao.addUser(user);

		if (result > 0) {
			req.setAttribute("msg", "Registration succeeded.");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
