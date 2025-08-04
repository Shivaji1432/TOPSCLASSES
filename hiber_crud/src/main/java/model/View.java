package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class View {
	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("kiran");
		emp.setEmail("kir@gmail.com");
		emp.setSalary(10000);

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session s = sf.openSession();
		// Employee employee = s.get(Employee.class, 1);
		List<Employee> e = s.createQuery("from Employee", Employee.class).list();
		for (Employee employee : e) {
			System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getEmail() + " "
					+ employee.getSalary());

		}
		Transaction tx = s.beginTransaction();
		tx.commit();
	}
}
