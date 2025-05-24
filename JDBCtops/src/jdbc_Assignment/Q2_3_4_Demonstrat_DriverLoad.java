package jdbc_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Q2_3_4_Demonstrat_DriverLoad {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Q3 :we can check class.forname() to verify driver 
		//currently i am using mysql connector driver as you can see.
		//or you can check referenced libraraies to check driver.
		System.out.println("Driver loaded!!!");//Q2 driver loaded
		String url="jdbc:mysql://localhost:3306/shivwork";
		String user="root";
		String pass="Pubg@1432";
		Connection conn=DriverManager.getConnection(url,user,pass);
	    System.out.println("connection established!!!");//Q2 connection done
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
//Q4 curently we have type-four driver which is offically used and recomended
//by oracle which is mysql_connector and it is the best among all four drivers.
