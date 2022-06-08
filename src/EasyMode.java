import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class EasyMode extends JFrame implements KeyListener{
    private char[][] grid = new char[5][6];
    private char[] keyword = new char[5];
    private int index_x = 0, index_y = 0;
    EasyMode (String key) {
        char input;
        for (int i = 0; i < 5; i++) keyword[i] = key.charAt(i);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(600,650);
        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
        if (String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) >= 65 && String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) <= 90)
        {
            if (index_x <= 4)
            {
                grid[index_x][index_y] = e.getKeyChar();
                index_x++;
            }
        }
        else if (String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) == 8)
        {
            index_x--;
            //set character to space so that it is "blank"
            grid[index_x][index_y] = 32;
        }
        else if (String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) == 13)
        {
            for (int i = 0; i < 586; i++)
            {
                if (String.valueOf(grid[0][index_y] + grid[1][index_y] + grid[2][index_y] + grid[3][index_y] + grid[4][index_y]).equals())
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
