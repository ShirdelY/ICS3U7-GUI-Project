/**
 * 
 * @author shizacharania
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Settings extends JFrame implements ActionListener {

	JButton theme, credits, switchacc, back, exit;
	boolean isLight;

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
		theme = new JButton("Dark Mode");
		theme.setBounds(150, 125, 300, 75);
		add(theme);
		theme.addActionListener(this);

		credits = new JButton("Credits");
		credits.setBounds(150, 225, 300, 75);
		add(credits);
		credits.addActionListener(this);

		switchacc = new JButton("Switch Accounts");
		switchacc.setBounds(150, 325, 300, 75);
		add(switchacc);
		switchacc.addActionListener(this);

		back = new JButton("Back");
		back.setBounds(250, 425, 100, 50);
		add(back);
		back.addActionListener(this);

		exit = new JButton("Exit");
		exit.setBounds(250, 500, 100, 50);
		add(exit);
		exit.addActionListener(this);

		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Settings();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == theme) {
			System.out.println("theme");
			if (isLight) {
				//show light mode
				theme.setText("Dark Mode");
				isLight = false;
			}
			else if (!isLight) {
				//show dark mode
				theme.setText("Light Mode");
				isLight = true;
			}
		}
		if (e.getSource() == credits) {
			System.out.println("credits");
			// if credits is pressed, it clears the frame and calls credits class
		}
		if (e.getSource() == switchacc) {
			System.out.println("switch accounts");
			// if switchacc is pressed, we go back to the login page by calling it
		}
		if (e.getSource() == back) {
			System.out.println("back");
			// if back is pressed, we go back to the main menu by calling it
		}
		if (e.getSource() == exit) {
			System.out.println("exit");
			// if exit is pressed, we terminate the program
			System.exit(0);
		}
	}
}