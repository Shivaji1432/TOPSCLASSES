package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet("/upload")
public class ImageUpload extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Part img = req.getPart("img");

		String imgname = Paths.get(img.getSubmittedFileName()).toString();

		String path = req.getServletContext().getRealPath("/");
		String mypath = path + File.separator + "img";

		File file = new File(mypath);

		if (!file.exists()) {
			file.mkdir();
		}
		img.write(mypath + File.separator + imgname);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivwork", "root", "Pubg@1432");

			PreparedStatement ps = cn.prepareStatement("insert into upload values(?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, imgname);

			ps.executeUpdate();

			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
