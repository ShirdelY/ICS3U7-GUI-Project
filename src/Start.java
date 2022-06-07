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

public class Start extends JFrame implements ActionListener {
	JButton mainmenu;
	Start() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		JLabel label1 = new JLabel("HELLO WORDL"); //center this after
		label1.setBounds(250, 35, 100, 50);
		add(label1);
		
		mainmenu = new JButton("Main Menu");
		mainmenu.setBounds(200, 475, 200, 75);
		add(mainmenu);
		mainmenu.addActionListener(this);
		
		pack();
		setSize(600,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == mainmenu) {
			System.out.println("main menu");
			// if main menu is pressed, we go to the main menu by calling it
		}
	}
}
