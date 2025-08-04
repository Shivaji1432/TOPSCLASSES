package controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String action = req.getParameter("action");

		PrintWriter pw = resp.getWriter();
		if (id == null || id.trim().isEmpty()) {
			pw.print("{\"error\":\"Invalid or missing ID\"}");
			return;
		}

		if (action == null || action.trim().isEmpty()) {
			pw.print("{\"error\":\"Invalid or missing action\"}");
			return;
		}
		int uid = Integer.parseInt(id);

		StudentDao dao = new StudentDao();

		if (action.equals("delete")) {

			int i = dao.deleteStudent(uid);
			if (i > 0) {
				pw.append("deleted user!!!");
			}
		} else if (action.equals("update")) {
			Student st = dao.userById(uid);

			Gson json = new Gson();

			pw.append(json.toJson(st));

		}
	}
}
