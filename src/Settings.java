/**
 * 
 * @author shizacharania
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Settings extends JFrame implements ActionListener {
	// declaring buttons and isLight for dark/light mode
	JButton theme, credits, switchacc, mainmenu, exit;
	boolean isLight;

	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title and 5 buttons
	 * @param - none
	 * @return - none
	 */
	Settings() {
		setLayout(null); //if formatting is weird, use this
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JLabel label1 = new JLabel("SETTINGS"); //center this after
		label1.setBounds(250, 35, 100, 50);
		add(label1);

		//		ActionListener click = new ActionListener();

		// button for back, switch account, dark mode, light mode, logout
		boolean isLight = true; // we can manipulate the value of this variable
		
		// theme button
		theme = new JButton("Dark Mode");
		theme.setBounds(150, 125, 300, 75);
		add(theme);
		theme.addActionListener(this);

		// credits button
		credits = new JButton("Credits");
		credits.setBounds(150, 225, 300, 75);
		add(credits);
		credits.addActionListener(this);

		// switch buttons
		switchacc = new JButton("Switch Accounts");
		switchacc.setBounds(150, 325, 300, 75);
		add(switchacc);
		switchacc.addActionListener(this);

		// main menu button
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(250, 425, 100, 50);
		add(mainmenu);
		mainmenu.addActionListener(this);

		// exit button
		exit = new JButton("Exit");
		exit.setBounds(250, 500, 100, 50);
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
			System.out.println("theme");
			if (isLight) {
				//show light mode
				theme.setText("Dark Mode");
				isLight = false;
			}
			else if (!isLight) {
				//show dark mode
				theme.setText("Light Mode");
				isLight = true;
			}
		}
		if (e.getSource() == credits) {
			System.out.println("credits");
			// if credits is pressed, it clears the frame and calls credits class
		}
		if (e.getSource() == switchacc) {
			System.out.println("switch accounts");
			// if switchacc is pressed, we go back to the login page by calling it
		}
		if (e.getSource() == mainmenu) {
			System.out.println("main menu");
			// if main menu is pressed, we go back to the main menu by calling it
		}
		if (e.getSource() == exit) {
			System.out.println("exit");
			// if exit is pressed, we terminate the program
			System.exit(0);
		}
	}
}