package jdbc_Assignment;

import java.sql.*;

public class Q13_14_ResultsetMeta {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shivwork";
        String user = "root";
        String password = "Pubg@1432";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM emp";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            System.out.println("Total Columns: " + columnCount);
            System.out.println("Column Details:");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                String columnType = rsmd.getColumnTypeName(i);
                System.out.println("- " + columnName + " (" + columnType + ")");
            }

     
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
