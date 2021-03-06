/**
 * Instructions.java - version 3 
 * This class displays an image with the instructions
 * @author Shiza and Shirdel
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
		getContentPane();

		// title of frame
		JLabel label1 = new JLabel("INSTRUCTIONS"); //center this after
		label1.setBounds(120, 30, 500, 50);
		label1.setFont(new Font("SansSerif", Font.PLAIN, 50));

		add(label1);
		
		// main menu buttons
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(250, 525, 100, 50);
		add(mainmenu);
		mainmenu.addActionListener(this);
		
		// image
		ImageIcon pic = new ImageIcon(getClass().getResource("Instructions.jpg"));
		Image scaledImage = pic.getImage();
		scaledImage = scaledImage.getScaledInstance(550, 450, java.awt.Image.SCALE_SMOOTH);
		JLabel displayField = new JLabel();
		displayField.setIcon(new ImageIcon(scaledImage)); 
		displayField.setBounds(25, 90, 550, 420);
        add(displayField);
		
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
		if (e.getSource() == mainmenu) {
			// if main menu is pressed, we go back to the main menu by calling it
			new Mainmenu();
			dispose();
		}
	}
}
