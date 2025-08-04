package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Course;
import model.Faculty;

public class UpdateData {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Faculty.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Faculty f = s.load(Faculty.class, 1);

		Course c = s.load(Course.class, 7);

		f.addCourse(c);

		s.saveOrUpdate(f);
		s.saveOrUpdate(c);

		tx.commit();
	}
}
