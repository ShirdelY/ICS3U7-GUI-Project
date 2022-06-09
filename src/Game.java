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
            grid = new char[X][Y];
            keysLength = X;
        }
        else if (difficulty == 1)
        {
            X = 7;
            Y = 6;
            letterWidth = 60;
            spaceWidth = 16;
            keyword = new char[X];
            grid = new char[X][Y];
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
        for (int i = 0; i < X; i++)
        {
            for (int j = 0; j < Y; j++)
            {
                grid[i][j] = ' ';
            }
        }
        //create grid of jlabels
        labelArray = new JLabel[X][Y];
        //initial grid corner
        int xcoord = 50, ycoord = 50;
        //initialize array as blank
        for (int j = 0; j < Y; j++)
        {
            for (int i = 0; i < X; i++)
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
        //check if character typed is a letter
        if (String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) >= 65 && String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) <= 90) {
            //check if
            if (index_x < X) {
                //add letter to game board
                grid[index_x][index_y] = String.valueOf(e.getKeyChar()).toUpperCase().charAt(0);
                labelArray[index_x][index_y].setText(String.valueOf(e.getKeyChar()).toUpperCase());
                index_x++;
            }
        } else if (String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) == 8) {

            //set character to space so that it is "blank"
            if (index_x > 0)
                index_x--;
            for (int i = 0; i < X; i++)
                labelArray[i][index_y].setBackground(Color.GRAY);
            grid[index_x][index_y] = 32;
            labelArray[index_x][index_y].setText(String.valueOf(grid[index_x][index_y]));

        }
        else if (e.getKeyChar() == 91 )
        {
            for (int i = 0; i < keys.length; i++) {
                //diagnostic tool
                System.out.println((String.valueOf(grid[0][index_y] ) + String.valueOf(grid[1][index_y] ) + String.valueOf(grid[2][index_y] ) + String.valueOf(grid[3][index_y] ) + String.valueOf(grid[4][index_y] )));

                if ((String.valueOf(grid[0][index_y] ) + String.valueOf(grid[1][index_y] ) + String.valueOf(grid[2][index_y] ) + String.valueOf(grid[3][index_y] ) + String.valueOf(grid[4][index_y] )).toUpperCase().equals(keys[i].toUpperCase()))
                {
                    //display yellow/green depending on if the letter is used in the keyword
                    index_x = 0;
                    for (int x = 0; x < X; x++)
                    {
                        for (int y = 0; y < X; y++)
                        {
                            if (grid[x][index_y] == keyword[y])
                            {
                                labelArray[x][index_y].setBackground(Color.ORANGE);
                            }
                        }
                    }
                    for (int j = 0; j < X; j++)
                    {
                        if (grid[j][index_y] == keyword[j])
                            labelArray[j][index_y].setBackground(Color.GREEN);
                    }
                    repaint();

                    for (int j = 0; j < X; j++)
                    {
                        if (grid[j][index_y] != keyword[j]) {
                            break;
                        }
                            //dispose();
                            //new Congratulations();
                    }
                    index_y++;
                    break;
                }
            }
        }
    }
}
