package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class Registerservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		System.out.println(name + " " + email + " " + password);

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shivwork";
			String user = "root";
			String pass = "Pubg@1432";
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("connection established");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO registration  VALUES (?,?, ?, ?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);

			int i = ps.executeUpdate();

			if (i > 0) {
				PrintWriter pw=resp.getWriter();
				pw.write("<h1>REGISTRATION SUCESS</h1>");
				req.setAttribute("msg", "REGISTRATION SUCESS...");
					RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
					//rd.include(req, resp);
					rd.forward(req, resp);
				//	resp.sendRedirect("index.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
