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
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shivwork","root","Pubg@1432");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
	public int adduser(User user) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO userinfo(uname, email, pass) VALUES (?, ?, ?)");
			ps.setString(1, user.getUname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPass());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


	public boolean isEmailExist(String email) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from userinfo where email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}


	public List<User> viewusers() {
		List<User> user=new ArrayList<User>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from userinfo");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
				user.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	public int deleteUser(int id) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from userinfo where id=?");
			ps.setInt(1, id);
			 i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public User userById(int id) {
		User user = new User();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM userinfo WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPass(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public int updateuser(User user) {
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement(
				"UPDATE userinfo SET uname=?, email=?, pass=? WHERE id=?"
			);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPass());
			ps.setInt(4, user.getId());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}


	public User isUserExist(User user) {
		User u=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from userinfo where email=? and pass=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPass());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
			    u.setPass(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


}
