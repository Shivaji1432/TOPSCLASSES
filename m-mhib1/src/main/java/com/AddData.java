package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Course;
import model.Faculty;

public class AddData {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Faculty.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

//		Faculty f = new Faculty();
//		f.setName("Shiva");
		Faculty f = s.load(Faculty.class, 1);

		Course c = new Course();
		c.setName("python");
//		Course c = s.load(Course.class, 1);

		Course c1 = new Course();
		c1.setName("react");

		f.addCourse(c);
		f.addCourse(c1);

//		s.save(f);
		s.save(c);
		s.save(c1);

		tx.commit();
	}
}
