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

public class Instructions extends JFrame {
	JButton mainmenu;
	Instructions() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JLabel label1 = new JLabel("INSTRUCTIONS:"); //center this after
		label1.setBounds(250, 35, 100, 50);
		add(label1);
		
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(250, 525, 100, 50);
		add(mainmenu);
//		mainmenu.addActionListener(this);
		
		ImageIcon pic = new ImageIcon(getClass().getResource("/Images/Instructions.jpg"));
		JLabel displayField = new JLabel();
		displayField.setIcon(pic);
		displayField.setBounds(10, 100, 580, 390);
		add(displayField);
		
		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Instructions();
	}
}
