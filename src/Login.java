/**
 * Login.java - version 2
 * This class lets the user login to the game
 * @author Shiza and Shirdel
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class Login implements ActionListener{
	// File and Buffer Readers to read the input
	FileReader file;
    BufferedReader buffer;
    String input;
    // instance variables for the elements of the JFrame
	private static JFrame frame;	
	private static JPanel panel;	
	private static JButton login, add_account, back;
	private static JTextField username;
	private static JPasswordField password;
	private static JLabel title, label1, label2;
	
	// filepath for usernames and passwords
	final private static File USERFILE = new File("src/users.txt");
	
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title, 2 other labels, 2 fields to enter text, and 3 buttons
	 * @param - none
	 * @return - none
	 */
	Login () {
		// declaring the frame and panels
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(600, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// title for login page
		title = new JLabel("Login");
		title.setBounds(275,40,300,25);
		panel.add(title);
		
		// username label
		label1 = new JLabel("Username");
		label1.setBounds(50,150,80,25);
		panel.add(label1);
		
		// username text field
		username = new JTextField(20);
		username.setBounds(150,150,160,25);
		panel.add(username);
		
		// password label
		label2 = new JLabel("Password");
		label2.setBounds(50,200,80,25);
		panel.add(label2);
		
		// password field
		password = new JPasswordField(20);
		password.setBounds(150,200,160,25);
		panel.add(password);
		
		// button to login
		login = new JButton("Login");
		login.setBounds(75,300,80,50);
		panel.add(login);
		login.addActionListener(this);
		
		// button to add a new account
		add_account = new JButton("Don't have an account?");
		add_account.setBounds(175,300,200,50);
		panel.add(add_account);
		add_account.addActionListener(this);
		
		// button to go back to the start page
		back = new JButton("Back");
		back.setBounds(395,300,80,50);
		panel.add(back);
		back.addActionListener(this);

		frame.add(panel);
		frame.setVisible(true);
	}

	/**
	 * actionPerformed method to manipulate and set specific instructions for the buttons, especially to log in
	 * @param ActionEvent object e
	 * @return - none
	 */
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
			// if the user doesn't enter anything
			if (username_entered.equals("") || password_entered.equals("")) {
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Enter a username and a password");
			}
			try {
				// reading the text file
				file = new FileReader(USERFILE);
				buffer = new BufferedReader(file);
				// checking if the username exists and if they're correct or not
				boolean usernameExists = false;
				while ((input = buffer.readLine()) != null) {
					// getting the username and password from the database
					String[] user_database = input.split(" ");
					String correct_username = user_database[0];
					String correct_password = user_database[1];
					// if the username is the same as the username in the database
					if (username_entered.equals(correct_username)) {
						usernameExists = true;
						// passwords are the same
						if (password_entered.equals(correct_password)) {
							new Mainmenu();
							frame.dispose();
						}
						// when password is incorrect
						else {
							//add popup
							JFrame jFrame = new JFrame();
					        JOptionPane.showMessageDialog(jFrame, "Password is incorrect");
						}
					}
				}
				// when username doesn't exist in the database
				if (usernameExists == false) {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Username/Password is incorrect");
				}
			}
			//  catch Exception error
			catch (IOException err) {
				System.out.print("error");
			}
		}	
	}
}