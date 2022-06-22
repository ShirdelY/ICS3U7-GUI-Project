/**
 * StatistcsPage.java - version 2
 * @author Shiza and Shirdel
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.lang.ArithmeticException;

public class StatisticsPage extends JFrame implements ActionListener {
	// declaring buttons
	private JButton mainmenu, exit;
	private Statistics stats = Main.getStats();
	private final Color GREEN = new Color(83, 141, 78), YELLOW = new Color(181, 159, 59);
	
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title and 3 buttons
	 * @param - none
	 * @return - none
	 * @throws IOException 
	 */
	StatisticsPage() throws IOException {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// title label
		JLabel label1 = new JLabel("Statistics");
		label1.setBounds(200, 50, 600, 100);
		label1.setFont(new Font("SansSerif", Font.BOLD, 40));
		label1.setForeground(GREEN);
		add(label1);
		
		JLabel label2 = new JLabel("Games Played");
		label2.setBounds(75, 200, 600, 100);
		label2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		label2.setForeground(YELLOW);
		add(label2);

		JLabel anslabel2 = new JLabel(String.valueOf(stats.getTotalGamesPlayed()));
		anslabel2.setBounds(110, 150, 600, 100);
		anslabel2.setFont(new Font("SansSerif", Font.PLAIN, 40));
		add(anslabel2);
		
		JLabel label3 = new JLabel("Games Won");
		label3.setBounds(225, 200, 600, 100);
		label3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		label3.setForeground(YELLOW);
		add(label3);
		
		//change this
		JLabel anslabel3 = new JLabel(String.valueOf(stats.getTotalGamesWon()));
		anslabel3.setBounds(260, 150, 600, 100);
		anslabel3.setFont(new Font("SansSerif", Font.PLAIN, 40));
		add(anslabel3);
		
		JLabel label4 = new JLabel("Win %");
		label4.setBounds(400, 200, 600, 100);
		label4.setFont(new Font("SansSerif", Font.PLAIN, 15));
		label4.setForeground(YELLOW);
		add(label4);
		
		//change this
		try {
			JLabel anslabel4 = new JLabel((stats.getProbWin() * 100)+"%");
			anslabel4.setBounds(360, 150, 600, 100);
			anslabel4.setFont(new Font("SansSerif", Font.PLAIN, 40));
			add(anslabel4);
		}
		catch (java.lang.ArithmeticException e) {
			JFrame jFrame = new JFrame();
	        JOptionPane.showMessageDialog(jFrame, "You haven't played any games yet");
		}
				
		// main menu button
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(125, 325, 150, 50);
		add(mainmenu);
		mainmenu.addActionListener(this);
		
		// exit button
		exit = new JButton("Exit");
		exit.setBounds(300, 325, 150, 50);
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
