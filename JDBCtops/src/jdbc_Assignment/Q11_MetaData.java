package jdbc_Assignment;

import java.sql.*;

public class Q11_MetaData {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/shivwork";
        String User = "root";
        String Password = "Pubg@1432";

        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
         
            Connection conn = DriverManager.getConnection(URL, User, Password);

            DatabaseMetaData metaData = conn.getMetaData();

            System.out.println("Database Metadata......");
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());
            System.out.println("Username: " + metaData.getUserName());
            System.out.println("URL: " + metaData.getURL());
            System.out.println("Read-only: " + metaData.isReadOnly());
            System.out.println();

            System.out.println("Tables in 'shivwork' Database...");
            ResultSet tables = metaData.getTables(null, null, "%", new String[] { "TABLE" });

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                String tableType = tables.getString("TABLE_TYPE");
                System.out.println("Table: " + tableName + " (Type: " + tableType + ")");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
