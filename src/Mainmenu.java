/**
 * Mainmenu.java - version 2
 * This class shows the main menu and its different buttons
 * @author shizacharania
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainmenu extends JFrame implements ActionListener {
	// declaring buttons
	JButton easymode, hardmode, instructions, settings, stats, logout;

	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title and 6 buttons
	 * @param - none
	 * @return - none
	 */
	Mainmenu() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// title label
		JLabel label1 = new JLabel("Main Menu"); //center this after
		label1.setBounds(250, 35, 100, 75);
		add(label1);

		// button for instructions, settings, easymode, hardmode, stats, logout
		// easymode button
		easymode = new JButton("Easy Mode");
		easymode.setBounds(150, 125, 300, 60);
		add(easymode);
		easymode.addActionListener(this);

		// hard mode button
		hardmode = new JButton("Hard Mode");
		hardmode.setBounds(150, 200, 300, 60);
		add(hardmode);
		hardmode.addActionListener(this);
		
		// instructions button
		instructions = new JButton("Instructions");
		instructions.setBounds(150, 275, 300, 60);
		add(instructions);
		instructions.addActionListener(this);
		
		// stats button
		stats = new JButton("Statistics");
		stats.setBounds(150, 350, 300, 60);
		add(stats);
		stats.addActionListener(this);
		
		// settings button
		settings = new JButton("Settings");
		settings.setBounds(150, 425, 300, 60);
		add(settings);
		settings.addActionListener(this);
		
		// logout button
		logout = new JButton("Logout");
		logout.setBounds(250, 500, 100, 50);
		add(logout);
		logout.addActionListener(this);

		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * actionPerformed method to manipulate and set specific instructions for the buttons
	 * @param ActionEvent object
	 * @return - none
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == easymode) {
			// if easymode is pressed, it clears the frame and calls easy mode class
			new Game(Main.getFive()[(int) (Math.random() * Main.getFive().length)], Main.getFive(), 0);
			dispose();
		}
		if (e.getSource() == hardmode) {
			// if hardmode is pressed, it clears the frame and calls hard mode class
			new Game(Main.getSeven()[(int) (Math.random() * Main.getSeven().length)], Main.getSeven(), 1);
			dispose();
		}
		if (e.getSource() == instructions) {
			// if instructions is pressed, it clears the frame and calls instruction class
			new Instructions();
			dispose();
		}
		if (e.getSource() == stats) {
			System.out.println("statistics");
			// if instructions is pressed, it clears the frame and calls instruction class
		}
		if (e.getSource() == settings) {
			// if settings is pressed, it clears the frame and calls settings class
			new Settings();
			dispose();
		}
		if (e.getSource() == logout) {
			// if logout is pressed, we go to the start page by calling it
			new Start();
			dispose();
		}
	}
}
