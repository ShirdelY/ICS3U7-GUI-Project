import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener{
    //declare variables
    private int row = 0, column = 0;
    private int letterWidth = 0, spaceWidth = 0;
    private char[][] grid;
    private char[] keyword;
    private int index_row = 0, index_column = 0;
    private String[] keys;
    JLabel[][] labelArray;

    /**
     * Generate game window for wordle
     * @param key selected keyword for user to guess
     * @param keys array of all keywords for given difficulty - to verify if entries are valid
     * @param difficulty 0 for easy, 1 for hard
     */
    Game (String key, String[] keys, int difficulty) {
        System.out.println(key);
        //change grid size dependant on difficulty
        if (difficulty == 0)
        {
            column = 5;
            row = 6;
            letterWidth = 84;
            spaceWidth = 20;
            keyword = new char[column];
            grid = new char[row][column];
        }
        else if (difficulty == 1)
        {
            column = 7;
            row = 6;
            letterWidth = 60;
            spaceWidth = 16;
            keyword = new char[column];
            grid = new char[row][column];
        }
        //create character array from String keyword
        for (int i = 0; i < key.length(); i++)
            keyword[i] = key.charAt(i);
        //import keyword source parameters
        this.keys = keys;
        //create JFrame
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1200,1000);
        this.addKeyListener(this);
        //initialize gameboard with spaces
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                grid[i][j] = ' ';
            }
        }
        //create grid of jlabels
        labelArray = new JLabel[row][column];
        //initial grid corner
        int xcoord = 50, ycoord = 50;
        //initialize array as blank
        for (int j = 0; j < row; j++)
        {
            for (int i = 0; i < column; i++)
            {
                labelArray[j][i] = new JLabel(" ", SwingConstants.CENTER);
                labelArray[j][i].setBackground(Color.GRAY);
                labelArray[j][i].setOpaque(true);
                labelArray[j][i].setBounds(xcoord, ycoord, letterWidth, 80);
                this.add(labelArray[j][i]);
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
        //check if input is a letter
        if (String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) >= 65 && String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) <= 90)
        {
            if (index_column < column)
            {
                //add input letter to grid as uppercase
                grid[index_row][index_column] = String.valueOf(e.getKeyChar()).toUpperCase().charAt(0);
                index_column++;
            }
        }
        //check if input was a backspace
        else if (e.getKeyChar() == 8)
        {
            //makesure index will not go negative
            if (index_column > 0)
            {
                index_column--;
                //change letter to space to make it "blank"
                grid[index_row][index_column] = ' ';
            }
        }
        //check if enter key is pressed
        else if (e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            //check if guess is the correct length
            if (index_column == row)
            {
                System.out.println(String.valueOf())
                for (int i = 0; i < )
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
