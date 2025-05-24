package jdbc_Assignment;
import java.sql.*;

public class Q9_DisplayRecord {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/shivwork"; 
        String User = "root"; 
        String Password = "Pubg@1432";

        String query = "SELECT * FROM emp"; 
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, User, Password);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

              System.out.println(id+" "+name+" "+email+" "+phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
