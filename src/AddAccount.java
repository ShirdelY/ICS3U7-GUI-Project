import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddAccount implements ActionListener{
	FileWriter fileW;
	FileReader fileR;
	String input;
	BufferedWriter bufferW;
	BufferedReader bufferR;

	private static JFrame frame;	
	private static JPanel panel;	
	private static JButton add_acc, back;
	private static JTextField username;
	private static JPasswordField password, confirm_password;
	private static JLabel title, instructions, label1, label2, label3;
	
	final private static File USERFILE = new File("src/users.txt");
	
	AddAccount () {
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		frame.setSize(600, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		title = new JLabel("Add Account");
		title.setBounds(250,40,300,25);
		panel.add(title);
		
		instructions = new JLabel("Enter a username and that doesn't have spaces and a password with more than 4 lettters");
		instructions.setBounds(20,75,600,25);
		panel.add(instructions);
		
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
				//validate the username doesn't exist
				boolean usernameExists = false;
				while ((input = bufferR.readLine()) != null) {
					String[] user_database = input.split(" ");
					String correct_username = user_database[0];
					if (username_entered.equals(correct_username)) {
						usernameExists = true;
					}
				}
				if (usernameExists) {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Username already exists");
					//do we add break here?
				}
				
				//validate username and password
				boolean userValid = false;
				boolean passValid = false;
				if (username_entered.equals("") || password_entered.equals("")) {
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Enter a username and a password");
					//add break?
				}
				
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
				if (userValid) {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Username not valid");
					//add break?
				}
				else if (passValid) {
					//add popup
					JFrame jFrame = new JFrame();
			        JOptionPane.showMessageDialog(jFrame, "Password not valid");
					//add break?
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
					//add break?
				}
				
				//write to file
				if (!usernameExists && !userValid && !passValid) {
//					System.out.println("added");
					fileW = new FileWriter (USERFILE, true); //if you set it to true, it appends
		            bufferW = new BufferedWriter (fileW);
		            bufferW.write (username_entered + " " + password_entered);	
		            bufferW.newLine();		            
		            username.setText("");
		            password.setText("");
		            confirm_password.setText("");
		        	bufferW.close();
				}
			}
			catch (IOException err) {
				System.out.print("error");
			}
			
		}
	}
}