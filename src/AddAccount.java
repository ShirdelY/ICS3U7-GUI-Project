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

public class AddAccount implements ActionListener{
	// declaring variables for the file and buffer Reader and Writers
	FileWriter fileW;
	FileReader fileR;
	String input;
	BufferedWriter bufferW;
	BufferedReader bufferR;

	// static instance variables for the elements of the JFrame
	private static JFrame frame;	
	private static JPanel panel;	
	private static JButton add_acc, back;
	private static JTextField username;
	private static JPasswordField password, confirm_password;
	private static JLabel title, instructions, label1, label2, label3;
	
	// filepath for usernames and passwords
	final private static File USERFILE = new File("src/users.txt");
	
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title, 4 other labels, 3 fields to enter text, and 2 buttons
	 * @param - none
	 * @return - none
	 */
	AddAccount () {
		// declaring the frame and panels
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(600, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// title for adding accounts page
		title = new JLabel("Add Account");
		title.setBounds(250,40,300,25);
		panel.add(title);
		
		// instructions label for entering a username and passowrd
		instructions = new JLabel("Enter a username and that doesn't have spaces and a password with more than 4 lettters");
		instructions.setBounds(20,75,600,25);
		panel.add(instructions);
		
		// username label
		label1 = new JLabel("Username");
		label1.setBounds(50,150,80,25);
		panel.add(label1);
		
		// username text field
		username = new JTextField(20);
		username.setBounds(200,150,160,25);
		panel.add(username);
		
		// password label
		label2 = new JLabel("Password");
		label2.setBounds(50,200,80,25);
		panel.add(label2);
		
		// password field
		password = new JPasswordField(20);
		password.setBounds(200,200,160,25);
		panel.add(password);
		
		// confirm password label
		label3 = new JLabel("Confirm Password");
		label3.setBounds(50,250,125,25);
		panel.add(label3);
		
		// confirm password field
		confirm_password = new JPasswordField(20);
		confirm_password.setBounds(200,250,160,25);
		panel.add(confirm_password);
		
		// button to add account
		add_acc = new JButton("Add Account");
		add_acc.setBounds(75,325,200,50);
		panel.add(add_acc);
		add_acc.addActionListener(this);
		
		// button to go back to the login page
		back = new JButton("Back");
		back.setBounds(295,325,200,50);
		panel.add(back);
		back.addActionListener(this);

		frame.add(panel);
		frame.setVisible(true);
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
			frame.dispose();
		}
		if (e.getSource() == add_acc) {
			// actions with text file
			String username_entered = username.getText();
			String password_entered = password.getText();
			String confirm_password_entered = confirm_password.getText();
			try {
				fileR = new FileReader(USERFILE);
				bufferR = new BufferedReader(fileR);
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
				// validate the username and password isn't empty
				if (username_entered.equals("") || password_entered.equals("")) {
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
				if (!usernameExists && !userValid && !passValid) {
					// writing to file
					fileW = new FileWriter (USERFILE, true); //if you set it to true, it appends
		            bufferW = new BufferedWriter (fileW);
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
				System.out.print("error");
			}
			
		}
	}
}