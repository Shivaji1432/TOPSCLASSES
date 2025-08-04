package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Category;
import model.Product;

public class ViewUser {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		List<Product> p = s.createQuery("from Product").list();
		for (Product product : p) {
			System.out.println(product.getName() + " " + product.getCategory().getName());
		}

		tx.commit();
	}
}
