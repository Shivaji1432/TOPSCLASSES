package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddEmployee {
	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setId(3);
		emp.setName("arun");
		emp.setEmail("ar@gmail.com");
		emp.setSalary(10000);

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session s = sf.openSession();
		s.saveOrUpdate(emp);
		Transaction tx = s.beginTransaction();
		tx.commit();
	}
}
