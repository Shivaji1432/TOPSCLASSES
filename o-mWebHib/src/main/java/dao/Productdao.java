package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Category;
import model.Product;

public class Productdao {

	SessionFactory sf;

	public Productdao() {
		sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class).buildSessionFactory();
	}

	public List<Category> allCategories() {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		return s.createQuery("from Category").list();

	}

	public Category catById(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		return s.get(Category.class, id);
	}

	public int addProduct(Product p) {

		int i = 0;
		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(p);
			tx.commit();
			i = 1;

		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	public List<Product> allProducts() {

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		return s.createQuery("from Product").list();
	}

	public int deleteUser(int id) {
		int i = 0;
		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			Product p = s.get(Product.class, id);
			s.delete(p);
			i = 1;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public Product getUserById(int id) {
		Session s = sf.openSession();
		return s.get(Product.class, id);
	}

}
