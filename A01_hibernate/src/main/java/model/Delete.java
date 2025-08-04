package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
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
		Student std = s.load(Student.class, 1);
		s.delete(std);
		Transaction tx = s.beginTransaction();

		tx.commit();
	}
}
