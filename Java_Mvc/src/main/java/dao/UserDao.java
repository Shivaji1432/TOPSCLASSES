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
    private Connection con;

    public UserDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivwork", "root", "Pubg@1432");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



	public int addUser(User user) {
		// TODO Auto-generated method stub
		 int result = 0;
	        String sql = "INSERT INTO registration (uname, email, pass) VALUES (?, ?, ?)";

	        try (PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setString(1, user.getUname());
	            ps.setString(2, user.getEmail());
	            ps.setString(3, user.getPass());

	            result = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		return result;
	}



	public List<User> getalluser() {
		List<User> users=new ArrayList<User>();
		try {
			PreparedStatement ps =con.prepareStatement("select * from registration");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getInt(1));;
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
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
			PreparedStatement ps =con.prepareStatement("delete from registration where id=?");
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
			PreparedStatement ps = 
					con.prepareStatement("select * from registration where id=?");
			
			ps.setInt(1, id);
			
			ResultSet rs  =ps.executeQuery();
			
			if(rs.next())
			{
				user.setId(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPass(rs.getString(4));
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}




	public int updateuser(User user) {
		int i = 0;
		try {
			PreparedStatement ps =
					con.prepareStatement("update registration set uname=?,email=?,pass=? where id = ?");
			ps.setString(1, user.getUname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPass());
			ps.setInt(4 , user.getId());
			
			i = ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public boolean emailexist(String email) {
		boolean b = false;
		try {
			PreparedStatement ps = con.prepareStatement("select * from registration where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	public User isemailExist(User u) {
		User user = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from registration where email=? and pass=?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPass());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUname(rs.getString("uname"));
				user.setEmail(rs.getString("email"));
				user.setPass(rs.getString("pass"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
