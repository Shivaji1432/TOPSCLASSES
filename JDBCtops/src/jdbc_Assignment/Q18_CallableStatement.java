package jdbc_Assignment;

import java.sql.*;

public class Q18_CallableStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shivwork"; 
        String user = "root"; 
        String password = "Pubg@1432"; 

        Connection conn = null;
        CallableStatement cs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            // Prepare call to stored procedure
            cs = conn.prepareCall("{CALL GetEmployeeFullName(?, ?)}");

            // Set IN parameter (employee ID)
            cs.setInt(1, 1); // example: employee ID = 1

            // Register OUT parameter (full name)
            cs.registerOutParameter(2, Types.VARCHAR);

            // Execute stored procedure
            cs.execute();

            // Retrieve OUT parameter value
            String fullName = cs.getString(2);

            System.out.println("Employee Full Name: " + fullName);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cs != null) cs.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
