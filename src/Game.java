import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener{
    //declare variables
    private int X = 0, Y = 0;
    private int letterWidth = 0, spaceWidth = 0;
    private char[][] grid;
    private char[] keyword;
    private int index_x = 0, index_y = 0, keysLength;
    private String[] keys;
    JLabel[][] labelArray;

    /**
     * Generate game window for wordle
     * @param key selected keyword for user to guess
     * @param keys array of all keywords for given difficulty - to verify if entries are valid
     * @param keysLength number of keywords in array
     * @param difficulty 0 for easy, 1 for hard
     */
    Game (String key, String[] keys, int keysLength, int difficulty) {
        System.out.println(key);
        //change grid size dependant on difficulty
        if (difficulty == 0)
        {
            X = 5;
            Y = 6;
            letterWidth = 84;
            spaceWidth = 20;
            keyword = new char[X];
            grid = new char[Y][X];
            keysLength = X;
        }
        else if (difficulty == 1)
        {
            X = 7;
            Y = 6;
            letterWidth = 60;
            spaceWidth = 16;
            keyword = new char[X];
            grid = new char[Y][X];
            keysLength = X;
        }
        //create character array from String keyword
        for (int i = 0; i < key.length(); i++) keyword[i] = key.charAt(i);
        //import keyword source parameters
        this.keys = keys;
        this.keysLength = keysLength;
        //create JFrame
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1200,1000);
        this.addKeyListener(this);
        //initialize gameboard with spaces
        for (int i = 0; i < Y; i++)
        {
            for (int j = 0; j < X; j++)
            {
                grid[i][j] = ' ';
            }
        }
        //create grid of jlabels
        labelArray = new JLabel[Y][X];
        //initial grid corner
        int xcoord = 50, ycoord = 50;
        //initialize array as blank
        for (int j = 0; j < X; j++)
        {
            for (int i = 0; i < Y; i++)
            {
                labelArray[i][j] = new JLabel(" ", SwingConstants.CENTER);
                labelArray[i][j].setBackground(Color.GRAY);
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
        
    }

    //not used but needed for "implements keyListener"
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
