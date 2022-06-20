import java.util.Scanner;
import java.io.*;
public class Statistics {
    private BufferedWriter writer;
    private BufferedReader reader;
    public Statistics(File file) throws IOException
    {
        FileWriter Fwriter = new FileWriter(file, true);
        writer = new BufferedWriter(Fwriter);
        FileReader Freader = new FileReader(file);
        reader = new BufferedReader(Freader);
    }

    public void writeGame(String user, boolean win, int guess, String key) throws IOException
    {
    	// time is a functionality we can add at the end, but we would need to start counting as soon as easy mode is pressed and then subract with currents
        writer.write(user + " " + win + " " + guess + " " + key);
        writer.newLine();
        writer.close();
    }

//    i dont think we should do this - it will be hard to format + not really a point
//    public String getGames() throws IOException
//    {
//        String result = "", line;
//        while ((line = reader.readLine()) != null)
//            result += line + "\n";
//        return result;
//    }

    public int numGames() throws IOException
    {
        int count = 0;
        while (reader.readLine() != null)
            count++;
        return count;
    }
}
