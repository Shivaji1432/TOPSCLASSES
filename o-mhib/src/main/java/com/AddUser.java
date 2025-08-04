package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Category;
import model.Product;

public class AddUser {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

//		Category c = new Category();
//		c.setName("Electrical");

		Category c = s.get(Category.class, 3);

		Product p = new Product();
		p.setName("fridge");
		p.setPrice(500);
		p.setCategory(c);

		Product p1 = new Product();
		p1.setName("Ac");
		p1.setPrice(500);
		p1.setCategory(c);

		s.save(c);
		s.save(p);
		s.save(p1);
		tx.commit();
	}
}
