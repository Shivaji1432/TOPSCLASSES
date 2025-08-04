package controller;

import java.io.IOException;

import dao.Productdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet("/add")
public class AddData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int category = Integer.parseInt(req.getParameter("category"));
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String gender = req.getParameter("gender");
		int qty = Integer.parseInt(req.getParameter("qty"));
		String size[] = req.getParameterValues("size");
		String uid = req.getParameter("id");

		int id = 0;
		if (!uid.equals("")) {
			id = Integer.parseInt(uid);
		}

		String sizes = "";
		for (String s : size) {
			sizes += s + ",";
		}

		Productdao dao = new Productdao();

		Product p = new Product();
		p.setCategory(dao.catById(category));
		p.setName(name);
		p.setPrice(price);
		p.setGender(gender);
		p.setQty(qty);
		p.setSize(sizes);
		p.setId(id);

		int i = dao.addProduct(p);

		if (i > 0) {
			req.getRequestDispatcher("home").forward(req, resp);
		}
	}
}
