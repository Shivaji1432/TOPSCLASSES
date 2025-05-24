package jdbc_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q6_Statement {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/shivwork";
		String user="root";
		String pass="Pubg@1432";
		Connection conn=DriverManager.getConnection(url,user,pass);
	    System.out.println("connection established");
	    Statement st=conn.createStatement();
	    ResultSet rs=st.executeQuery("select * from student");
	    while(rs.next()) {
	    	int id = rs.getInt("st_id");
	    	String name = rs.getString("st_name");
			System.out.println(id+" "+name);
	    }ResultSet r = st.executeQuery("SELECT * FROM student WHERE st_id = 10");
	    if (!r.next()) {
	        int i = st.executeUpdate("INSERT INTO student VALUES (10, 'shivjit', 's@gmail.com', 85450313024)");
	        if (i > 0) {
	            System.out.println("Row added.");
	        }
	    } else {
	        System.out.println("Student with ID 10 already exists.");
	    }

	    int j=st.executeUpdate("update student set st_name='shivangi' where st_id=2");
	    if(j>0) {
	    	System.out.println("update done");
	    }
	    int k=st.executeUpdate("DELETE FROM student WHERE st_id IN (8, 9, 10)");
	    if(k>0) {
	    	System.out.println("deleted");
	    }
	    
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
