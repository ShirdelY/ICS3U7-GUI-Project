import java.io.*;
import java.util.*;
public class Generator  {
    private int length;
    private String[] words;
    Generator(int length, String[] words) throws IOException{
        this.length = length;
        this.words = words;
    }
    String getRandom() {
        return words[(int) Math.random() * words.length];
    }
}
