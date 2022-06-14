import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddAccount implements ActionListener{
	private static JFrame frame;	
	private static JPanel panel;	
	private static JButton add_acc, back;
	private static JTextField username;
	private static JPasswordField password, confirm_password;
	private static JLabel label1, label2, label3;
	
	AddAccount () {
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(600, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label1 = new JLabel("Username");
		label1.setBounds(50,150,80,25);
		panel.add(label1);
		
		username = new JTextField(20);
		username.setBounds(200,150,160,25);
		panel.add(username);
		
		label2 = new JLabel("Password");
		label2.setBounds(50,200,80,25);
		panel.add(label2);
		
		password = new JPasswordField(20);
		password.setBounds(200,200,160,25);
		panel.add(password);
		
		label3 = new JLabel("Confirm Password");
		label3.setBounds(50,250,125,25);
		panel.add(label3);
		
		confirm_password = new JPasswordField(20);
		confirm_password.setBounds(200,250,160,25);
		panel.add(confirm_password);
		
		add_acc = new JButton("Add Account");
		add_acc.setBounds(75,325,200,50);
		panel.add(add_acc);
		add_acc.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(295,325,200,50);
		panel.add(back);
		back.addActionListener(this);

		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AddAccount();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		 TODO Auto-generated method stub
		if (e.getSource() == back) {
			// if back is pressed, we go back to the start by calling it
			new Login();
			frame.dispose();
		}
		if (e.getSource() == add_acc) {
			// if back is pressed, we go back to the start by calling it
			// actions with text file
		}
	}
}