import java.io.*;
import java.util.*;
public class Generator  {
    private int length;
    File file5 = new File("5LetterKeyWords.txt");
    Scanner five = new Scanner(file5);
    File file7 = new File("7LetterKeyWords.txt");
    Scanner seven = new Scanner(file7);
    Generator(int length) {
        this.length = length;
    }

    String getRandom() {
        if (length == 5)
        {
            String result;
            //source file for 5 letter words has 586 lines
            //MUST BE UPDATED IF FILE IS CHANGED
            for (int i = 0; i < Math.round(Math.random() * 586); i++)
            {
                result = five.nextLine();
            }
        }
    }
}
