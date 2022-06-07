import java.io.*;
import java.util.*;
public class Generator  {
    private String[] words;
    Generator(String[] words){
        this.words = words;
    }
    String getRandom() {
        return words[(int) Math.random() * words.length];
    }
}
