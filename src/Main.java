/**
 * Main.java - version 3 
 * This class shows the main menu and its different buttons
 * @author Shiza and Shirdel
 */
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends JFrame {
	//source files for key words
	final private static File SOURCE5 = new File("5LetterKeyWords.txt");
	final private static File SOURCE7 = new File("7LetterKeyWords.txt");
	//source file lengths
	final private static int FIVELENGTH = 586;
	final private static int SEVENLENGTH = 500;
	//create arrays for words
	private static String[] words5 = new String[586];
	private static String[] words7 = new String[500];
	public final static File STATSFILE = new File("GameLog.txt");
	public static Statistics stats;
	private static String user = "default";

	/**
	 * main method to start the game
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
			//import keywords
			words5 = importWords5();
			words7 = importWords7();
			//create new title screen
			new Start();
	}

	/**
	 * method for creating an instance of the Statistics class
	 * @param - none
	 * @return - none
	 */
	public static void makeStats()
	{
		//create statistics writers
		try
		{
			stats = new Statistics(STATSFILE);
		}
		catch (Exception IO)
		{
			System.out.println("Statistics creation error");
		}
	}
	
	/**
	 * imports possible 5 letter guesses from txt file
	 * @return array of possible guesses
	 * @throws IOException
	 */
	public static String[] importWords5() throws IOException {
		//create temporary non final arrays to fill
		String[] words5temp = new String[FIVELENGTH];
		//create scanners to import txt files to arrays
		Scanner fiveInput = new Scanner(SOURCE5);
		//import txt files
		for (int i = 0; i < FIVELENGTH; i++)
		{
			words5temp[i] = fiveInput.nextLine();
		}
		return words5temp;
	}

	/**
	 * import 7 letter keywords from txt files
	 * @return array of keywords
	 * @throws IOException
	 */
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
	 * @param - none
	 * @return array of five letter keywords
	 */
	public static String[] getFive()
	{
		return words5;
	}
	
	/**
	 * getter method for "hard" (7 letter) keywords
	 * @param - none
	 * @return array of seven letter keywords
	 */
	public static String[] getSeven()
	{
		return words7;
	}

	/**
	 * getter method for Statistics class instance
	 * @param - none
	 * @return Statistics class instance
	 */
	public static Statistics getStats()
	{
		return stats;
	}

	/**
	 * setter method for current username in use
	 * @param u - username made with the AddAccount class
	 * @return - none
	 */
	public static void setUser(String u)
	{
		user = u;
	}

	/**
	 * getter method for current username in use
	 * @param - none
	 * @return String - username
	 */
	public static String getUser()
	{
		return user;
	}
}