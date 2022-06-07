import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class EasyMode extends JFrame {
    EasyMode (String key) {
        char[][] grid = new char[5][6];
        char[] keyword = new char[5];
        char input;
        for (int i = 0; i < 5; i++) keyword[i] = key.charAt(i);
        JFrame frame = new JFrame();
        frame.setLayout(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600,650);
        //create scanner for keyboard input
        Scanner keyboard = new Scanner(System.in);
        //listen for input
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 5; j++)
            {
            }
        }
    }
}
