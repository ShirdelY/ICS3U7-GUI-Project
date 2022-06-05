/**
 * 
 * @author shizacharania
 *
 */
//frame.setLayout(null);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.getContentPane().setBackground(Color.WHITE);
//    frame.setVisible(true);
//    frame.setResizable(false);
//    frame.setSize(600,650);

import java.awt.*;
import javax.swing.*;

public class Settings extends JFrame {
	Settings() {
		setLayout(null); //if formatting is weird, use this
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JLabel label1 = new JLabel("SETTINGS"); //center this after
		label1.setBounds(250, 35, 100, 50);
		add(label1);
		
//		ActionListener click = new ActionListener();
		
		// button for back, switch account, dark mode, light mode, logout
		boolean isLight = true; // we can change this
		JButton theme = new JButton();
		JButton credits = new JButton("Credits");
		JButton switchacc = new JButton("Switch Accounts");
		JButton logout = new JButton("Log out");
		JButton back = new JButton("Back");
		theme.setBounds(150, 125, 300, 75);
		credits.setBounds(150, 225, 300, 75);
		switchacc.setBounds(150, 325, 300, 75);
		logout.setBounds(150, 425, 300, 75);
		back.setBounds(250, 525, 100, 50);
		add(theme);
		add(credits);
		add(switchacc);
		add(logout);
		add(back);
		
		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			if (isLight) {
				theme.setText("Dark Mode");
			}
			else if (!isLight) {
				theme.setText("Light Mode");
			}
			
			//add the button stuff here
		}
		
//		button1.addActionListener(click);
	}
	public static void main(String[] args) {
		new Settings();
	}
}

