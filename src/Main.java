import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends JFrame {
	//source files for key words
	final private static File SOURCE5 = new File("src/5LetterKeyWords.txt");
	final private static File SOURCE7 = new File("src/7LetterKeyWords.txt");
	//source file lengths
	final private static int FIVELENGTH = 586;
	final private static int SEVENLENGTH = 500;
	//create arrays for words
	private static String[] WORDS5 = new String[586];
	private static String[] WORDS7 = new String[500];

	public static void main(String[] args) throws IOException{
		//import keywords
		WORDS5 = importWords5();
		WORDS7 = importWords7();
		//create new title screen
		new Start();
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

	/**
	 * getter method for "easy" (5 letter) keywords
	 * @return array of five letter keywords
	 */
	public String[] getFive()
	{
		return WORDS5;
	}

	/**
	 * getter method for number of "easy" (5 letter) keywords
	 * @return length of keyword array
	 */
	public int getFivelength()
	{
		return FIVELENGTH;
	}

	/**
	 * getter method for "hard" (7 letter) keywords
	 * @return array of seven letter keywords
	 */
	public String[] getSeven()
	{
		return WORDS7;
	}

	/**
	 * getter method for number of "easy" (5 letter) keywords
	 * @return length of keyword array
	 */
	public int getSevenLength()
	{
		return SEVENLENGTH;
	}
}