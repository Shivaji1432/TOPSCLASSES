package assesment;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Swing_Gui_CURD {

	private JFrame frame;
	private JTextField idField;
	private JTextField fname;
	private JTextField lname;
	private JTextField email;
	private JTextField Phone;
	private JTable table;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Swing_Gui_CURD window = new Swing_Gui_CURD();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Swing_Gui_CURD() {
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
			PreparedStatement ps = con.prepareStatement("SELECT * FROM studentinfo;");
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

		JLabel lblNewLabel = new JLabel("STUDENT INFO");
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

		idField = new JTextField();
		idField.setBounds(226, 143, 147, 37);
		frame.getContentPane().add(idField);
		idField.setColumns(10);

		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(226, 190, 147, 37);
		frame.getContentPane().add(fname);

		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(226, 237, 147, 37);
		frame.getContentPane().add(lname);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(226, 284, 147, 37);
		frame.getContentPane().add(email);

		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblMobile.setBounds(74, 339, 123, 37);
		frame.getContentPane().add(lblMobile);

		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBounds(226, 344, 147, 37);
		frame.getContentPane().add(Phone);

		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(505, 140, 630, 350);
		frame.getContentPane().add(scrollPane);

		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement ps = con.prepareStatement("INSERT INTO studentinfo VALUES (0, ?, ?, ?, ?)");
					ps.setString(1, fname.getText());
					ps.setString(2, lname.getText());
					ps.setString(3, email.getText());
					ps.setString(4, Phone.getText());
					int i = ps.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(frame, "1 row affected");
						idField.setText("");
						fname.setText("");
						lname.setText("");
						email.setText("");
						Phone.setText("");
						load();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(74, 402, 123, 31);
		frame.getContentPane().add(btnNewButton);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnUpdate.setBounds(74, 459, 123, 31);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(e -> {
			try {
				PreparedStatement ps = con.prepareStatement("UPDATE studentinfo SET fname=?, lname=?, email=?, phone=? WHERE id=?");
				ps.setString(1, fname.getText());
				ps.setString(2, lname.getText());
				ps.setString(3, email.getText());
				ps.setString(4, Phone.getText());
				ps.setInt(5, Integer.parseInt(idField.getText()));
				int i = ps.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(frame, "Update successful!");
					load();
				} else {
					JOptionPane.showMessageDialog(frame, "Update failed. Check if the ID exists.");
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(frame, "Update Error: " + ex.getMessage());
			}
		});

		JButton btnSelect = new JButton("SEARCH");
		btnSelect.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnSelect.setBounds(226, 402, 123, 31);
		frame.getContentPane().add(btnSelect);
		btnSelect.addActionListener(e -> {
			String id = idField.getText().trim();
			if (!id.isEmpty()) {
				try {
					String query = "SELECT * FROM studentinfo WHERE id = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(id));
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						fname.setText(rs.getString("fname"));
						lname.setText(rs.getString("lname"));
						email.setText(rs.getString("email"));
						Phone.setText(rs.getString("phone"));
						JOptionPane.showMessageDialog(frame, "Data loaded successfully!");
					} else {
						JOptionPane.showMessageDialog(frame, "No record found.");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frame, "Select Error: " + ex.getMessage());
				}
			} else {
				try {
					String query = "SELECT * FROM studentinfo";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					idField.setText("");
					fname.setText("");
					lname.setText("");
					email.setText("");
					Phone.setText("");
					load();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frame, "Table Load Error: " + ex.getMessage());
				}
			}
		});

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnDelete.setBounds(226, 459, 123, 31);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(e -> {
			try {
				String query = "DELETE FROM studentinfo WHERE id=?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, Integer.parseInt(idField.getText()));
				pst.executeUpdate();
				JOptionPane.showMessageDialog(frame, "Deleted Successfully");
				load();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(frame, "Delete Error: " + ex.getMessage());
			}
		});
	}
}
