import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener{
    //declare variables
    private int X = 0, Y = 0;
    private int letterWidth = 0, spaceWidth = 0;
    private char[][] grid = new char[X][Y];
    private char[] keyword = new char[X];
    private int index_x = 0, index_y = 0, keysLength;
    private String[] keys;

    /**
     * Generate game window for wordle
     * @param key selected keyword for user to guess
     * @param keys array of all keywords for given difficulty - to verify if entries are valid
     * @param keysLength number of keywords in array
     * @param difficulty 0 for easy, 1 for hard
     */
    Game (String key, String[] keys, int keysLength, int difficulty) {
        //change grid size dependant on difficulty
        if (difficulty == 0)
        {
            X = 5;
            Y = 6;
            letterWidth = 84;
            spaceWidth = 20;
        }
        else if (difficulty == 1)
        {
            X = 7;
            Y = 6;
            letterWidth = 60;
            spaceWidth = 16;
        }
        //create character array from String keyword
        char input;
        for (int i = 0; i < 5; i++) keyword[i] = key.charAt(i);
        //import keyword source parameters
        this.keys = keys;
        this.keysLength = keysLength;
        //create JFrame
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(600,650);
        this.addKeyListener(this);
        //initialize gameboard with spaces
        for (int i = 0; i < X; i++)
        {
            for (int j = 0; j < Y; j++)
            {
                grid[i][j] = ' ';
            }
        }
        //create grid of jlabels
        JLabel[][] labelArray = new JLabel[X][Y];
        //initial grid corner
        int xcoord = 50, ycoord = 50;
        //initialize array as blank
        for (int i = 0; i < X; i++)
        {
            for (int j = 0; j < Y; j++)
            {
                labelArray[i][j] = new JLabel("test");
                labelArray[i][j].setBackground(Color.BLUE);
                labelArray[i][j].setOpaque(true);
                labelArray[i][j].setBounds(xcoord, ycoord, letterWidth, 80);
                this.add(labelArray[i][j]);
                //increment next space
                xcoord += (letterWidth + spaceWidth);
            }
            ycoord += 105;
            xcoord = 50;
        }
    }

    /**
     * key press validation for entries
     * @param e - key typed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //diagnostic tool
        System.out.println(e.getKeyChar());
        //check if character typed is a letter
        if (String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) >= 65 && String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) <= 90)
        {
            //check if
            if (index_x <= 4)
            {
                //add letter to game board
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
        else if (String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) == 13 && index_x == 5)
        {
            for (int i = 0; i < 586; i++)
            {
                if (String.valueOf(grid[0][index_y] + grid[1][index_y] + grid[2][index_y] + grid[3][index_y] + grid[4][index_y]).equals(keys[i]))
                {
                    //display yellow/green depending on if the letter is used in the keyword
                    index_y++;
                    index_x = 0;
                }
                else
                {
                    //turn all elements red to indicate error
                }
            }
        }
    }

    //not used but needed for "implements keyListener"
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
