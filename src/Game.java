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
    String guess, keyString;
    final int BUTTON_WIDTH = 30, BUTTON_SPACE = 5, BUTTON_HEIGHT = 50;
    int keyboard_x = 128, keyboard_y = 460;
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
            keyword[i] = key.toUpperCase().charAt(i);
        //import keyword source parameters
        this.keys = keys;
        keyString = key;
        //create JFrame
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setResizable(false);
        setPreferredSize(new Dimension(600, 650));
        pack();
        addKeyListener(this);
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
                //add new JLabel for grid sector
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
        //create keyboard

        JPanel keyboardPanel = new JPanel();
        JButton[] buttonKeysFirstRow = new JButton[10];
        JButton[] buttonKeysSecondRow = new JButton[9];
        JButton[] buttonKeysThirdRow = new JButton[9];

        String[][] keys1 = {{ "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"},
                {"A", "S", "D", "F", "G", "H", "J", "K", "L"},
                {"Enter", "Z", "X", "C", "V", "B", "N", "M", "Delete"}};

        for (int i = 0; i < buttonKeysFirstRow.length; i++)
        {
            buttonKeysFirstRow[i] = new JButton(keys1[0][i]);
            buttonKeysFirstRow[i].setBackground(Color.LIGHT_GRAY);
            buttonKeysFirstRow[i].setOpaque(true);
            buttonKeysFirstRow[i].setBounds(keyboard_x, keyboard_y, BUTTON_WIDTH, BUTTON_HEIGHT);
            this.add(buttonKeysFirstRow[i]);

            xcoord += BUTTON_WIDTH + BUTTON_SPACE;
        }
        xcoord = 128;
        ycoord += BUTTON_HEIGHT + BUTTON_SPACE;
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
            //make sure index will not go negative
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
        else if (e.getKeyChar() == '[')
        {
            if (index_row < row)
            {
                //check if guess is the correct length
                //make sure there are guess remaining
                if (index_column == column)
                {
                    //convert the guess input intpo a string
                    guess = "";
                    for (int i = 0; i < column; i++)
                        guess += String.valueOf(grid[index_row][i]);
                    //check if the guess is a valid keyword
                    valid = false;
                    for (int j = 0; j < keys.length; j++) {
                        if (keys[j].toUpperCase().equals(guess))
                        {
                            valid = true;
                            break;
                        }
                    }
                    //guess is a word, proceed
                    if (valid)
                    {
                        //check for letters to see if they are used in the keyword
                        //if so, change background to yellow
                        System.out.println("valid");
                        for (int i = 0; i < column; i++)
                        {
                            for (int j = 0; j < column; j++)
                            {
                                if (grid[index_row][i] == keyword[j])
                                {
                                    //orange looks better than default yellow
                                    labelArray[index_row][i].setBackground(Color.ORANGE);
                                }
                            }
                        }
                        //check for letters that are in the same position as the keyword
                        //if so, set background to green
                        for (int i = 0; i < column; i++)
                        {
                            if (grid[index_row][i] == keyword[i])
                                labelArray[index_row][i].setBackground(Color.GREEN);
                        }
                        //reload screed
                        repaint();
                        //move to next row for next guess
                        index_row++;
                        //reset column index back to start
                        index_column = 0;
                    }
                    //guess is not a word, turn boxes red to indicate such
                    else
                    {
                        for (int i = 0; i < column; i++)
                            labelArray[index_row][i].setBackground(Color.RED);
                    }
                }
            }
            else
                new Loser(keyString);
        }
    }
    //not used but needed for "implements keyListener"
    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }
}
