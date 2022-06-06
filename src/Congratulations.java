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
	JButton back, exit;
	Congratulations() {
		// back brings it to main menu
		// exit terminates the program

		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JLabel label1 = new JLabel("CONGRATULATIONS!!! YOU GOT THE WORD"); //center this after
		label1.setBounds(150, 200, 400, 50);
		add(label1);
		
		back = new JButton("Back");
		back.setBounds(175, 325, 100, 50);
		add(back);
		back.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.setBounds(325, 325, 100, 50);
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
		if (e.getSource() == back) {
			System.out.println("back");
			// if back is pressed, we go back to the main menu by calling it
		}
		if (e.getSource() == exit) {
			System.out.println("exit");
			// if back is pressed, we go back to the main menu by calling it
			System.exit(0);
		}
	}
}
