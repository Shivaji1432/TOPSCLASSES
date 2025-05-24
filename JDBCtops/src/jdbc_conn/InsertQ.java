package jdbc_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQ {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/javafeb";
		String user="root";
		String pass="Pubg@1432";
		Connection conn = DriverManager.getConnection(url,user,pass);
		System.out.println("connection established");
		Statement st=conn.createStatement();
		int insert=st.executeUpdate("insert into student values(0,'sitesh','surat')");
		System.out.println("1 row inserted");}
	   catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	}
	}
