package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {
	Connection con;

	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivwork", "root", "Pubg@1432");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addUser(User user) {
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into register(uname,email,pass) values(?,?,?)");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPass());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<User> viewUser() {
		List<User> user = new ArrayList<User>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM register");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User(); // Create a new User for each row
				u.setId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
				user.add(u); // Add to list
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public int deleteUser(int id) {
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from register where id=?");
			ps.setInt(1, id);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public User editUser(int id) {
		User u = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from register where id=? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	public int updateUser(User user) {
		int i = 0;
        try {
			PreparedStatement ps=con.prepareStatement("update register set uname=?,email=?,pass=?  where id=?");
		    ps.setString(1, user.getUserName());
		    ps.setString(2, user.getEmail());
		    ps.setString(3, user.getPass());
		    ps.setInt(4, user.getId());
		    i=ps.executeUpdate();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public User isUserExist(User user) {
		// TODO Auto-generated method stub
		return user;
	}

}
