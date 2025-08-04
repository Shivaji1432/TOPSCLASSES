package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Country;
import model.President;

public class ViewUser {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Country.class)
				.addAnnotatedClass(President.class).buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		List<Country> l = session.createQuery("from Country").list();
		for (Country country : l) {
			System.out.println(country.getName() + " " + country.getId() + " " + country.getPresident().getName());
		}
		tx.commit();

	}
}
