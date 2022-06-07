import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class EasyMode extends JFrame {
    private char[][] grid = new char[5][6];
    private char[] keyword = new char[5];
    JFrame frame = new JFrame();
    EasyMode (String key) {
        char input;
        for (int i = 0; i < 5; i++) keyword[i] = key.charAt(i);
        frame.setLayout(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600,650);
        frame.addKeyListener();
    }
}
