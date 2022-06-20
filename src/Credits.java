/**
 * Credits.java - version 2
 * This class displays the credits/citations we used in APA format
 * @author Shiza and Shirdel
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Credits extends JFrame implements ActionListener {
	// declaring button for the back (going to setttings)
	private JButton back;
	private static String current_user;
	/**
	 * Constructor (special method) for the Jframe GUI - specifically showing a title, citations with Jlabels, and 1 button
	 * @param - none
	 * @return - none
	 */
	
	Credits() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// title label
		JLabel label1 = new JLabel("CREDITS"); //center this after
		label1.setBounds(200,0,400,100);
		label1.setFont(new Font("SansSerif", Font.PLAIN, 50));
		add(label1);
		
		// citation 1
		JLabel credit1a = new JLabel("7 letter words: List of 500 common seven letter words in English • 7esl. 7ESL. (2021, June 24). Retrieved June 8, 2022, from https://7esl.com/7-letter-words/");
		credit1a.setBounds(5, -300, 800, 800);
		add(credit1a);
		JLabel credit1b = new JLabel("Retrieved June 8, 2022, from https://7esl.com/7-letter-words/");
		credit1b.setBounds(20, -280, 800, 800);
		add(credit1b);
		
		// citation 2
		JLabel credit2a = new JLabel("Appficial. (2017, October 16). Writing javadoc comments and creating an API with the javadoc tool on Eclipse - Java - Appficial. YouTube.");
		credit2a.setBounds(5, -250, 800, 800);
		add(credit2a);
		JLabel credit2b = new JLabel("Retrieved June 8, 2022, from https://www.youtube.com/watch?v=b8w50JBVIZ4");
		credit2b.setBounds(20, -230, 800, 800);
		add(credit2b);
		
		// citation 3
		JLabel credit3a = new JLabel("Bro Code. (2020, November 9). Java: Reset button for your game 🎮. YouTube.");
		credit3a.setBounds(5, -200, 800, 800);
		add(credit3a);
		JLabel credit3b = new JLabel("Retrieved June 8, 2022, from https://www.youtube.com/watch?v=cA1GvZ5Y3-U");
		credit3b.setBounds(20, -180, 800, 800);
		add(credit3b);
		
		// citation 4
		JLabel credit4a = new JLabel("dracos. (n.d.). Valid-wordle-words.txt. Gist. Retrieved June 15, 2022, from");
		credit4a.setBounds(5, -150, 800, 800);
		add(credit4a);
		JLabel credit4b = new JLabel("https://gist.github.com/dracos/dd0668f281e685bad51479e5acaadb93 ");
		credit4b.setBounds(20, -130, 800, 800);
		add(credit4b);
		
		// citation 5
		JLabel credit5a = new JLabel("Five letter words: 660+ common 5 letter words in English • 7esl. 7ESL. (2021, June 13).");
		credit5a.setBounds(5, -100, 800, 800);
		add(credit5a);
		JLabel credit5b = new JLabel("Retrieved June 8, 2022, from https://7esl.com/5-letter-words/");
		credit5b.setBounds(20, -80, 800, 800);
		add(credit5b);
		
		// citation 6
		JLabel credit6a = new JLabel("Flowchart symbols and notation. Lucidchart. (n.d.).");
		credit6a.setBounds(5, -50, 800, 800);
		add(credit6a);
		JLabel credit6b = new JLabel("Retrieved June 8, 2022, from https://www.lucidchart.com/pages/flowchart-symbols-meaning-explained");
		credit6b.setBounds(20, -30, 800, 800);
		add(credit6b);
		
		// citation 7
		JLabel credit7a = new JLabel("Java programming tutorial. GUI Programming - Java Programming Tutorial. (n.d.).");
		credit7a.setBounds(5, 0, 800, 800);
		add(credit7a);
		JLabel credit7b = new JLabel("Retrieved June 8, 2022, from https://www3.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html");
		credit7b.setBounds(20, 20, 800, 800);
		add(credit7b);
		
		// citation 8
		JLabel credit8a = new JLabel("Java™ Platform, Standard Edition 8 API Specification. Java Platform SE 8. (n.d.).");
		credit8a.setBounds(5, 50, 800, 800);
		add(credit8a);
		JLabel credit8b = new JLabel("Retrieved June 8, 2022, from https://docs.oracle.com/javase/8/docs/api/");
		credit8b.setBounds(20, 70, 800, 800);
		add(credit8b);
		
		// citation 8
		JLabel credit9a = new JLabel("Where developers learn, share, &amp; build careers. Stack Overflow. (n.d.).");
		credit9a.setBounds(5, 100, 800, 800);
		add(credit9a);
		JLabel credit9b = new JLabel("Retrieved June 15, 2022, from https://stackoverflow.com/");
		credit9b.setBounds(20, 120, 800, 800);
		add(credit9b);

		// main menu button
		back = new JButton("Back");
		back.setBounds(200,550,200,50);
		back.setFont(new Font("Monospaced", Font.PLAIN, 20));
		add(back);
		back.addActionListener(this);
		
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
		if (e.getSource() == back) {
			// if back is pressed, we go back to the settings by calling it
			new Settings(current_user);
			dispose();
		}
	}
}
