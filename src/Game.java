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
    boolean valid = false;

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
            letterWidth = 42;
            spaceWidth = 10;
            keyword = new char[column];
            grid = new char[row][column];
        }
        else if (difficulty == 1)
        {
            column = 7;
            row = 6;
            letterWidth = 30;
            spaceWidth = 8;
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
        this.setSize(600,650);
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
                //add new jlabel for grid sector
                labelArray[j][i] = new JLabel(" ", SwingConstants.CENTER);
                labelArray[j][i].setBackground(Color.GRAY);
                labelArray[j][i].setOpaque(true);
                labelArray[j][i].setBounds(xcoord, ycoord, letterWidth, 80);
                this.add(labelArray[j][i]);
                //increment next space
                xcoord += (letterWidth + spaceWidth);
            }
            //increment y coordinate to next row
            ycoord += 105;
            //reset the column coordinate
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
                labelArray[index_row][index_column].setText(String.valueOf(grid[index_row][index_column]));
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
                labelArray[index_row][index_column].setText(String.valueOf(grid[index_row][index_column]));
            }
        }
        //check if enter key is pressed

        //ADD ONSCREEN KEYBOARD
        if (e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            //check if guess is the correct length
            if (index_column == row)
            {
                //diagnostic tool
                for (int x = 0; x < column; x++)
                {
                    System.out.print(String.valueOf(grid[index_row][x]).charAt(0));
                }
                System.out.println();
                for (String key : keys) {
                    for (int j = 0; j < column; j++) {
                        valid = true;
                        if (grid[index_row][j] != key.charAt(j)) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid)
                        break;
                }
                if (valid)
                {
                    //check for yellow letters
                    for (int i = 0; i < column; i++)
                    {
                        for (int j = 0; j < column; j++)
                        {
                            if (grid[index_row][i] == keyword[j])
                            {
                                labelArray[index_row][i].setBackground(Color.ORANGE);
                                break;
                            }
                        }
                    }
                    //check for green letters
                    for (int i = 0; i < column; i++)
                    {
                        if (grid[index_row][i] == keyword[i])
                            labelArray[index_row][i].setBackground(Color.GREEN);
                    }
                    repaint();
                    index_row++;
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
