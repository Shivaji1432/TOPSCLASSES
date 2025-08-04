package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Id_card;
import model.Student;

public class AddUser {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Id_card.class).buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Student c = new Student();
		c.setName("Sitesh");

		Id_card st = new Id_card();
		st.setName("Sitesh@1234");

		c.setCard(st);
		session.save(c);
		tx.commit();

	}
}
