import java.io.*;
public class Statistics {
    private final BufferedWriter writer;
    private final BufferedReader reader;
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
			}
		}
    }

    public void writeGame(boolean win, int guess, String key) throws IOException
    {
    	// time is a functionality we can add at the end, but we would need to start counting as soon as easy mode is pressed and then subract with currents
        writer.write(Main.getUser() + " " + win + " " + guess + " " + key);
        writer.newLine();
        writer.close();
        total_games_played++;
        if (win)
            total_games_won++;
        prob_win = total_games_won / total_games_played;
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
    public String getCurrentUser() {
    	return this.current_user;
    }
}
