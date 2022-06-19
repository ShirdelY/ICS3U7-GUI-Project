/**
 * Statisitcs.java - version 2
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
	JButton mainmenu, exit;
	Statistics stats = new Statistics(new File("src/GameLog.txt"));
	
	public static void main(String[] args) throws IOException {
		new StatisticsPage();
	}
	
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
		add(label1);
		
		JLabel label2 = new JLabel("Games Played");
		label2.setBounds(125, 200, 600, 100);
		label2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		add(label2);

		int games_played = stats.numGames();
		JLabel anslabel2 = new JLabel(String.valueOf(games_played));
		anslabel2.setBounds(160, 150, 600, 100);
		anslabel2.setFont(new Font("SansSerif", Font.PLAIN, 40));
		add(anslabel2);
		
		JLabel label3 = new JLabel("Games Won");
		label3.setBounds(275, 200, 600, 100);
		label3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		add(label3);
		
		//change this
		int games_won = stats.numGames();
		JLabel anslabel3 = new JLabel(String.valueOf(games_won)); 
		anslabel3.setBounds(310, 150, 600, 100);
		anslabel3.setFont(new Font("SansSerif", Font.PLAIN, 40));
		add(anslabel3);
		
		JLabel label4 = new JLabel("Win %");
		label4.setBounds(425, 200, 600, 100);
		label4.setFont(new Font("SansSerif", Font.PLAIN, 15));
		add(label4);
		
		//change this
		try {
			double prob = (stats.numGames()/stats.numGames())*100;
			JLabel anslabel4 = new JLabel(String.valueOf(prob)+"%");
			anslabel4.setBounds(490, 150, 600, 100);
			anslabel4.setFont(new Font("SansSerif", Font.PLAIN, 40));
			add(anslabel4);
		}
		catch (java.lang.ArithmeticException e) {
			System.out.println("no games played");
//			JFrame jFrame = new JFrame();
//	        JOptionPane.showMessageDialog(jFrame, "You haven't played any games yet");
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
			System.exit(0);
		}
	}
}
