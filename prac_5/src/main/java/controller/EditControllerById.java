package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
@WebServlet("/edit")
public class EditControllerById extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	String uname = req.getParameter("uname");
	String email = req.getParameter("email");
	String pass = req.getParameter("pass");
	User user = new User();
	user.setId(id);
	user.setUname(uname);
	user.setEmail(email);
	user.setPass(pass);
	
	UserDao dao=new UserDao();
	int i= dao.updateuser(user);
	if(i>0)
	{
		req.setAttribute("msg", "Update successfully !!!");
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}else {
        req.setAttribute("err", "Update failed. Try again.");
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}
}
