package jdbc_Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Q17_Swing {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q17_Swing window = new Q17_Swing();
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
	public Q17_Swing() {
		initialize();
		connection();
		load();
	}

	static Connection con = null;

	private void connection() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivwork", "root", "Pubg@1432");
	        System.out.println("Database connected successfully");
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}


	private void load() {
	    System.out.println("Loading data to table...");
	    try {
	        PreparedStatement ps = con.prepareStatement("select * from employee;");
	        ResultSet rs = ps.executeQuery();
	        table.setModel(DbUtils.resultSetToTableModel(rs));
	    } catch (SQLException e1) {
	        e1.printStackTrace();
	    }
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1227, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("employee INFO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(285, 55, 186, 37);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId.setBounds(74, 143, 186, 37);
		frame.getContentPane().add(lblId);

		JLabel lblFname = new JLabel("FNAME");
		lblFname.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblFname.setBounds(74, 190, 186, 37);
		frame.getContentPane().add(lblFname);

		JLabel lblLname = new JLabel("LNAME");
		lblLname.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblLname.setBounds(74, 237, 186, 37);
		frame.getContentPane().add(lblLname);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblEmail.setBounds(74, 292, 186, 37);
		frame.getContentPane().add(lblEmail);

		textField = new JTextField();
		textField.setBounds(226, 143, 147, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(226, 190, 147, 37);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(226, 237, 147, 37);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(226, 284, 147, 37);
		frame.getContentPane().add(textField_3);

		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(505, 140, 630, 350);
		frame.getContentPane().add(scrollPane);

		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String idText = textField.getText().trim();
					try {
						PreparedStatement ps;
						if(idText.isEmpty()){
						ps = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?)");
						ps.setInt(1, 0); 
						ps.setString(2, textField_1.getText());
						ps.setString(3, textField_2.getText());
						ps.setString(4, textField_3.getText());
						}
						else {
							 ps = con.prepareStatement("UPDATE employee SET fname=?, lname=?, email=? WHERE id=?");
				                ps.setString(1, textField_1.getText());
				                ps.setString(2, textField_2.getText());
				                ps.setString(3, textField_3.getText());
				                ps.setString(4, textField.getText());
						}
						int i=ps.executeUpdate();
						if(i>0) {
							JOptionPane.showMessageDialog(frame, "1  row affected");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
						load();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(74, 375, 123, 31);
		frame.getContentPane().add(btnNewButton);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement ps=con.prepareStatement("select * from employee where id=?;");
					ps.setString(1, textField.getText());
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnUpdate.setBounds(233, 375, 123, 31);
		frame.getContentPane().add(btnUpdate);

		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText().trim();
				if (!id.isEmpty()) {
					// If ID is provided, fetch and show in text fields
					try {
						String query = "SELECT * FROM employee WHERE id = ?";
						PreparedStatement pst = con.prepareStatement(query);
						pst.setInt(1, Integer.parseInt(id));
						ResultSet rs = pst.executeQuery();
						if (rs.next()) {
							textField_1.setText(rs.getString("fname"));
							textField_2.setText(rs.getString("lname"));
							textField_3.setText(rs.getString("email"));
							JOptionPane.showMessageDialog(frame, "Data loaded successfully!");
						} else {
							JOptionPane.showMessageDialog(frame, "No record found.");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(frame, "Select Error: " + ex.getMessage());
					}
				} else {
					// If no ID, show all data in table
					try {
						String query = "SELECT * FROM employee";
						PreparedStatement pst = con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						load();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(frame, "Table Load Error: " + ex.getMessage());
					}

				}
			}
		});
		btnSelect.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnSelect.setBounds(74, 447, 123, 31);
		frame.getContentPane().add(btnSelect);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "DELETE FROM employee WHERE id=?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(textField.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(frame, "Deleted Successfully");
					load();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frame, "Delete Error: " + ex.getMessage());
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnDelete.setBounds(226, 447, 123, 31);
		frame.getContentPane().add(btnDelete);

	}
}
