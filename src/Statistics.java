/**
 * Statistics.java - version 3  
 * This class displays the credits/citations we used in APA format
 * @author Shiza and Shirdel
 */
import java.io.*;

public class Statistics {
	// Buffer reader and writer for reading and writing to the statistics text file
    private BufferedWriter writer;
    private BufferedReader reader;
    // variables for storing statistics
    private int total_games_played = 0;
	private int total_games_won = 0;
	private double prob_win;
	// input from reading the statistics
	private String input;
	// variable for storing current user
	private String current_user;
	
	/**
	 * Constructor (special method) for going through the user's information in the text file and updating their statistics
	 * @param file - the text file with all the users' statistics
	 * @return - none
	 */
    public Statistics(File file)
    {
    	try {
    		// file writer and reader
            FileWriter Fwriter = new FileWriter(file, true);
            writer = new BufferedWriter(Fwriter);
            FileReader Freader = new FileReader(file);
            reader = new BufferedReader(Freader);
            // getting the current user and storing it in the variable
            current_user = Main.getUser();
            // going through each line in the statistics file
            while ((input = reader.readLine()) != null) {
            	// getting the statistics for a certain user in the line of the statistics
    			String[] usergame_database = input.split(" ");
    			String correct_username = usergame_database[0];
    			String won = usergame_database[1];
    			// if the username is the same as the username in the database
    			if (current_user.equals(correct_username)) {
    				// update statistics
    				this.total_games_played++;
    				if (won.equals("true")) {
    					this.total_games_won++;
    				}
    			}
    		}
    	}
    	catch (IOException e) {
    		System.out.println("Error reading file");
    	}
    }

    /**
     * writeGame method to write information to the textfile for the statistics
     * @param win - boolean to store if the user won the game or not
     * @param guess - number of guesses the user took
     * @param key - the computer-generated answer of that guessing round
     * @return - none
     */
    public void writeGame(boolean win, int guess, String key)
    {
    	try {
    		// write to text file
            writer.write(Main.getUser() + " " + win + " " + guess + " " + key);
            writer.newLine();
            total_games_played++;
            if (win)
                total_games_won++;
    	}
    	catch (IOException e) {
    		System.out.println("Error reading file");
    	}
    }

    /**
     * CloseStats method to close statistics method to write information to the text file for the statistics
     * @param - none
     * @return - none
     */
    public void closeStats()
    {
    	try {
    		 writer.close();
    	}
    	catch (IOException e) {
    		System.out.println("Error reading file");
    	}
    }

    /**
     * getTotalGamesPlayed method to get the total number of games that the user played
     * @param - none
     * @return int - integer for total games played
     */
    public int getTotalGamesPlayed() {
    	return this.total_games_played;
    }
    
    /**
     * getTotalGamesWon method to get the total number of games that the user won
     * @param - none
     * @return int - integer for total games won
     */
    public int getTotalGamesWon() {
    	return this.total_games_won;
    }
    
    /**
     * getProbWin method to get the percentage of games that the user won
     * @param - none
     * @return int - String (converted from double) of total games won/total games played by user
     */
    public String getProbWin() {
        if (total_games_played > 0)
            return String.valueOf(((double) total_games_won/total_games_played) * 100).substring(0,3);
        return "0.0";
    }
}
