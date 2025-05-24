package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
public class Demoframe {
public static void main(String[] args) {
	JFrame frame=new JFrame();
	frame.setSize(500,500);
	frame.setVisible(true);
	frame.setLayout(null);
	frame.setTitle("Registration Form");
	JLabel head=new JLabel("Student Registration");
	head.setBounds(250, 100, 150, 50);
	head.setFont(new Font("Arial Black", Font.BOLD, 20));

	frame.add(head);
}
}
