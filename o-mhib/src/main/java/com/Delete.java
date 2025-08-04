package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Category;
import model.Product;

public class Delete {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Product p = s.get(Product.class, 4);
		s.delete(p);
		tx.commit();
	}
}
