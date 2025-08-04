package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Course;
import model.Faculty;

public class ViewData {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Faculty.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		List<Faculty> faculty = s.createQuery("from Faculty").list();
		for (Faculty f : faculty) {
			System.out.println(f.getId() + " " + f.getName());
			for (Course c : f.getCourses()) {
				System.out.println(c.getId() + " " + c.getName());
			}
		}

		tx.commit();

	}
}
