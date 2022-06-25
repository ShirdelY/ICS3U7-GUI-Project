/**
 * Congratulations.java - version 3  
 * This class shows a frame to congratulate the user for guessing the word
 * @author Shiza and Shirdel
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Congratulations extends JFrame implements ActionListener {
	// declaring buttons and the color green
	private JButton mainmenu, exit, statistics;
	private final Color GREEN = new Color(83, 141, 78);
	
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
		JLabel label1 = new JLabel("CONGRATULATIONS!"); //center this after
		label1.setBounds(70, 150, 600, 100);
		label1.setFont(new Font("SansSerif", Font.BOLD, 40));
		label1.setForeground(GREEN);
		add(label1);
		
		JLabel label2 = new JLabel("YOU GOT THE WORD!!!"); //center this after
		label2.setBounds(50, 215, 600, 100);
		label2.setFont(new Font("SansSerif", Font.BOLD, 40));
		add(label2);
		
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
		if (e.getSource() == statistics) {
			new StatisticsPage();
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