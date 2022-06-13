import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener, ActionListener {
    //declare variables
    private int row = 0, column = 0;
    private int letterWidth = 0, spaceWidth = 0;
    private char[][] grid;
    private char[] keyword;
    private int index_row = 0, index_column = 0;
    private final String[] keys;
    JLabel[][] labelArray;
    boolean valid = false;
    int startcorner;
    String guess, keyString;
    final int BUTTON_WIDTH = 30, BUTTON_SPACE = 5, BUTTON_HEIGHT = 50;
    int keyboard_x = 128, keyboard_y = 425;
    final int KEY_START_X = 128;

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
        makeKeyboard();
        //add keylistener for keyboard input
        addKeyListener(this);
    }

    /**
     * create onscreen keyboard
     */
    public void makeKeyboard() {
        //create first row of keys
        JButton[] row1_buttons = new JButton[10];
        final String[] ROW1 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
        //initialize each JButton
        for (int a = 0; a < 10; a++) {
            row1_buttons[a] = new JButton(ROW1[a]);
            //get rid of button border
            row1_buttons[a].setBorder(BorderFactory.createEmptyBorder());
            row1_buttons[a].setBounds(keyboard_x, keyboard_y, BUTTON_WIDTH, BUTTON_HEIGHT);
            //set un-focusable to fix key listener conflict
            row1_buttons[a].setFocusable(false);
            //increment column coordinate to next space
            keyboard_x += BUTTON_WIDTH + BUTTON_SPACE;
            this.add(row1_buttons[a]);
            //add action listener
            row1_buttons[a].addActionListener(this);
        }

        //increment row coordinate to next space
        keyboard_y += BUTTON_HEIGHT + BUTTON_SPACE;
        //reset column coordinate and shift half a space over
        keyboard_x = KEY_START_X + (int) Math.round((double) (BUTTON_WIDTH + BUTTON_SPACE) / 2);

        //create second row of keys
        JButton[] row2_buttons = new JButton[9];
        final String[] ROW2 = {"A", "S", "D", "F", "G", "H", "J", "K", "L"};
        //initialize each JButton
        for (int b = 0; b < 9; b++) {
            row2_buttons[b] = new JButton(ROW2[b]);
            //get rid of button border
            row2_buttons[b].setBorder(BorderFactory.createEmptyBorder());
            row2_buttons[b].setBounds(keyboard_x, keyboard_y, BUTTON_WIDTH, BUTTON_HEIGHT);
            //set un-focusable to fix key listener conflict
            row2_buttons[b].setFocusable(false);
            //increment column coordinate to next space
            keyboard_x += BUTTON_WIDTH + BUTTON_SPACE;
            this.add(row2_buttons[b]);
            //add action listener
            row2_buttons[b].addActionListener(this);
        }

        //increment row coordinate to next space
        keyboard_y += BUTTON_HEIGHT + BUTTON_SPACE;
        //reset column coordinate
        keyboard_x = KEY_START_X;

        //create third row of keys
        JButton[] row3_buttons = new JButton[10];
        final String[] ROW3 = {"Enter", "Z", "X", "C", "V", "B", "N", "M", "Back"};
        //initialize each JButton
        for (int a = 0; a < 9; a++) {
            row3_buttons[a] = new JButton(ROW3[a]);
            //get rid of button border
            row3_buttons[a].setBorder(BorderFactory.createEmptyBorder());
            //set un-focusable to fix key listener conflict
            row3_buttons[a].setFocusable(false);
            //check if button should be back or enter key
            if (a == 0 || a == ROW3.length-1) {
                //make these buttons 1.5 button widths wide
                row3_buttons[a].setBounds(keyboard_x, keyboard_y, BUTTON_WIDTH + (int) Math.round((double) (BUTTON_WIDTH + BUTTON_SPACE) / 2), BUTTON_HEIGHT);
                keyboard_x += BUTTON_WIDTH + (int) Math.round((double) (BUTTON_WIDTH + BUTTON_SPACE) / 2) + BUTTON_SPACE;
                this.add(row3_buttons[a]);
            }
            else {
                //make these buttons regular size
                row3_buttons[a].setBounds(keyboard_x, keyboard_y, BUTTON_WIDTH, BUTTON_HEIGHT);
                keyboard_x += BUTTON_WIDTH + BUTTON_SPACE;
                this.add(row3_buttons[a]);
            }
            //add action listener
            row3_buttons[a].addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case ("A") -> gameUpdate('A');
            case ("B") -> gameUpdate('B');
            case ("C") -> gameUpdate('C');
            case ("D") -> gameUpdate('D');
            case ("E") -> gameUpdate('E');
            case ("F") -> gameUpdate('F');
            case ("G") -> gameUpdate('G');
            case ("H") -> gameUpdate('H');
            case ("I") -> gameUpdate('I');
            case ("J") -> gameUpdate('J');
            case ("K") -> gameUpdate('K');
            case ("L") -> gameUpdate('L');
            case ("M") -> gameUpdate('M');
            case ("N") -> gameUpdate('N');
            case ("O") -> gameUpdate('O');
            case ("P") -> gameUpdate('P');
            case ("Q") -> gameUpdate('Q');
            case ("R") -> gameUpdate('R');
            case ("S") -> gameUpdate('S');
            case ("T") -> gameUpdate('T');
            case ("U") -> gameUpdate('U');
            case ("V") -> gameUpdate('V');
            case ("W") -> gameUpdate('W');
            case ("X") -> gameUpdate('X');
            case ("Y") -> gameUpdate('Y');
            case ("Z") -> gameUpdate('Z');
            case ("Enter") -> gameUpdate((char) 10);
            case ("Back") -> gameUpdate((char) 8);
        }
    }
    public void gameUpdate(char in)
    {
        System.out.print(in);
        if (String.valueOf(in).toUpperCase().charAt(0) >= 'A' && String.valueOf(in).toUpperCase().charAt(0) <= 'Z')
        {
            if (index_column < column)
            {
                //add input letter to grid as uppercase
                grid[index_row][index_column] = String.valueOf(in).toUpperCase().charAt(0);
                labelArray[index_row][index_column].setText(String.valueOf(grid[index_row][index_column]));
                labelArray[index_row][index_column].setBackground(Color.GRAY);
                index_column++;
            }
        }
        //check if input was a backspace
        else if (in == 8)
        {
            if (index_column == column)
            {
                for (int i = 0; i < column; i++)
                {
                    labelArray[index_row][i].setBackground(Color.GRAY);
                }
            }
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
        else if (in == 10) {
            if (index_row < row) {
                //check if guess is the correct length
                //make sure there are guess remaining
                if (index_column == column) {
                    //convert the guess input intpo a string
                    guess = "";
                    for (int i = 0; i < column; i++)
                        guess += String.valueOf(grid[index_row][i]);
                    //check if the guess is a valid keyword
                    valid = false;
                    for (int j = 0; j < keys.length; j++) {
                        if (keys[j].toUpperCase().equals(guess)) {
                            valid = true;
                            break;
                        }
                    }
                    //guess is a word, proceed
                    if (valid) {
                        //check for letters to see if they are used in the keyword
                        //if so, change background to yellow
                        System.out.println("valid");
                        for (int i = 0; i < column; i++) {
                            for (int j = 0; j < column; j++) {
                                if (grid[index_row][i] == keyword[j]) {
                                    //orange looks better than default yellow
                                    labelArray[index_row][i].setBackground(Color.ORANGE);
                                }
                            }
                        }
                        //check for letters that are in the same position as the keyword
                        //if so, set background to green
                        for (int i = 0; i < column; i++) {
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
                    else {
                        for (int i = 0; i < column; i++)
                            labelArray[index_row][i].setBackground(Color.RED);
                    }
                }
            } else
                new Loser(keyString);
        }
    }
    /**
     * key press validation for entries
     * @param e - key typed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        gameUpdate(e.getKeyChar());
        System.out.print(e.getKeyChar());
    }
    //not used but needed for "implements keyListener"
    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }
}
