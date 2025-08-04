package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.College;
import model.Student;

public class ViewData {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(College.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		List<Student> student = s.createQuery("from Student").list();
		for (Student st : student) {
			System.out.println(st.getName() + " " + st.getCollege().getName());
		}
	}
}
