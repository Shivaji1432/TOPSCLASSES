package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.College;
import model.Student;

public class AddData {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(College.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		College c = new College();
		c.setName("Narmada");
//		College c = s.load(College.class, 1);

		Student st = new Student();
		st.setName("Khushi");
		st.setCollege(c);

		Student st1 = new Student();
		st1.setName("Manisha");
		st1.setCollege(c);

		s.save(c);
		s.save(st);
		s.save(st1);

		tx.commit();
	}
}
