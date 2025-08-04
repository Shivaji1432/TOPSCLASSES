package controller;

import java.io.IOException;

import dao.Userdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/update")
public class UpdateCon extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String action = req.getParameter("action");

		Userdao dao = new Userdao();
		if (action.equals("delete")) {

			int i = dao.deleteUser(id);
			if (i > 0) {
				req.getRequestDispatcher("Display").forward(req, resp);
			}
		} else if (action.equals("update")) {
			User user = dao.getUserById(id);
			req.setAttribute("user", user);
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
	}
}
