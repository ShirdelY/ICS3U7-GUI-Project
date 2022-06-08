import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends JFrame {
	public static JFrame frame = new JFrame();
	//source files for key words
	final static File SOURCE5 = new File("src\\5LetterKeyWords.txt");
	final static File SOURCE7 = new File("src\\\\7LetterKeyWords.txt");
	//source file lengths
	final static int FIVELENGTH = 586;
	final static int SEVENLENGTH = 500;
	//create arrays for words
	static String[] WORDS5 = new String[586];
	static String[] WORDS7 = new String[500];

	public Main() {
	}

	public static void main(String[] args) throws IOException{
		//import keywords
		WORDS5 = importWords5();
		WORDS7 = importWords7();
		//create frame and set parameters
		makeFrame();
		//create title screen
		titleScreen();
		//import keywords
	}

	public static String[] importWords5() throws IOException {
		//create temporary non final arrays to fill
		String[] words5temp = new String[FIVELENGTH];
		String[] words7temp = new String[SEVENLENGTH];
		//create scanners to import txt files to arrays
		Scanner fiveInput = new Scanner(SOURCE5);
		Scanner sevenInput = new Scanner(SOURCE7);
		//import txt files
		for (int i = 0; i < FIVELENGTH; i++)
		{
			words5temp[i] = fiveInput.nextLine();
		}
		return words5temp;
	}

	public static String[] importWords7() throws IOException {
		//create temporary non final arrays to fill
		String[] words7temp = new String[SEVENLENGTH];
		//create scanners to import txt files to arrays
		Scanner sevenInput = new Scanner(SOURCE7);
		//import txt files
		for (int i = 0; i < SEVENLENGTH; i++)
		{
			words7temp[i] = sevenInput.nextLine();
		}
		return words7temp;
	}
	public static void makeFrame()
	{
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(600,650);
	}
	static void titleScreen()
	{
		//create main menu button
		JButton mainMenu2 = new JButton("Main Menu");
		mainMenu2.setBounds(200, 500, 200, 50);
		mainMenu2.setBackground(Color.GRAY);
		frame.add(mainMenu2);
		//add action for main menu
		mainMenu2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				//clear the screen
				frame.getContentPane().removeAll();
				frame.repaint();
				//open main menu
				mainMenu();
			}
		});
	}

	static void mainMenu()
	{
		//create panel for buttons
		JPanel panel = new JPanel();
		panel.setBounds(50,50, 500, 500);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.add(panel);

		//add option for easy mode
		JButton easy = new JButton("Easy Mode");
		easy.setBounds(100,100, 400, 50);
		easy.setBackground(Color.GRAY);
		frame.add(easy);

		//add action for easy mode
		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the easy class with wordfive as the key
				new EasyMode(WORDS5[(int) Math.random() * FIVELENGTH]);
			}
		});

		//add option for tutorial
		JButton tutorial = new JButton("Tutorial");
		tutorial.setBounds(100,200, 400, 50);
		tutorial.setBackground(Color.GRAY);
		frame.add(tutorial);

		tutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					new Instructions();
				}
				catch (Exception IO)
				{
					System.out.println("error");
				}
			}
		});
	}
}