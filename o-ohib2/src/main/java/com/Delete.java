package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Id_card;
import model.Student;

public class Delete {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Id_card.class).buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Student c = session.get(Student.class, 1);
		session.delete(c);
		tx.commit();

	}
}
