import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener{
	FileReader file;		//create stream to file
    BufferedReader buffer;
    String input;
	private static JFrame frame;	
	private static JPanel panel;	
	private static JButton login, add_account, back;
	private static JTextField username;
	private static JPasswordField password;
	private static JLabel title, label1, label2;
	
	final private static File USERFILE = new File("src/users.txt");
	
	Login () {
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(600, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		title = new JLabel("Login");
		title.setBounds(275,40,300,25);
		panel.add(title);
		
		label1 = new JLabel("Username");
		label1.setBounds(50,150,80,25);
		panel.add(label1);
		
		username = new JTextField(20);
		username.setBounds(150,150,160,25);
		panel.add(username);
		
		label2 = new JLabel("Password");
		label2.setBounds(50,200,80,25);
		panel.add(label2);
		
		password = new JPasswordField(20);
		password.setBounds(150,200,160,25);
		panel.add(password);
		
		login = new JButton("Login");
		login.setBounds(75,300,80,50);
		panel.add(login);
		login.addActionListener(this);
		
		add_account = new JButton("Don't have an account?");
		add_account.setBounds(175,300,200,50);
		panel.add(add_account);
		add_account.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(395,300,80,50);
		panel.add(back);
		back.addActionListener(this);

		frame.add(panel);
		frame.setVisible(true);
	}
	
//	public static void main(String[] args) {
//		new Login();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			// if back is pressed, we go back to the start by calling it
			new Start();
			frame.dispose();
		}
		if (e.getSource() == add_account) {
			// if back is pressed, we go back to the start by calling it
			new AddAccount();
			frame.dispose();
		}
		if (e.getSource() == login) {
			// if back is pressed, we go back to the start by calling it
			String username_entered = username.getText();
			String password_entered = password.getText();
			if (username_entered.equals("") || password_entered.equals("")) {
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Enter a username and a password");
				//add break?
			}
			try {
				file = new FileReader(USERFILE);
				buffer = new BufferedReader(file);
				boolean usernameExists = false;
				while ((input = buffer.readLine()) != null) {
					String[] user_database = input.split(" ");
					String correct_username = user_database[0];
					String correct_password = user_database[1];
					if (username_entered.equals(correct_username)) {
						usernameExists = true;
						if (password_entered.equals(correct_password)) {
							new Mainmenu();
							frame.dispose();
						}
						else {
							//add popup
							JFrame jFrame = new JFrame();
					        JOptionPane.showMessageDialog(jFrame, "Username/Password is incorrect");
						}
					}
				}
				if (usernameExists == false) {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Username/Password is incorrect");
				}
			}
			catch (IOException err) {
				System.out.print("error");
			}
		}	
	}
}