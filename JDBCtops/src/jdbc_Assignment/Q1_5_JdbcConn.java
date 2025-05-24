package jdbc_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Q1_5_JdbcConn {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/shivwork";
		String user="root";
		String pass="Pubg@1432";
		Connection conn=DriverManager.getConnection(url,user,pass);
	    System.out.println("connection established");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
