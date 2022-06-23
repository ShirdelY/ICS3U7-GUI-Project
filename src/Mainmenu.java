/**
 * Mainmenu.java - version 2
 * This class shows the main menu and its different buttons
 * @author Shiza and Shirdel
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainmenu extends JFrame implements ActionListener {
	// declaring buttons
	private JButton easymode, hardmode, instructions, settings, stats, logout;
	private final Color GREEN = new Color(83, 141, 78);
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title and 6 buttons
	 * @param - none
	 * @return - none
	 */
	
	private static String current_user; 
	
	Mainmenu() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// title label
		JLabel label1 = new JLabel("Main Menu"); //center this after
		label1.setBounds(170,40,400,100);
		label1.setFont(new Font("SansSerif", Font.PLAIN, 50));
		label1.setForeground(GREEN);
		add(label1);

		// button for instructions, settings, easymode, hardmode, stats, logout
		// easymode button
		easymode = new JButton("Easy Mode");
		easymode.setBounds(150, 150, 300, 60);
		easymode.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(easymode);
		easymode.addActionListener(this);

		// hard mode button
		hardmode = new JButton("Hard Mode");
		hardmode.setBounds(150, 230, 300, 60);
		hardmode.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(hardmode);
		hardmode.addActionListener(this);
		
		// instructions button
		instructions = new JButton("Instructions");
		instructions.setBounds(150, 305, 300, 60);
		instructions.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(instructions);
		instructions.addActionListener(this);
		
		// stats button
		stats = new JButton("Statistics");
		stats.setBounds(150, 380, 300, 60);
		stats.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(stats);
		stats.addActionListener(this);
		
		// settings button
		settings = new JButton("Settings");
		settings.setBounds(150, 455, 300, 60);
		settings.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(settings);
		settings.addActionListener(this);
		
		// logout button
		logout = new JButton("Logout");
		logout.setBounds(245, 530, 120, 60);
		logout.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(logout);
		logout.addActionListener(this);

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
		if (e.getSource() == easymode) {
			// if easymode is pressed, it clears the frame and calls easy mode class
			new Game(Main.getFive()[(int) (Math.random() * Main.getFive().length)], Main.getFive(), 0);
			dispose();
		}
		if (e.getSource() == hardmode){
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
			try {
				new StatisticsPage();
				dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == settings) {
			// if settings is pressed, it clears the frame and calls settings class
			new Settings(current_user);
			dispose();
		}
		if (e.getSource() == logout) {
			// if logout is pressed, we go to the start page by calling it
			try
			{
				Main.getStats().closeStats();
			}
			catch (Exception IO)
			{
				System.out.println("writer close error");
			}
			new Start();
			dispose();
		}
	}
}
