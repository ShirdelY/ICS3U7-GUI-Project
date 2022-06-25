/**
 * Start.java - version 3  
 * This class displays the title page of our program with the start button to go to the main menu
 * @author Shiza and Shirdel
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Start extends JFrame implements ActionListener {
	// declaring button to start the game and colors for the elements
	private JButton start;
	private final Color GREEN = new Color(83, 141, 78), YELLOW = new Color(181, 159, 59);
	
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing the titles and 1 button
	 * @param - none
	 * @return - none
	 */
	Start() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// game title
		JLabel label1 = new JLabel("HELLO WORDL");
		label1.setBounds(30, 150, 600, 100);
		label1.setFont(new Font("SansSerif", Font.BOLD, 70));
		add(label1);
		
		// project title
		JLabel label2 = new JLabel("ICS3U7 GUI Culminating Project");
		label2.setBounds(60, 250, 500, 50);
		label2.setFont(new Font("SansSerif", Font.PLAIN, 30));
		add(label2);
		label2.setForeground(GREEN);
		
		// start button
		start = new JButton("Start");
		start.setBounds(200, 375, 200, 75);
		start.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(start);
		start.addActionListener(this);
		
		// authors credit
		JLabel label3 = new JLabel("By Shiza Charania and Shirdel Yan");
		label3.setBounds(125, 550, 500, 50);
		label3.setFont(new Font("SansSerif", Font.ITALIC, 20));
		add(label3);
		label3.setForeground(YELLOW);
		
		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// write data to GameLog if window is closed
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
	 * actionPerformed method to manipulate and set specific instructions for the button
	 * @param ActionEvent object
	 * @return - none
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == start) {
			//create log in page
			new Login();
			dispose();
		}
	}
}
