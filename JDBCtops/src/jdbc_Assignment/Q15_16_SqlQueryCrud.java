package jdbc_Assignment;

import java.sql.*;

public class Q15_16_SqlQueryCrud {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/shivwork";
		String user = "root";
		String password = "Pubg@1432";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);

			// INSERT
			String insertQuery = "INSERT INTO emp (id, name, email, phone) VALUES (?, ?, ?, ?)";
			PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
			insertStmt.setInt(1, 0);
			insertStmt.setString(2, "John Doe");
			insertStmt.setString(3, "john@example.com");
			insertStmt.setString(4, "1234567890");
			insertStmt.executeUpdate();
			System.out.println("Record inserted.");

			// UPDATE
			String updateQuery = "UPDATE emp SET email = ? WHERE id = ?";
			PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
			updateStmt.setString(1, "john.doe@example.com");
			updateStmt.setInt(2, 5);
			updateStmt.executeUpdate();
			System.out.println("Record updated.");

			// SELECT with condition
			String selectQuery = "SELECT * FROM emp WHERE id = ?";
			PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
			selectStmt.setInt(1, 1);
			ResultSet rs = selectStmt.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Phone: " + rs.getString("phone"));
			}

			// DELETE
			String deleteQuery = "DELETE FROM emp WHERE id = ?";
			PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
			deleteStmt.setInt(1, 6);
			deleteStmt.executeUpdate();
			System.out.println("Record deleted.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
