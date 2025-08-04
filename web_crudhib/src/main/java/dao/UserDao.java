package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;

public class UserDao {
	SessionFactory sf = null;

	public UserDao() {
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

	public int deleteUser(int id) {
		int i = 0;
		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			User u = s.load(User.class, id);
			s.delete(u);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public User getUserById(int id) {
		Session s = sf.openSession();
		return s.get(User.class, id);

	}

	public List<User> allUsers() {

		List<User> list;
		Session s = sf.openSession();

		return s.createQuery("from User").list();
	}
}
