import java.io.*;
import java.util.*;
public class Generator  {
    private int length;
    File file1;
    Generator(int length, String file) throws IOException{
        this.length = length;
        file1 = new File(file);
    }
    Scanner file2 = new Scanner(file1);
    String getRandom() {
        String result = "";
        //source file for 5 letter words has 586 lines
        //MUST BE UPDATED IF FILE IS CHANGED
        for (int i = 0; i < Math.round(Math.random() * 586); i++)
        {
            result = file2.nextLine();
        }
        return result;
    }
}
