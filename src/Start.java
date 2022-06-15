/**
 * Start.java - version 2
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
	// declaring button to start the game
	private JButton start;
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing the title, and 1 button
	 * @param - none
	 * @return - none
	 */
	Start() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// game title
		JLabel label1 = new JLabel("HELLO WORDL"); //center this after
		label1.setBounds(250, 35, 100, 50);
		add(label1);
		
		// start button
		start = new JButton("Start");
		start.setBounds(200, 475, 200, 75);
		add(start);
		start.addActionListener(this);
		
		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			//create main menu
			new Login();
			dispose();
		}
	}
}
