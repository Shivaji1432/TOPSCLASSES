package jdbc_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirdtJdbc {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver load....");
		String url="jdbc:mysql://localhost:3306/javafeb";
		String user="root";
		String pass="Pubg@1432";
		Connection conn=DriverManager.getConnection(url,user,pass);
		System.out.println("established conn.....");
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next()) {
			int id =rs.getInt("id");
			String name =rs.getString("name");
			String email =rs.getString("email");
			System.out.println(id +" "+name+" "+email);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
