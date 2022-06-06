/**
 * 
 * @author shizacharania
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Congratulations extends JFrame implements ActionListener {
	JButton mainmenu, exit, statistics;
	Congratulations() {
		// back brings it to main menu
		// exit terminates the program

		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JLabel label1 = new JLabel("CONGRATULATIONS!!! YOU GOT THE WORD"); //center this after
		label1.setBounds(150, 200, 400, 50);
		add(label1);
		
		statistics = new JButton("Statistics");
		statistics.setBounds(50, 325, 150, 50);
		add(statistics);
		statistics.addActionListener(this);
		
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(225, 325, 150, 50);
		add(mainmenu);
		mainmenu.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.setBounds(400, 325, 150, 50);
		add(exit);
		exit.addActionListener(this);
		
		
		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Congratulations();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == statistics) {
			System.out.println("statistics");
			// if statistics is pressed, we show the statistics frame
		}
		if (e.getSource() == mainmenu) {
			System.out.println("main menu");
			// if back is pressed, we go back to the main menu by calling it
		}
		if (e.getSource() == exit) {
			System.out.println("exit");
			// if exit is pressed, we terminate the program
			System.exit(0);
		}
	}
}
