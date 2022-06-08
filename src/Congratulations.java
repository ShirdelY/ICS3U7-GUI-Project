/**
 * Congratulations.java - version 1
 * This class shows a frame to congratulate the user for guessing the word
 * @author shizacharania
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Congratulations extends JFrame implements ActionListener {
	// declaring buttons
	JButton mainmenu, exit, statistics;
	
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title and 3 buttons
	 * @param - none
	 * @return - none
	 */
	Congratulations() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// title label
		JLabel label1 = new JLabel("CONGRATULATIONS!!! YOU GOT THE WORD"); //center this after
		label1.setBounds(150, 200, 400, 50);
		add(label1);
		
		// statistics button
		statistics = new JButton("Statistics");
		statistics.setBounds(50, 325, 150, 50);
		add(statistics);
		statistics.addActionListener(this);
		
		// main menu button
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(225, 325, 150, 50);
		add(mainmenu);
		mainmenu.addActionListener(this);
		
		// exit button
		exit = new JButton("Exit");
		exit.setBounds(400, 325, 150, 50);
		add(exit);
		exit.addActionListener(this);
		
		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * main method for calling the Congratulations() constructor
	 * @param args
	 * @return - none
	 */
	public static void main(String[] args) {
		new Congratulations();
	}
	/**
	 * actionPerformed method to manipulate and set specific instructions for the buttons
	 * @param ActionEvent object
	 * @return - none
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == statistics) {
			System.out.println("statistics");
			// if statistics is pressed, we show the statistics frame
		}
		if (e.getSource() == mainmenu) {
//			System.out.println("main menu");
			// if main menu is pressed, we go back to the main menu by calling it
			new Mainmenu();
			dispose();
		}
		if (e.getSource() == exit) {
//			System.out.println("exit");
			// if exit is pressed, we terminate the program
			System.exit(0);
		}
	}
}
