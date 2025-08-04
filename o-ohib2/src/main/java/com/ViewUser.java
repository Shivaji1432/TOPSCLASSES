package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Id_card;
import model.Student;

public class ViewUser {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Id_card.class).buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		List<Student> l = session.createQuery("from Student").list();
		for (Student student : l) {
			System.out.println(student.getName() + " " + student.getId() + " " + student.getCard().getName());
		}
		tx.commit();

	}
}
