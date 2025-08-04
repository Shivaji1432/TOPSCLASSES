package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
@WebServlet("/update")
public class EditController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=Integer.parseInt(req.getParameter("id"));
    String action=req.getParameter("action");
    
    UserDao dao=new UserDao();
    if(action.equals("Delete")) {
    	int i=dao.deleteUser(id);
   if(i>0) {
    	req.getRequestDispatcher("display").forward(req, resp);
   }
    }else if(action.equals("Update")) {
    	User user=dao.userById(id);
    	req.setAttribute("user", user);
    	req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}
}
