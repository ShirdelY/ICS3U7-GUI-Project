/**
 * 
 * @author shizacharania
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Credits extends JFrame implements ActionListener {
	JButton back;
	String citations = "";
	Credits() {
		setLayout(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JLabel label1 = new JLabel("CREDITS"); //center this after
		label1.setBounds(250, 35, 100, 50);
		add(label1);
		
		JLabel credit = new JLabel(citations);
		credit.setBounds(250, 100, 100, 50);
		
		back = new JButton("Back");
		back.setBounds(250, 500, 100, 50);
		add(back);
		back.addActionListener(this);
		
		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Credits();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			System.out.println("back");
			// if back is pressed, we go back to the main menu by calling it
		}
	}
}
