/**
 * Settings.java - version 1
 * This class is used as the setting frame and has different buttons to change
 * the theme, see the credits, switch accounts (for login - version 2), see the main menu, and to exit
 * @author shizacharania
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Settings extends JFrame implements ActionListener {
	// declaring buttons and isLight for dark/light mode
	JButton theme, credits, mainmenu, exit;
	boolean isLight;

	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title and 5 buttons
	 * @param - none
	 * @return - none
	 */
	Settings() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// label for title
		JLabel label1 = new JLabel("SETTINGS"); //center this after
		label1.setBounds(250, 35, 100, 50);
		add(label1);

		// button for back, switch account, dark mode, light mode, logout
		boolean isLight = true; // we can manipulate the value of this variable
		
		// theme button
		theme = new JButton("Dark Mode");
		theme.setBounds(150, 175, 300, 75);
		add(theme);
		theme.addActionListener(this);

		// credits button
		credits = new JButton("Credits");
		credits.setBounds(150, 275, 300, 75);
		add(credits);
		credits.addActionListener(this);

		// main menu button
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(150, 375, 300, 75);
		add(mainmenu);
		mainmenu.addActionListener(this);

		// exit button
		exit = new JButton("Exit");
		exit.setBounds(250, 475, 100, 50);
		add(exit);
		exit.addActionListener(this);

		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * main method for calling the Settings() constructor
	 * @param args
	 * @return - none
	 */
	public static void main(String[] args) {
		new Settings();
	}
	/**
	 * actionPerformed method to manipulate and set specific instructions for the buttons
	 * @param ActionEvent object
	 * @return - none
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == theme) {
			//if the button is in light mode
			if (isLight) {
				//show light mode
				theme.setText("Dark Mode");
				System.out.println("now in light mode");
				isLight = false;
			}
			//if the button is in dark mode
			else if (!isLight) {
				//show dark mode
				theme.setText("Light Mode");
				System.out.println("now in dark mode");
				isLight = true;
			}
		}
		if (e.getSource() == credits) {
			// if credits is pressed, it clears the frame and calls credits class
			new Credits();
			dispose();
		}
		if (e.getSource() == mainmenu) {
			// if main menu is pressed, we go back to the main menu by calling it
			new Mainmenu();
			dispose();
		}
		if (e.getSource() == exit) {
			// if exit is pressed, we terminate the program
			System.exit(0);
		}
	}
}