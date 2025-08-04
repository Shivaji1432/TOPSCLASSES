package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Country;
import model.President;

public class Delete {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Country.class)
				.addAnnotatedClass(President.class).buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Country c = session.get(Country.class, 1);
		session.delete(c);
		tx.commit();

	}
}
