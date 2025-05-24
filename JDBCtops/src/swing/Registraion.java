package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Registraion {

	private static JFrame frame;
	private static JTextField Name;
	private static JTextField Email;
	private static JTextField Phone;
	private static JTextField ID;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registraion window = new Registraion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registraion() {
		initialize();
		connection();
		load();
		}

	static Connection con=null;
	private static void connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shivwork","root","Pubg@1432");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void load() {
		try {
			PreparedStatement ps = con.prepareStatement("select * from emp;");
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 979, 727);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(354, 44, 203, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(71, 114, 103, 37);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(71, 180, 103, 37);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(71, 247, 103, 37);
		frame.getContentPane().add(lblPhone);
		
		Name = new JTextField();
		Name.setBounds(215, 123, 160, 25);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(215, 180, 160, 25);
		frame.getContentPane().add(Email);
		
		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBounds(215, 248, 160, 25);
		frame.getContentPane().add(Phone);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String idText = ID.getText().trim();
				try {
					PreparedStatement ps;
					if(idText.isEmpty()){
					ps = con.prepareStatement("INSERT INTO emp VALUES (?, ?, ?, ?)");
					ps.setInt(1, 0); 
					ps.setString(2, Name.getText());
					ps.setString(3, Email.getText());
					ps.setString(4, Phone.getText());
					}
					else {
						 ps = con.prepareStatement("UPDATE emp SET name=?, email=?, phone=? WHERE id=?");
			                ps.setString(1, Name.getText());
			                ps.setString(2, Email.getText());
			                ps.setString(3, Phone.getText());
			                ps.setString(4, ID.getText());
					}
					int i=ps.executeUpdate();
					if(i>0) {
						JOptionPane.showMessageDialog(frame, "1  row affected");
					Name.setText("");
				    Email.setText("");
					Phone.setText("");
					ID.setText("");
					load();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(89, 341, 128, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement ps=con.prepareStatement("select * from emp where id=?;");
					ps.setString(1, ID.getText());
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						Name.setText(rs.getString("name"));
						Email.setText(rs.getString("email"));
						Phone.setText(rs.getString("phone"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setBounds(89, 468, 128, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement ps = con.prepareStatement("delete from emp where id=?;");
					ps.setString(1, ID.getText()); 
					

					int i=ps.executeUpdate();
					if(i>0) {
						JOptionPane.showMessageDialog(frame, "1  row affected");
					ID.setText("");
					load();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(89, 532, 128, 37);
		frame.getContentPane().add(btnNewButton_2);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(72, 420, 160, 25);
		frame.getContentPane().add(ID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 309, 603, 344);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblid.setBounds(30, 411, 36, 37);
		frame.getContentPane().add(lblid);
	}
}
