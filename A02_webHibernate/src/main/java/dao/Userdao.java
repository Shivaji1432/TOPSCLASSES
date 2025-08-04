package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;

public class Userdao {
	SessionFactory sf = null;

	public Userdao() {
		sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

	}

	public int addUser(User u) {
		int i = 0;
		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(u);
			tx.commit();
			i = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<User> viewUser() {

		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			return s.createQuery("from User", User.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int deleteUser(int id) {
		int i = 0;
		try {
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			User u = session.load(User.class, id);
			session.delete(u);
			i = 1;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public User getUserById(int id) {

		try {
			Session session = sf.openSession();
			return session.load(User.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
