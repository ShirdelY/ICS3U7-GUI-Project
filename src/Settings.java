/**
 * Settings.java - version 2
 * This class is used as the setting frame and has different buttons to change
 * the theme, see the credits, switch accounts (for login - version 2), see the main menu, and to exit
 * @author Shiza and Shirdel
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Settings extends JFrame implements ActionListener {
	// declaring buttons
	JButton credits, mainmenu, exit;
	private static String current_user;
	private final Color GREEN = new Color(83, 141, 78);

	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title and 5 buttons
	 * @param - none
	 * @return - none
	 */
	Settings(String user) {
		current_user = user;
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// label for title
		JLabel label1 = new JLabel("SETTINGS"); //center this after
		label1.setBounds(180, 50, 300, 50);
		label1.setFont(new Font("SansSerif", Font.PLAIN, 50));
		label1.setForeground(GREEN);
		add(label1);

		// button for credits, main menu, exit
		// credits button
		credits = new JButton("Credits");
		credits.setBounds(150, 175, 300, 75);
		credits.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(credits);
		credits.addActionListener(this);

		// main menu button
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(150, 275, 300, 75);
		mainmenu.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(mainmenu);
		mainmenu.addActionListener(this);

		// exit button
		exit = new JButton("Exit");
		exit.setBounds(250, 375, 100, 50);
		exit.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(exit);
		exit.addActionListener(this);

		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
	 * actionPerformed method to manipulate and set specific instructions for the buttons
	 * @param ActionEvent object
	 * @return - none
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
			try
			{
				Main.getStats().closeStats();
			}
			catch (Exception IO)
			{
				System.out.print("writer close error");
			}
			System.exit(0);
		}
	}
}