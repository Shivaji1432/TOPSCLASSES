package controller;

import java.io.IOException;
import java.util.List;

import dao.Userdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/Display")
public class DisplayCont extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String email = req.getParameter("email");

		Userdao dao = new Userdao();
		List<User> users = dao.viewUser();

		req.setAttribute("users", users);
		req.getRequestDispatcher("Display.jsp").forward(req, resp);
	}
}
