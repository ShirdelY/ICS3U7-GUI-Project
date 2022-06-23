/**
 * Main.java - version 2
 * This class shows the main menu and its different buttons
 * @author Shiza and Shirdel
 */
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends JFrame {
	//source files for key words
	final private static File SOURCE5 = new File("src/5LetterKeyWords.txt");
	final private static File VALIDSOURCE5 = new File("src/5LetterValidWords.txt");
	final private static File SOURCE7 = new File("src/7LetterKeyWords.txt");
	//source file lengths
	final private static int FIVELENGTH = 586;
	final private static int VALIDFIVELENGTH = 12972;
	final private static int SEVENLENGTH = 500;
	//create arrays for words
	private static String[] words5 = new String[586];
	private static String[] validwords5 = new String[12972];
	private static String[] words7 = new String[500];
	public final static File STATSFILE = new File("GameLog.txt");
	public static Statistics stats;
	private static String user = "default";

	public static void main(String[] args) throws IOException{
		//import keywords
		words5 = importWords5();
		validwords5 = importValidWords5();
		words7 = importWords7();
		//create new title screen
		new Start();
	}

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
	 * imports possible 5 letter keywords
	 * @return array of possible keywords
	 * @throws IOException
	 */
	public static String[] importValidWords5() throws IOException {
		//create temporary non final arrays to fill
		String[] validwords5temp = new String[VALIDFIVELENGTH];
		//create scanners to import txt files to arrays
		Scanner validFiveInput = new Scanner(VALIDSOURCE5);
		//import txt files
		for (int i = 0; i < VALIDFIVELENGTH; i++)
		{
			validwords5temp[i] = validFiveInput.nextLine();
		}
		return validwords5temp;
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
	 * @return array of five letter keywords
	 */
	public static String[] getFive()
	{
		return words5;
	}

	/**
	 * getter method for "easy" (5 letter) words that are valid to guess
	 * @return array of five letter valid words
	 */
	public static String[] getValidFive() 
	{
		return validwords5;
	}
	
	/**
	 * getter method for "hard" (7 letter) keywords
	 * @return array of seven letter keywords
	 */
	public static String[] getSeven()
	{
		return words7;
	}
	public static Statistics getStats()
	{
		return stats;
	}

	public static void setUser(String u)
	{
		user = u;
	}

	public static String getUser()
	{
		return user;
	}
}