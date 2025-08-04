package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/search")
public class Search extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String value=req.getParameter("value");
		
	PrintWriter pw=resp.getWriter();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/shivwork";
		String user="root";
		String pass="Pubg@1432";
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement ps=con.prepareStatement("select * from product where items like ?");
		ps.setString(1, value+"%");
		ResultSet rs=ps.executeQuery();
		String str="<ul>";
		while(rs.next()) {
			str+="<li>"+rs.getString(2)+"</li>";
		}
		str+="</ul>";
		pw.append(str);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
