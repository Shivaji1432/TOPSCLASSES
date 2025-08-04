package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class View {
	public static void main(String[] args) {
		Student st = new Student();
		st.setId(2);
		st.setName("Ronak");
		st.setEmail("Ronak@yahoo.com");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		// Student std = s.load(Student.class, 2);
		List<Student> std = s.createQuery("from Student").list();
		for (Student st1 : std) {
			System.out.println(st1.getId() + " " + st1.getName() + " " + st1.getEmail());
		}
		Transaction tx = s.beginTransaction();

		tx.commit();
	}
}
