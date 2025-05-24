package jdbc_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Q7_Prepared {
public static void main(String[] args) {
	try {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your id : ");
		int id=sc.nextInt();
		System.out.println("enter your name : ");
		String name=sc.next();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/shivwork";
		String user="root";
		String pass="Pubg@1432";
		Connection conn=DriverManager.getConnection(url,user,pass);
	    System.out.println("connection established");
	    PreparedStatement ps=conn.prepareStatement("update employee set name=? where id =?;");
	    ps.setString(1, name);
	    ps.setInt(2, id);
	    ps.executeUpdate();
	    System.out.println("1 row updated !!!");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
