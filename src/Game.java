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
    int startcorner;

    /**
     * Generate game window for wordle
     * @param key selected keyword for user to guess
     * @param keys array of all keywords for given difficulty - to verify if entries are valid
     * @param difficulty 0 for easy, 1 for hard
     */
    Game (String key, String[] keys, int difficulty) {
        System.out.println(key);
        //change grivd size dependant on difficulty
        if (difficulty == 0)
        {
            column = 5;
            row = 6;
            letterWidth = 50;
            spaceWidth = 10;
            keyword = new char[column];
            grid = new char[row][column];
            startcorner = (600 - (5 * letterWidth + 4 * spaceWidth))/2;
        }
        else if (difficulty == 1)
        {
            column = 7;
            row = 6;
            letterWidth = 30;
            spaceWidth = 10;
            keyword = new char[column];
            grid = new char[row][column];
            startcorner = (600 - (7 * letterWidth + 6 * spaceWidth))/2;
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
        this.setPreferredSize(new Dimension(600, 650));
        this.pack();
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
        int xcoord = startcorner, ycoord = 50;
        //initialize JLabel array as blank
        for (int j = 0; j < row; j++)
        {
            for (int i = 0; i < column; i++)
            {
                //add new jlabel for grid sector
                labelArray[j][i] = new JLabel(" ", SwingConstants.CENTER);
                labelArray[j][i].setBackground(Color.LIGHT_GRAY);
                labelArray[j][i].setOpaque(true);
                labelArray[j][i].setBounds(xcoord, ycoord, letterWidth, 50);
                this.add(labelArray[j][i]);
                //increment next space
                xcoord += (letterWidth + spaceWidth);
            }
            //increment y coordinate to next row
            ycoord += 50 + spaceWidth;
            //reset the column coordinate
            xcoord = startcorner;
        }
    }


    void makeKeyboard() {

    }
    /**
     * key press validation for entries
     * @param e - key typed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //check if input is a letter
        if (String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) >= 'A' && String.valueOf(e.getKeyChar()).toUpperCase().charAt(0) <= 'Z')
        {
            if (index_column < column)
            {
                //add input letter to grid as uppercase
                grid[index_row][index_column] = String.valueOf(e.getKeyChar()).toUpperCase().charAt(0);
                labelArray[index_row][index_column].setText(String.valueOf(grid[index_row][index_column]));
                labelArray[index_row][index_column].setBackground(Color.GRAY);
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
                labelArray[index_row][index_column].setBackground(Color.LIGHT_GRAY);
            }
        }
        //check if enter key is pressed

        //ADD ONSCREEN KEYBOARD
        if (e.getKeyChar() == '0')
        {
            //check if guess is the correct length
            if (index_column == column)
            {
                //check if the guess is a valid keyword
                for (int j = 0; j < keys.length; j++) {
                    valid = true;
                    for (int i = 0; i < column; i++) {
                        if (grid[index_row][i] != keys[j].charAt(i)) {
                            valid = false;
                            break;
                        }
                    }
                    System.out.println(valid);
                    if (valid)
                        break;
                }
                if (valid)
                {
                    //check for yellow letters
                    System.out.println("valid");
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
    //not used but needed for "implements keyListener
    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }
}
