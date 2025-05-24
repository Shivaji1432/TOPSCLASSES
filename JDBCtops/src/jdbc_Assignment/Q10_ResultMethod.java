package jdbc_Assignment;

import java.sql.*;

public class Q10_ResultMethod {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/shivwork";
        String User = "root";
        String Password = "Pubg@1432";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, User, Password);

            
            Statement st = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = st.executeQuery("SELECT * FROM emp");

            System.out.println("Forward....");
            while (rs.next()) {
                displayRow(rs);
            }

            System.out.println("\nBackward....");
            while (rs.previous()) {
                displayRow(rs);
            }

            System.out.println("\n First Row....");
            if (rs.first()) {
                displayRow(rs);
            }

            System.out.println("\nLast Row....");
            if (rs.last()) {
                displayRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void displayRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");

        System.out.println(id+" "+name+" "+email+" "+phone);
     
    }
}
