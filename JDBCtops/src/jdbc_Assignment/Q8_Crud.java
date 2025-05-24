package jdbc_Assignment;

import java.sql.*;
import java.util.Scanner;

public class Q8_Crud {
	static final String URL = "jdbc:mysql://localhost:3306/shivwork";
	static final String USER = "root";
	static final String phone = "Pubg@1432";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(URL, USER, phone);
				Scanner scanner = new Scanner(System.in)) {

			Class.forName("com.mysql.cj.jdbc.Driver");

			while (true) {
				System.out.println("CRUD Operations");
				System.out.println("1. Insert Record");
				System.out.println("2. Display All Records");
				System.out.println("3. Update Record");
				System.out.println("4. Delete Record");
				System.out.println("5. Exit");
				System.out.print("Enter choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					insertRecord(conn, scanner);
					break;
				case 2:
					displayRecords(conn);
					break;
				case 3:
					updateRecord(conn, scanner);
					break;
				case 4:
					deleteRecord(conn, scanner);
					break;
				case 5:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice!");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void insertRecord(Connection conn, Scanner scanner) throws SQLException {
		System.out.print("Enter username: ");
		String uname = scanner.nextLine();
		System.out.print("Enter email: ");
		String email = scanner.nextLine();
		System.out.print("Enter phone: ");
		String phone = scanner.nextLine();

		String sql = "INSERT INTO emp  VALUES (0,?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, uname);
			ps.setString(2, email);
			ps.setString(3, phone);
			int rows = ps.executeUpdate();
			System.out.println(rows + " record(s) inserted.");
		}
	}

	private static void displayRecords(Connection conn) throws SQLException {
		try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM emp")) {
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Username: " + rs.getString("name") + ", Email: "
						+ rs.getString("email") + ", phone: " + rs.getString("phone"));
			}
		}
	}

	private static void updateRecord(Connection conn, Scanner scanner) throws SQLException {
		System.out.print("Enter ID to update: ");
		int id = scanner.nextInt();
		scanner.nextLine(); 

		System.out.print("Enter new username: ");
		String uname = scanner.nextLine();
		System.out.print("Enter new email: ");
		String email = scanner.nextLine();
		System.out.print("Enter new phone: ");
		String phone = scanner.nextLine();

		String query = "UPDATE emp SET name = ?, email = ?, phone = ? WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, uname);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setInt(4, id);
			int rows = ps.executeUpdate();
			System.out.println(rows + " record's updated.");
		}
	}

	private static void deleteRecord(Connection conn, Scanner scanner) throws SQLException {
		System.out.print("Enter ID to delete: ");
		int id = scanner.nextInt();

		String query = "DELETE FROM emp WHERE id = ?";
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			System.out.println(rows + " record's deleted.");
		}
	}
}
