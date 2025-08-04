package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("kiran");
		emp.setEmail("kir@gmail.com");
		emp.setSalary(10000);

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session s = sf.openSession();
		Employee employee = s.get(Employee.class, 3);
		s.delete(employee);
		Transaction tx = s.beginTransaction();
		tx.commit();
	}
}
