import java.io.*;
public class Statistics {
    private BufferedWriter writer;
    private BufferedReader reader;
    private int total_games_played = 0;
	private int total_games_won = 0;
	private double prob_win;
	private String input;
	private String current_user;
	
    public Statistics(File file) throws IOException
    {
        FileWriter Fwriter = new FileWriter(file, true);
        writer = new BufferedWriter(Fwriter);
        FileReader Freader = new FileReader(file);
        reader = new BufferedReader(Freader);
        current_user = Main.getUser();
        while ((input = reader.readLine()) != null) {
			String[] usergame_database = input.split(" ");
			String correct_username = usergame_database[0];
			String won = usergame_database[1];
			// if the username is the same as the username in the database
			if (current_user.equals(correct_username)) {
				this.total_games_played++;
				if (won.equals("true")) {
					this.total_games_won++;
				}
			}
		}
    }

    /**
     * method to add a new game to GameLog.txt and update all statistics parameters
     * @param win boolean - if game was won (true), if lost (false)
     * @param guess int - how many guesses it took to finish the game
     * @param key String - keyword for game
     * @throws IOException - in case of file IO error
     */
    public void writeGame(boolean win, int guess, String key) throws IOException
    {
    	// time is a functionality we can add at the end, but we would need to start counting as soon as easy mode is pressed and then subract with currents
        writer.write(Main.getUser() + " " + win + " " + guess + " " + key);
        writer.newLine();
        total_games_played++;
        if (win)
            total_games_won++;
    }

    /**
     * method to write data to GameLog.txt when program is closed
     * @throws IOException - in case of file IO error
     */
    public void closeStats() throws IOException
    {
        writer.close();
    }

    /**
     * getter method for total games played
     * @return int - number of games played by current user
     */
    public int getTotalGamesPlayed() {
    	return total_games_played;
    }

    /**
     * getter method for total games won
     * @return int - number of games won by current user
     */
    public int getTotalGamesWon() {
    	return total_games_won;
    }

    /**
     * getter method for win probability
     * @return String - 5 character string of a double representing the ratio between games won and games played
     */
    public String getProbWin() {
        //avoid divide by 0 error if no games played
        if (total_games_played > 0)
            return String.valueOf(((double) total_games_won/total_games_played) * 100).substring(0,5);
        return "0.0";
    }
}
