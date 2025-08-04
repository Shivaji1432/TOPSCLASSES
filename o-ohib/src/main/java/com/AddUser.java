package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Country;
import model.President;

public class AddUser {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Country.class)
				.addAnnotatedClass(President.class).buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Country c = new Country();
		c.setName("Usa");

		President p = new President();
		p.setName("Donald Trump");

		c.setPresident(p);
		session.save(c);
		tx.commit();

	}
}
