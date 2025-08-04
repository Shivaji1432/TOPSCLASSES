package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String id = req.getParameter("id");
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		Student st = new Student();
		st.setName(uname);
		st.setEmail(email);
		st.setpass(pass);

		StudentDao dao = new StudentDao();
		int i = 0;

		if (id != null && !id.isEmpty()) {
			try {
				int uid = Integer.parseInt(id);
				st.setId(uid);
				i = dao.editUser(st);

				if (i > 0) {
					pw.append("Update successfully !!!");
				} else {
					pw.append("Update failed.");
				}
			} catch (NumberFormatException e) {
				pw.append("Invalid ID.");
			}
		} else {
			i = dao.addStudet(st);
			if (i > 0) {
				pw.append("Registration successfully !!!");
			} else {
				pw.append("Registration failed.");
			}
		}
	}
}
