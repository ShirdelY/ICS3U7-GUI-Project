/**
 * Instructions.java - version 1
 * This class displays an image with the instructions + a title and button to go back to the main menu
 * @author shizacharania
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instructions extends JFrame implements ActionListener {
	// declaring button for main menu
	JButton mainmenu;
	
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title, picture and and 1 button
	 * @param - none
	 * @return - none
	 */
	Instructions() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// title of frame
		JLabel label1 = new JLabel("INSTRUCTIONS:"); //center this after
		label1.setBounds(250, 35, 100, 50);
		add(label1);
		
		// main menu buttons
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(250, 525, 100, 50);
		add(mainmenu);
		mainmenu.addActionListener(this);
		
		// image
		ImageIcon pic = new ImageIcon(getClass().getResource("Instructions.jpg"));
		JLabel displayField = new JLabel();
		displayField.setIcon(pic);
		displayField.setBounds(10, 100, 580, 390); // we need to resize the image
		add(displayField);
		
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
		if (e.getSource() == mainmenu) {
//			System.out.println("main menu");
			// if main menu is pressed, we go back to the main menu by calling it
			new Mainmenu();
			dispose();
		}
	}
}
