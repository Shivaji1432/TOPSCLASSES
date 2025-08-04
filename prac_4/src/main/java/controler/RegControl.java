		package controler;

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
        String name = req.getParameter("uname");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");

        User user = new User();
        user.setUname(name);
        user.setEmail(email);
        user.setPass(password);

        
        UserDao dao = new UserDao();
       if( dao.emailexist(email)) {
    	   req.setAttribute("err", "Registration failed.");
           req.getRequestDispatcher("index.jsp").forward(req, resp);
       }else {
        int result = dao.addUser(user);

        if (result > 0) {
            req.setAttribute("msg", "Registration succeeded.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } 
       }
    }
}
