package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Users;

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
	public int adduser(Users users) {
		int i = 0;
		try {

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO users(fname, lname, email, phone, password) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, users.getFname());
			ps.setString(2, users.getLname());
			ps.setString(3, users.getEmail());
			ps.setString(4, users.getPhone());
			ps.setString(5, users.getPass());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public List<Users> getUser() {
		List<Users> users=new ArrayList<Users>();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from users");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Users u=new Users();
				u.setId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setPass(rs.getString(6));
				users.add(u);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	public int deleteuser(int id) {
		int i=0;

		try {
			PreparedStatement ps=con.prepareStatement("delete from users where id=?");
			ps.setInt(1, id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public Users getuserbyid(int id) {
		Users u=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from users where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u= new Users();
				u.setId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setPass(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	public int updateUser(Users users) {
		int i = 0;
	    try {
	        PreparedStatement ps = con.prepareStatement(
	            "UPDATE users SET fname=?, lname=?, email=?, phone=?, password=? WHERE id=?"
	        );

	        ps.setString(1, users.getFname());
	        ps.setString(2, users.getLname());
	        ps.setString(3, users.getEmail());
	        ps.setString(4, users.getPhone());
	        ps.setString(5, users.getPass());  
	        ps.setInt(6, users.getId());

	        i = ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	public boolean isEmailExist(String email) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from users where email=?;");
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

	public Users isUserExist(Users u) {
		Users users=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from users where email=? and password=? ");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPass());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				users=new Users();
				users.setFname(rs.getString(1));
				users.setLname(rs.getString(2));
				users.setEmail(rs.getString(3));
				users.setPhone(rs.getString(4));
				users.setPass(rs.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}


}
