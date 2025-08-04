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

@WebServlet("/validation")
public class ValidationController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		
		StudentDao dao = new StudentDao();
		boolean b  =dao.isUsernameExist(uname);
		
		PrintWriter pw = resp.getWriter();
		if(b)
		{
			pw.append("user already exist !!!");
		}
		
	}
	
	
	
}
