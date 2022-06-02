import javax.swing.*;
import java.awt.*;

public class EasyMode extends Main {
    private char[][] grid = new char[5][6];
    private char[] key = new char[5];
    JPanel panel2 = new JPanel();
    EasyMode(char[] key)
    {
        this.key = key;
        //JPanel panel = new JPanel();
        panel2.setBounds(50,50, 500, 500);
        panel2.setBackground(Color.YELLOW);
        frame.add(panel2);
    }
}
