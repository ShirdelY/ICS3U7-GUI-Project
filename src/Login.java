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

public class Login extends JFrame implements ActionListener{
	// File and Buffer Readers to read the input
    private String input;
    // instance variables for the elements of the JFrame
	private JPanel panel;	
	private JButton login, add_account, back;
	private JTextField username;
	private JPasswordField password;
	private JLabel title, label1, label2;
	// filepath for usernames and passwords
	final private static File USERFILE = new File("users.txt");
	private final Color GREEN = new Color(83, 141, 78), YELLOW = new Color(181, 159, 59);
	
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title, 2 other labels, 2 fields to enter text, and 3 buttons
	 * @param - none
	 * @return - none
	 */
	Login () {
		// declaring the panels
		panel = new JPanel();
		panel.setLayout(null);
		setSize(600, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// title for login page
		title = new JLabel("Login");
		title.setBounds(225,40,300,100);
		title.setFont(new Font("SansSerif", Font.PLAIN, 50));
		title.setForeground(GREEN);
		panel.add(title);
		
		// username label
		label1 = new JLabel("Username");
		label1.setBounds(40,150,100,50);
		label1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		label1.setForeground(YELLOW);
		panel.add(label1);
		
		// username text field
		username = new JTextField(20);
		username.setBounds(175,165,160,25);
		panel.add(username);
		
		// password label
		label2 = new JLabel("Password");
		label2.setBounds(40,205,100,50);
		label2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		label2.setForeground(YELLOW);
		panel.add(label2);
		
		// password field
		password = new JPasswordField(20);
		password.setBounds(175,215,160,25);
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

		add(panel);
		setVisible(true);

		//write data to GameLog if window is closed
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				try
				{
					Main.getStats().closeStats();
				}
				catch (Exception IO)
				{
					System.out.println("writer close error");
				}
				System.exit(0);
			}
		});
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
			dispose();
		}
		if (e.getSource() == add_account) {
			// if back is pressed, we go back to the start by calling it
			new AddAccount();
			dispose();
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
				FileReader file;
			    BufferedReader buffer;
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
							 Main.setUser(correct_username);
							 Main.makeStats();
							new Mainmenu();
							dispose();
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
				if (!usernameExists) {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Username/Password is incorrect");
				}
			}
			//  catch Exception error
			catch (IOException err) {
				System.out.println("error login");
			}
		}	
	}
}