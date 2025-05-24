package jdbc_Assignment;

import java.sql.*;

public class Q12_MetadataTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shivwork";
        String user = "root";
        String password = "Pubg@1432";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            DatabaseMetaData metaData = conn.getMetaData();

            System.out.println("Database Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Version: " + metaData.getDatabaseProductVersion());

            System.out.println("\nTables:");
            ResultSet tables = metaData.getTables(null, null, "%", new String[] { "TABLE" });
            while (tables.next()) {
                System.out.println("- " + tables.getString("TABLE_NAME"));
            }

            System.out.println("\nSupported SQL Features:");
            System.out.println("Stored Procedures Supported: " + metaData.supportsStoredProcedures());
            System.out.println("Batch Updates Supported: " + metaData.supportsBatchUpdates());
            System.out.println("Outer Joins Supported: " + metaData.supportsOuterJoins());
            System.out.println("Select for Update Supported: " + metaData.supportsSelectForUpdate());
            System.out.println("Transactions Supported: " + metaData.supportsTransactions());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
