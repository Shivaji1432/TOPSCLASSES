package swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstSwing {

    private JFrame frmJavaApplication;
    private JTextField name;
    private JTextField phone;
    private JTextField email;
    private JTable table;
    private DefaultTableModel model;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FirstSwing window = new FirstSwing();
                    window.frmJavaApplication.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FirstSwing() {
        initialize();
    }

    private void initialize() {
        frmJavaApplication = new JFrame();
        frmJavaApplication.setTitle("JAVA APPLICATION");
        frmJavaApplication.setBounds(100, 100, 1027, 700);
        frmJavaApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("REGISTRATION FORM");
        lblNewLabel.setBounds(535, 34, 267, 30);
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));

        JLabel lblNewLabel_1 = new JLabel("NAME");
        lblNewLabel_1.setBounds(111, 112, 82, 23);
        lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 16));

        JLabel lblNewLabel_1_1 = new JLabel("EMAIL");
        lblNewLabel_1_1.setBounds(111, 157, 82, 23);
        lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 16));

        JLabel lblNewLabel_1_2 = new JLabel("PHONE");
        lblNewLabel_1_2.setBounds(111, 202, 82, 23);
        lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 16));

        name = new JTextField();
        name.setBounds(193, 113, 153, 29);
        name.setFont(new Font("Arial Black", Font.BOLD, 16));
        name.setColumns(10);

        phone = new JTextField();
        phone.setBounds(193, 203, 153, 29);
        phone.setFont(new Font("Arial Black", Font.BOLD, 16));
        phone.setColumns(10);

        email = new JTextField();
        email.setBounds(193, 158, 153, 29);
        email.setFont(new Font("Arial Black", Font.BOLD, 16));
        email.setColumns(10);

        JButton btnRead = new JButton("READ");
        btnRead.setBounds(245, 271, 120, 35);
        btnRead.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadData();  // Load data when 'READ' button is clicked
            }
        });
        btnRead.setForeground(Color.BLACK);
        btnRead.setFont(new Font("Arial Black", Font.BOLD, 18));

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(111, 317, 120, 35);
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) model.getValueAt(selectedRow, 0);
                    String updatedName = name.getText();
                    String updatedEmail = email.getText();
                    String updatedPhone = phone.getText();

                    try {
                        // Update data in database
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/shivwork";
                        String user = "root";
                        String pass = "Pubg@1432";
                        Connection conn = DriverManager.getConnection(url, user, pass);
                        String query = "UPDATE emp SET name = ?, email = ?, phone = ? WHERE id = ?";
                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setString(1, updatedName);
                        ps.setString(2, updatedEmail);
                        ps.setString(3, updatedPhone);
                        ps.setInt(4, id);

                        int i = ps.executeUpdate();
                        if (i > 0) {
                            JOptionPane.showMessageDialog(frmJavaApplication, "Record updated successfully!");
                            loadData(); // Reload data after update
                        } else {
                            JOptionPane.showMessageDialog(frmJavaApplication, "Update failed.");
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frmJavaApplication, "Please select a row to update.");
                }
            }
        });

        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBounds(245, 317, 120, 35);
        btnDelete.setForeground(Color.BLACK);
        btnDelete.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) model.getValueAt(selectedRow, 0);

                    try {
                        // Delete record from database
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/shivwork";
                        String user = "root";
                        String pass = "Pubg@1432";
                        Connection conn = DriverManager.getConnection(url, user, pass);
                        String query = "DELETE FROM emp WHERE id = ?";
                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setInt(1, id);

                        int i = ps.executeUpdate();
                        if (i > 0) {
                            JOptionPane.showMessageDialog(frmJavaApplication, "Record deleted successfully!");
                            loadData(); // Reload data after deletion
                        } else {
                            JOptionPane.showMessageDialog(frmJavaApplication, "Delete failed.");
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frmJavaApplication, "Please select a row to delete.");
                }
            }
        });

        JButton btnCreate = new JButton("CREATE");
        btnCreate.setBounds(111, 271, 120, 35);
        btnCreate.setForeground(Color.BLACK);
        btnCreate.setFont(new Font("Arial Black", Font.BOLD, 18));
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Insert data into the database
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/shivwork";
                    String user = "root";
                    String pass = "Pubg@1432";
                    Connection conn = DriverManager.getConnection(url, user, pass);
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO emp (name, email, phone) VALUES (?, ?, ?)");
                    ps.setString(1, name.getText());
                    ps.setString(2, email.getText());
                    ps.setString(3, phone.getText());

                    int i = ps.executeUpdate();

                    if (i > 0) {
                        JOptionPane.showMessageDialog(frmJavaApplication, "Record inserted successfully!");
                        loadData();  // Reload data after insertion
                    } else {
                        JOptionPane.showMessageDialog(frmJavaApplication, "Insertion failed.");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // JTable Setup
        String[] columnNames = {"ID", "Name", "Email", "Phone"};
        model = new DefaultTableModel(columnNames, 0);
        frmJavaApplication.getContentPane().setLayout(null);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(400, 300, 605, 316);
        frmJavaApplication.getContentPane().add(scrollPane);
        frmJavaApplication.getContentPane().add(lblNewLabel);
        frmJavaApplication.getContentPane().add(lblNewLabel_1);
        frmJavaApplication.getContentPane().add(name);
        frmJavaApplication.getContentPane().add(lblNewLabel_1_1);
        frmJavaApplication.getContentPane().add(email);
        frmJavaApplication.getContentPane().add(lblNewLabel_1_2);
        frmJavaApplication.getContentPane().add(phone);
        frmJavaApplication.getContentPane().add(btnCreate);
        frmJavaApplication.getContentPane().add(btnRead);
        frmJavaApplication.getContentPane().add(btnUpdate);
        frmJavaApplication.getContentPane().add(btnDelete);

        loadData(); // Load data on startup
    }

    private void loadData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/shivwork";
            String user = "root";
            String pass = "Pubg@1432";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String query = "SELECT * FROM emp";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            model.setRowCount(0); // Clear existing data in the table

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                model.addRow(new Object[]{id, name, email, phone});
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
