/**
 * AddAcount.java - version 2
 * This class lets the user login to the game
 * @author Shiza and Shirdel
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class AddAccount extends JFrame implements ActionListener{

	// static instance variables for the elements of the JFrame
	private JPanel panel;	
	private JButton add_acc, back;
	private JTextField username;
	private JPasswordField password, confirm_password;
	private JLabel title, instructions1, instructions2, label1, label2, label3;
	
	// filepath for usernames and passwords
	final private static File USERFILE = new File("users.txt");
	private final Color GREEN = new Color(83, 141, 78), YELLOW = new Color(181, 159, 59);
	
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title, 4 other labels, 3 fields to enter text, and 2 buttons
	 * @param - none
	 * @return - none
	 */
	AddAccount () {
		// declaring the frame and panels
		panel = new JPanel();
		panel.setLayout(null);
		setSize(600, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// title for adding accounts page
		title = new JLabel("Add Account");
		title.setBounds(130,40,400,100);
		title.setFont(new Font("SansSerif", Font.PLAIN, 50));
		title.setForeground(GREEN);
		panel.add(title);
		
		// instructions labels for entering a username and passowrd
		instructions1 = new JLabel("Enter a username and that doesn't have spaces");
		instructions1.setBounds(120,120,600,25);
		instructions1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel.add(instructions1);
		instructions2 = new JLabel(" and a password with more than 4 lettters");
		instructions2.setBounds(125,140,600,25);
		instructions2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel.add(instructions2);
		
		// username label
		label1 = new JLabel("Username");
		label1.setBounds(40,200,100,50);
		label1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		label1.setForeground(YELLOW);
		panel.add(label1);
		
		// username text field
		username = new JTextField(20);
		username.setBounds(250,215,160,25);
		panel.add(username);
		
		// password label
		label2 = new JLabel("Password");
		label2.setBounds(40,255,100,50);
		label2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		label2.setForeground(YELLOW);
		panel.add(label2);
		
		// password field
		password = new JPasswordField(20);
		password.setBounds(250,270,160,25);
		panel.add(password);
		
		// confirm password label
		label3 = new JLabel("Confirm Password");
		label3.setBounds(40,310,300,50);
		label3.setFont(new Font("Monospaced", Font.PLAIN, 20));
		label3.setForeground(YELLOW);
		panel.add(label3);
		
		// confirm password field
		confirm_password = new JPasswordField(20);
		confirm_password.setBounds(250,325,160,25);
		panel.add(confirm_password);
		
		// button to add account
		add_acc = new JButton("Add Account");
		add_acc.setBounds(75,400,200,50);
		panel.add(add_acc);
		add_acc.addActionListener(this);
		
		// button to go back to the login page
		back = new JButton("Back");
		back.setBounds(295,400,200,50);
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
	 * actionPerformed method to manipulate and set specific instructions for the buttons, especially to add an account
	 * @param ActionEvent object e
	 * @return - none
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
//		 TODO Auto-generated method stub
		if (e.getSource() == back) {
			// if back is pressed, we go back to the start by calling it
			new Login();
			dispose();
		}
		if (e.getSource() == add_acc) {
			// actions with text file
			String username_entered = username.getText();
			String password_entered = password.getText();
			String confirm_password_entered = confirm_password.getText();
			if (username_entered.equals("") || password_entered.equals("")) {
				JFrame jFrame = new JFrame();
		        JOptionPane.showMessageDialog(jFrame, "Enter a username and a password");
			}
			try {
				// declaring variables for the file and buffer Reader and Writers
				String input;
				FileReader fileR = new FileReader(USERFILE);
				BufferedReader bufferR = new BufferedReader(fileR);
				// get usernames from the text file database to check if the same username exists
				boolean usernameExists = false;
				while ((input = bufferR.readLine()) != null) {
					String[] user_database = input.split(" ");
					String correct_username = user_database[0];
					if (username_entered.equals(correct_username)) {
						usernameExists = true;
					}
				}
				// if the username exists, have a window popup
				if (usernameExists) {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Username already exists");
				}
				
				//validate username and password
				boolean userValid = false;
				boolean passValid = false;
				boolean isFilled = true;
				// validate the username and password isn't empty
				if (username_entered.equals("") || password_entered.equals("")) {
					isFilled = false;
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Enter a username and a password");
				}
				
				// if username/password has space in it
				// it's not valid because we split the username and password based on a " "
				for (int i = 0; i < username_entered.length(); i++) {
					if (username_entered.charAt(i) == ' ') {
						userValid = true;
					}
				}
				for (int i = 0; i < password_entered.length(); i++) {
					if (password_entered.charAt(i) == ' ' || password_entered.length() < 5) {
						passValid = true;
					}
				}
				
				// if username's not valid
				if (userValid) {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Username not valid");
				}
				// if password's not valid
				else if (passValid) {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Password not valid");
				}
				
				//validate that password and confirm password match
				boolean passwordsMatch = false;
				if (password_entered.equals(confirm_password_entered)) {
					passwordsMatch = true;
				}
				else {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Entered passwords don't match");
				}
				
				//write to file
				if (!usernameExists && !userValid && !passValid && isFilled && passwordsMatch) {
					// writing to file
					FileWriter fileW = new FileWriter (USERFILE, true); //if you set it to true, it appends
					BufferedWriter bufferW = new BufferedWriter (fileW);
		            bufferW.write (username_entered + " " + password_entered);	
		            bufferW.newLine();
		            JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Account added successfully");
		            // empty out the text in the fields
			        username.setText("");
		            password.setText("");
		            confirm_password.setText("");
		        	bufferW.close();
				}
			}
			//  catch Exception error
			catch (IOException err) {
				System.out.print("error addaccount");
			}
			
		}
	}
}