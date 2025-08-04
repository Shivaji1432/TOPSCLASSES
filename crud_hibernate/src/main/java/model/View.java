package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class View {

	public static void main(String[] args) {

		Student st = new Student();
		st.setId(1);
		st.setName("Sitesh");
		st.setEmail("sit@gmail.com");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		// Student student = s.get(Student.class, 1);
		List<Student> st1 = s.createQuery("from Student", Student.class).list();

		for (Student student : st1) {
			System.out.println(student.getId() + " " + student.email + " " + student.getName());
		}

		Transaction tx = s.beginTransaction();
		tx.commit();
	}
}
