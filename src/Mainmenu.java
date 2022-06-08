/**
 * 
 * @author shizacharania
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainmenu extends JFrame implements ActionListener {
	JButton easymode, hardmode, instructions, settings, stats, back;

	Mainmenu() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JLabel label1 = new JLabel("Main Menu"); //center this after
		label1.setBounds(250, 35, 100, 75);
		add(label1);

		// button for instructions, settings, easymode, hardmode, stats, back
		easymode = new JButton("Easy Mode");
		easymode.setBounds(150, 125, 300, 60);
		add(easymode);
		easymode.addActionListener(this);

		hardmode = new JButton("Hard Mode");
		hardmode.setBounds(150, 200, 300, 60);
		add(hardmode);
		hardmode.addActionListener(this);
		
		instructions = new JButton("Instructions");
		instructions.setBounds(150, 275, 300, 60);
		add(instructions);
		instructions.addActionListener(this);
		
		stats = new JButton("Statistics");
		stats.setBounds(150, 350, 300, 60);
		add(stats);
		stats.addActionListener(this);
		
		settings = new JButton("Settings");
		settings.setBounds(150, 425, 300, 60);
		add(settings);
		settings.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(250, 500, 100, 50);
		add(back);
		back.addActionListener(this);

		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Mainmenu();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == easymode) {
			System.out.println("easy mode");
			// if easymode is pressed, it clears the frame and calls easy mode class
		}
		if (e.getSource() == hardmode) {
			System.out.println("hard mode");
			// if hardmode is pressed, it clears the frame and calls hard mode class
		}
		if (e.getSource() == instructions) {
			System.out.println("instructions");
			// if instructions is pressed, it clears the frame and calls instruction class
		}
		if (e.getSource() == stats) {
			System.out.println("stats");
			// if instructions is pressed, it clears the frame and calls instruction class
		}
		if (e.getSource() == settings) {
			System.out.println("settings");
			// if settings is pressed, it clears the frame and calls settings class
		}
		if (e.getSource() == back) {
			System.out.println("back");
			// if back is pressed, we go to the start by calling it
		}
	}
}
