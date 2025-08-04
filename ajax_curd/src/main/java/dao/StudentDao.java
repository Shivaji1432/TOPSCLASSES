package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class StudentDao {

	Connection cn = null;

	public StudentDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivwork", "root", "Pubg@1432");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Student> allStudents() {
		ArrayList<Student> al = new ArrayList<>();

		try {
			PreparedStatement ps = cn.prepareStatement("select * from userinfo");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setpass(rs.getString(4));

				al.add(st);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}

	public int addStudet(Student st) {
		int i = 0;

		try {
			// If your `id` column is AUTO_INCREMENT, then remove it from insert statement
			PreparedStatement ps = cn.prepareStatement("insert into userinfo(uname, email, pass) values(?,?,?)");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getpass());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public int deleteStudent(int uid) {
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("delete from userinfo where id=?");
			ps.setInt(1, uid);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public int editUser(Student st) {
		int i = 0;

		try {
			// Fixed SQL query: removed the extra closing parenthesis
			PreparedStatement ps = cn.prepareStatement("update userinfo set uname=?, email=?, pass=? where id=?");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getpass());
			ps.setInt(4, st.getId());
			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public Student userById(int uid) {
		Student st = null;
		try {
			PreparedStatement ps = cn.prepareStatement("select * from userinfo where id=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) { // use if instead of while as id is unique
				st = new Student();
				st.setId(rs.getInt(1)); // set ID too
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setpass(rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	public boolean isUsernameExist(String uname) {

		boolean b = false;
		try {
			PreparedStatement ps = cn.prepareStatement("select * from userinfo where uname=?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	public ArrayList<Student> searchStudent(String uname) {
		ArrayList<Student> al = new ArrayList();

		try {
			PreparedStatement ps = cn.prepareStatement("select * from userinfo where uname like ?");
			ps.setString(1, "%" + uname + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Student st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setpass(rs.getString(4));

				al.add(st);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return al;
	}
}
