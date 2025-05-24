package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Books {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter choice : ");
		int choice = sc.nextInt();		
		switch (choice) {
		case 1: {
			insert(sc);
			break;
		}
		case 2: {
			update(sc);
			break;
		}
		case 3: {
			delete(sc);
			break;
		}
		case 4: {
			issue(sc);
			break;
		}
		default :{
			AllRecords(sc);
			break;
		}
			
		}
	}

	static void AllRecords(Scanner sc) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bookstore";
			String user="root";
			String pass="Pubg@1432";
			Connection conn=DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=conn.prepareStatement("select * from books;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String book=rs.getString("book_name");
				int price=rs.getInt("book_price");
				int quantity=rs.getInt("book_quantity");
				System.out.println(id+" "+book+" "+price+" "+quantity+" ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	static void insert(Scanner sc) {
		System.out.println("enter book name : ");
		String Bookname=sc.next();
		System.out.println("enter price : ");
		int price=sc.nextInt();
		System.out.println("enter quantity : ");
		int quantity=sc.nextInt();
		if(isexist(Bookname)) {
			System.out.println("book is already exists !! ");
		}else {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bookstore";
			String user="root";
			String pass="Pubg@1432";
			Connection conn=DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=conn.prepareStatement("insert into books values(0,?,?,?);");
			ps.setString(1, Bookname);
			ps.setInt(2, price);
			ps.setInt(3, quantity);
			int i=ps.executeUpdate();
			if(i>0) {
			System.out.println("1 row affected.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		}

	}

	private static boolean isexist(String name) {
		
		boolean b= false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bookstore";
			String user="root";
			String pass="Pubg@1432";
			Connection conn=DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=conn.prepareStatement("select * from books where book_name=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				b=true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	static void update(Scanner sc) {
		System.out.println("enter id : ");
		int id=sc.nextInt();
		System.out.println("enter book name : ");
		String Bookname=sc.next();
		System.out.println("enter price : ");
		int price=sc.nextInt();
		System.out.println("enter quantity : ");
		int quantity=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bookstore";
			String user="root";
			String pass="Pubg@1432";
			Connection conn=DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=conn.prepareStatement("update books set book_name=?,book_price=?,book_quantity=? where id=?;");
			ps.setString(1, Bookname);
			ps.setInt(2, price);
			ps.setInt(3, quantity);
			ps.setInt(4, id);
			int i=ps.executeUpdate();
			if(i>0) {
			System.out.println("1 row affected.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	static void delete(Scanner sc) {
	    System.out.println("enter bookname to delete: ");
	    String Bookname = sc.next();
	    if(isexist(Bookname)) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/bookstore";
	        String user = "root";
	        String pass = "Pubg@1432";
	        Connection conn = DriverManager.getConnection(url, user, pass);
	        PreparedStatement ps = conn.prepareStatement("DELETE FROM books WHERE book_name = ?");
	        ps.setString(1, Bookname);
	        int i = ps.executeUpdate();
	        if(i>0) {
	        	System.out.println("book deleted ");
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } 
	    }
	    else {
	    	System.out.println("book not found : ");
	    }
	
	}
	static void issue(Scanner sc) {
	    System.out.println("Enter book ID to issue: ");
	    int id = sc.nextInt();
	    System.out.println("enter quantity : ");
		int quantity=sc.nextInt();
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/bookstore";
	        String user = "root";
	        String pass = "Pubg@1432";
	        Connection conn = DriverManager.getConnection(url, user, pass);
	        PreparedStatement ps = conn.prepareStatement(
	            "UPDATE books SET book_quantity = book_quantity - ?  WHERE id = ? AND book_quantity > 0"
	        );
	        ps.setInt(1, quantity);
	        ps.setInt(2, id);
	        int i = ps.executeUpdate();
	        if (i > 0) {
	            System.out.println("Book issued successfully.");
	        } 
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	}
