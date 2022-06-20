import java.util.Scanner;
import java.io.*;
public class Statistics {
    private BufferedWriter writer;
    private BufferedReader reader;
    private int total_games_played = 0;
	private int total_games_won = 1;
	private double prob_win = total_games_played/total_games_won;
	private int total_guesses = 0;
	private double avg_guesses_for_wins = total_guesses/total_games_won;
	private String input;
	private String current_user;
	
    public Statistics(File file) throws IOException
    {
        FileWriter Fwriter = new FileWriter(file, true);
        writer = new BufferedWriter(Fwriter);
        FileReader Freader = new FileReader(file);
        reader = new BufferedReader(Freader);
        
        while ((input = reader.readLine()) != null) {
			String[] usergame_database = input.split(" ");
			String correct_username = usergame_database[0];
			String won = usergame_database[1];
			int num_guesses = Integer.parseInt(usergame_database[2]);
			// if the username is the same as the username in the database
			if (current_user.equals(correct_username)) {
				this.total_games_played++;
				if (won.equals("true")) {
					this.total_games_won++;
				}
				else if (won.equals("false")) {
					this.total_games_won++;
				}
				this.total_guesses += num_guesses;
			}
		}
    }

    public void writeGame(String user, boolean win, int guess, String key) throws IOException
    {
    	this.current_user = user;
    	// time is a functionality we can add at the end, but we would need to start counting as soon as easy mode is pressed and then subract with currents
        writer.write(user + " " + win + " " + guess + " " + key);
        writer.newLine();
        writer.close();
    }

    public int getTotalGamesPlayed() {
    	return this.total_games_played;
    }
    public int getTotalGamesWon() {
    	return this.total_games_won;
    }
    public double getProbWin() {
    	return this.prob_win;
    }
    public double getAvgGuesses() {
    	return this.avg_guesses_for_wins;
    }
    public String getCurrentUser() {
    	return this.current_user;
    }

    //    i dont think we should do this - it will be hard to format + not really a point
//    public String getGames() throws IOException
//    {
//        String result = "", line;
//        while ((line = reader.readLine()) != null)
//            result += line + "\n";
//        return result;
//    }
}
