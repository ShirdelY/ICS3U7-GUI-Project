import java.util.Scanner;
import java.io.*;
public class Statistics {
    private BufferedWriter writer;
    private BufferedReader reader;
    public Statistics(File file) throws IOException
    {
        FileWriter Fwriter = new FileWriter(file);
        writer = new BufferedWriter(Fwriter);
        FileReader Freader = new FileReader(file);
        reader = new BufferedReader(Freader);
    }

    public void writeGame(boolean win, int guess, String key) throws IOException
    {
        writer.write(System.currentTimeMillis() + " " + win + " " + guess + " " + key);
        writer.newLine();
        writer.close();
    }

    public String getGames() throws IOException
    {
        String result = "", line;
        while ((line = reader.readLine()) != null)
            result += line + "\n";
        return result;
    }

    public int numGames() throws IOException
    {
        int count = 0;
        while (reader.readLine() != null)
            count++;
        return count;
    }
}
