import javax.swing.*;
import java.awt.*;

public class EasyMode extends JFrame {
    private char[][] grid = new char[5][6];
    private char[] key = new char[5];
    EasyMode (String key) {
        for (int i = 0; i < 5; i++) this.key[i] = key.charAt(i);
        JFrame frame = new JFrame();
        frame.setLayout(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600,650);
    }
}
