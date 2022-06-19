/**
 * Game.java - version 2
 * This class compares the guesses that the user enters to the answer - for both easy and hard mode
 * @author Shiza and Shirdel
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Game extends JFrame implements KeyListener, ActionListener {
	//declare variables
	// private instance variables for keeping track of the amount of rows and columns needed in the grid (depends on difficulty level)
	private int row = 0, column = 0;
	// private instance variables to format the grid properly
	private int letterWidth = 0, spaceWidth = 0;
	// private instance variable of a 2D array for the grid
	private char[][] grid;
	// private instance variable - 1D array to store the characters of the word selected for the user to guess
	private char[] keyword;
	// private instance variable - indices to keep track of values in the grid
	private int index_row = 0, index_column = 0;
	// private instance variable - all the valid keywords a user can guess
	private String[] keys;
	// private instance variable - keeping track of the user's guesses
	private int guess_num = 1;
	// JLabel 2D array for keeping track of the letters in the grid
	private JLabel[][] labelArray;
	// boolean to check if the word is valid or not
	private boolean valid = false;
	// the corner to start the grid (for both X and Y)
	private int startcorner;
	// Strings - guess for the user's guess and keyString for the word selected for the user to guess
	String guess, keyString;
	// constant variable to format the buttons of the on-screen keyboard
	private final int BUTTON_WIDTH = 30, BUTTON_SPACE = 5, BUTTON_HEIGHT = 50;
	// integer variables to keep track of the x and y coordinates of the keyboard's key's top corner 
	private int keyboard_x = 128, keyboard_y = 425;
	// final integer variable to reset column coordinate
	private final int KEY_START_X = 128;
	// declaring colors used in the game
	private final Color GREEN = new Color(83, 141, 78), YELLOW = new Color(181, 159, 59);
	Statistics stats;
	/**
	 * Generate game window for wordle
	 * @param key selected keyword for user to guess
	 * @param keys array of all keywords for given difficulty - to verify if entries are valid
	 * @param difficulty 0 for easy, 1 for hard
	 */
	Game (String key, String[] keys, int difficulty, Statistics stats) {
		System.out.println(key);
		//change grid size dependant on difficulty
		//if easy mode
		if (difficulty == 0)
		{
			column = 5;
			row = 6;
			letterWidth = 50;
			spaceWidth = 10;
			keyword = new char[column];
			grid = new char[row][column];
			startcorner = (600 - (5 * letterWidth + 4 * spaceWidth))/2;
		}
		//if hard mode
		else if (difficulty == 1)
		{
			column = 7;
			row = 6;
			letterWidth = 30;
			spaceWidth = 10;
			keyword = new char[column];
			grid = new char[row][column];
			startcorner = (600 - (7 * letterWidth + 6 * spaceWidth))/2;
		}
		//create character array from String keyword
		for (int i = 0; i < key.length(); i++)
			keyword[i] = key.toUpperCase().charAt(i);
		//import keyword source parameters
		this.keys = keys;
		keyString = key;
		this.stats = stats;
		//create JFrame
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setResizable(false);
		setPreferredSize(new Dimension(600, 650));
		pack();
		//initialize gameboard with spaces
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				grid[i][j] = ' ';
			}
		}
		//create grid of jlabels
		labelArray = new JLabel[row][column];
		//initial grid corner
		int xcoord = startcorner, ycoord = 50;
		//initialize JLabel array as blank
		for (int j = 0; j < row; j++)
		{
			for (int i = 0; i < column; i++)
			{
				//add new JLabel for grid sector
				labelArray[j][i] = new JLabel(" ", SwingConstants.CENTER);
				labelArray[j][i].setBackground(Color.LIGHT_GRAY);
				labelArray[j][i].setOpaque(true);
				labelArray[j][i].setBounds(xcoord, ycoord, letterWidth, 50);
				this.add(labelArray[j][i]);
				//increment next space
				xcoord += (letterWidth + spaceWidth);
			}
			//increment y coordinate to next row
			ycoord += 50 + spaceWidth;
			//reset the column coordinate
			xcoord = startcorner;
		}
		//create keyboard
		makeKeyboard();
		//add keylistener for keyboard input
		addKeyListener(this);
	}

	/**
	 * Create onscreen keyboard
	 * @return - none
	 */
	public void makeKeyboard() {
		//create first row of keys
		JButton[] row1_buttons = new JButton[10];
		final String[] ROW1 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
		//initialize each JButton
		for (int a = 0; a < 10; a++) {
			row1_buttons[a] = new JButton(ROW1[a]);
			//get rid of button border
			row1_buttons[a].setBorder(BorderFactory.createEmptyBorder());
			row1_buttons[a].setBounds(keyboard_x, keyboard_y, BUTTON_WIDTH, BUTTON_HEIGHT);
			row1_buttons[a].setBackground(Color.LIGHT_GRAY);
			//set un-focusable to fix key listener conflict
			row1_buttons[a].setFocusable(false);
			//increment column coordinate to next space
			keyboard_x += BUTTON_WIDTH + BUTTON_SPACE;
			this.add(row1_buttons[a]);
			//add action listener
			row1_buttons[a].addActionListener(this);
		}

		//increment row coordinate to next space
		keyboard_y += BUTTON_HEIGHT + BUTTON_SPACE;
		//reset column coordinate and shift half a space over
		keyboard_x = KEY_START_X + (int) Math.round((double) (BUTTON_WIDTH + BUTTON_SPACE) / 2);

		//create second row of keys
		JButton[] row2_buttons = new JButton[9];
		final String[] ROW2 = {"A", "S", "D", "F", "G", "H", "J", "K", "L"};
		//initialize each JButton
		for (int b = 0; b < 9; b++) {
			row2_buttons[b] = new JButton(ROW2[b]);
			//get rid of button border
			row2_buttons[b].setBorder(BorderFactory.createEmptyBorder());
			row2_buttons[b].setBounds(keyboard_x, keyboard_y, BUTTON_WIDTH, BUTTON_HEIGHT);
			row2_buttons[b].setBackground(Color.LIGHT_GRAY);
			//set un-focusable to fix key listener conflict
			row2_buttons[b].setFocusable(false);
			//increment column coordinate to next space
			keyboard_x += BUTTON_WIDTH + BUTTON_SPACE;
			this.add(row2_buttons[b]);
			//add action listener
			row2_buttons[b].addActionListener(this);
		}

		//increment row coordinate to next space
		keyboard_y += BUTTON_HEIGHT + BUTTON_SPACE;
		//reset column coordinate
		keyboard_x = KEY_START_X;

		//create third row of keys
		JButton[] row3_buttons = new JButton[10];
		final String[] ROW3 = {"Enter", "Z", "X", "C", "V", "B", "N", "M", "Back"};
		//initialize each JButton
		for (int a = 0; a < 9; a++) {
			row3_buttons[a] = new JButton(ROW3[a]);
			//get rid of button border
			row3_buttons[a].setBorder(BorderFactory.createEmptyBorder());
			row3_buttons[a].setBackground(Color.LIGHT_GRAY);
			//set un-focusable to fix key listener conflict
			row3_buttons[a].setFocusable(false);
			//check if button should be back or enter key
			if (a == 0 || a == ROW3.length-1) {
				//make these buttons 1.5 button widths wide
				row3_buttons[a].setBounds(keyboard_x, keyboard_y, BUTTON_WIDTH + (int) Math.round((double) (BUTTON_WIDTH + BUTTON_SPACE) / 2), BUTTON_HEIGHT);
				keyboard_x += BUTTON_WIDTH + (int) Math.round((double) (BUTTON_WIDTH + BUTTON_SPACE) / 2) + BUTTON_SPACE;
				this.add(row3_buttons[a]);
			}
			else {
				//make these buttons regular size
				row3_buttons[a].setBounds(keyboard_x, keyboard_y, BUTTON_WIDTH, BUTTON_HEIGHT);
				keyboard_x += BUTTON_WIDTH + BUTTON_SPACE;
				this.add(row3_buttons[a]);
			}
			//add action listener
			row3_buttons[a].addActionListener(this);
		}
	}

	/**
	 * actionPerformed method to manipulate and set specific instructions for the buttons on the on-screen keyboard
	 * @param ActionEvent object
	 * @return - none
	 */
	public void actionPerformed(ActionEvent e)
	{
		// checking which letter on the on-screen keyboard the user pressed - from "A" to "Z" and "Enter" and "Back
		try
		{
			switch (e.getActionCommand()) {
				case ("A") -> gameUpdate('A');
				case ("B") -> gameUpdate('B');
				case ("C") -> gameUpdate('C');
				case ("D") -> gameUpdate('D');
				case ("E") -> gameUpdate('E');
				case ("F") -> gameUpdate('F');
				case ("G") -> gameUpdate('G');
				case ("H") -> gameUpdate('H');
				case ("I") -> gameUpdate('I');
				case ("J") -> gameUpdate('J');
				case ("K") -> gameUpdate('K');
				case ("L") -> gameUpdate('L');
				case ("M") -> gameUpdate('M');
				case ("N") -> gameUpdate('N');
				case ("O") -> gameUpdate('O');
				case ("P") -> gameUpdate('P');
				case ("Q") -> gameUpdate('Q');
				case ("R") -> gameUpdate('R');
				case ("S") -> gameUpdate('S');
				case ("T") -> gameUpdate('T');
				case ("U") -> gameUpdate('U');
				case ("V") -> gameUpdate('V');
				case ("W") -> gameUpdate('W');
				case ("X") -> gameUpdate('X');
				case ("Y") -> gameUpdate('Y');
				case ("Z") -> gameUpdate('Z');
				case ("Enter") -> gameUpdate((char) 10);
				case ("Back") -> gameUpdate((char) 8);
			}
		}
		catch (Exception IO)
		{
			System.out.println("error");
		}

	}
	/**
	 * Updates the grid with labels of the user's guess
	 * @param in - takes in the letters of the guess - wither typed by the user or from the on-screen keyboard
	 * @return - none
	 */
	public void gameUpdate(char in) throws IOException
	{
		if (String.valueOf(in).toUpperCase().charAt(0) >= 'A' && String.valueOf(in).toUpperCase().charAt(0) <= 'Z')
		{
			if (index_column < column)
			{
				//add input letter to grid as uppercase
				grid[index_row][index_column] = String.valueOf(in).toUpperCase().charAt(0);
				labelArray[index_row][index_column].setText(String.valueOf(grid[index_row][index_column]));
				labelArray[index_row][index_column].setBackground(Color.GRAY);
				labelArray[index_row][index_column].setForeground(Color.WHITE);
				index_column++;
			}
		}
		//check if input was a backspace
		else if (in == 8)
		{
			if (index_column == column)
			{
				for (int i = 0; i < column; i++)
				{
					labelArray[index_row][i].setBackground(Color.GRAY);
				}
			}
			//make sure index will not go negative
			if (index_column > 0)
			{
				index_column--;
				//change letter to space to make it "blank"
				grid[index_row][index_column] = ' ';
				labelArray[index_row][index_column].setText(String.valueOf(grid[index_row][index_column]));
				labelArray[index_row][index_column].setBackground(Color.LIGHT_GRAY);
			}
		}
		//check if enter key is pressed
		else if (in == 10) {
			if (guess_num <= 6) {
				//check if guess is the correct length
				//make sure there are guess remaining
				if (index_column == column) {
					//convert the guess input into a string
					guess = "";
					for (int i = 0; i < column; i++)
						guess += String.valueOf(grid[index_row][i]);
					//check if the guess is a valid keyword
					valid = false;
					for (int j = 0; j < keys.length; j++) {
						if (keys[j].toUpperCase().equals(guess)) {
							valid = true;
							break;
						}
					}
					//guess is a word, proceed
					if (valid) {
						// add the number of guesses the user has had
						guess_num++;
						// if the user guessed the word, direct to the Congratulations screen
						if (keyString.toUpperCase().equals(guess)) {
							new Congratulations();
							stats.writeGame(true, guess_num, keyString);
							dispose();
						}
						//check for letters to see if they are used in the keyword
						//if so, change background to yellow
						for (int i = 0; i < column; i++) {
							for (int j = 0; j < column; j++) {
								if (grid[index_row][i] == keyword[j]) {
									//orange looks better than default yellow
									labelArray[index_row][i].setBackground(YELLOW);
								}
							}
						}
						//check for letters that are in the same position as the keyword
						//if so, set background to green - overrides the yellow
						for (int i = 0; i < column; i++) {
							if (grid[index_row][i] == keyword[i])
								labelArray[index_row][i].setBackground(GREEN);
						}
						//reload screen
						repaint();
						//move to next row for next guess
						index_row++;
						//reset column index back to start
						index_column = 0;
					}
					//guess is not a word, turn boxes red to indicate such
					else {
						for (int i = 0; i < column; i++)
							labelArray[index_row][i].setBackground(Color.RED);
					}

					//if the user didn't guess it in 6 tries, direct to the Loser screen
					if (guess_num == 6 && (!keyString.toUpperCase().equals(guess))) {
						new Loser(keyString);
						stats.writeGame(false, 6, keyString);
						dispose();
					}
				}
				repaint();
			} 
		}
	}
	/**
	 * key typed validation for entries
	 * @param e - key typed
	 * @return - none
	 */
	@Override
	public void keyTyped(KeyEvent e){
		try
		{
			gameUpdate(e.getKeyChar());
		}
		catch (Exception IO)
		{
			System.out.println("error");
		}
	}
	/**
	 * keyPressed -  not used but needed for keyTyped to restrict errors
	 * @param e - key typed
	 * @return - none
	 */
	public void keyPressed(KeyEvent e) {

	}
	/**
	 * keyReleased -  not used but needed for keyTyped to restrict errors
	 * @param e - key typed
	 * @return - none
	 */
	public void keyReleased(KeyEvent e) {
	}
}