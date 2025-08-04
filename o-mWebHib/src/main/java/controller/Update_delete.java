package controller;

import java.io.IOException;
import java.util.List;

import dao.Productdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet("/update")
public class Update_delete extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uid = req.getParameter("id");
		String action = req.getParameter("action");

		int id = 0;
		if (!uid.equals("")) {
			id = Integer.parseInt(uid);
		}
		// System.out.println(id);
		Productdao dao = new Productdao();

		if (action.equals("delete")) {
			int i = dao.deleteUser(id);

			if (i > 0) {
				req.getRequestDispatcher("home").forward(req, resp);
			}
		}
		if (action.equals("update")) {
			Product product = dao.getUserById(id);
			req.setAttribute("product", product); // For pre-filling the form

			// Also fetch all products to show in the table
			List<Product> allProducts = dao.allProducts();
			req.setAttribute("products", allProducts); // So JSP doesn't crash
			// req.setAttribute("categories", dao.allCategories());

			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}

	}
}
