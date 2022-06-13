import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * 
 * @author shizacharania
 * https://stackoverflow.com/questions/20975592/inconsistent-behavior/20976091
 */
public class Keyboard extends JPanel {
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
//	int keyboard_x = 128, keyboard_y = 460;
	Keyboard (String key, int difficulty) {
//		JLabel label1 = new JLabel();
//		label1.setText("HI");
//		label1.setBounds(30,10,75,75);
//
		JPanel top_panel = new JPanel();
		top_panel.setBackground(Color.red);
		top_panel.setBounds(0, 0, 600, 450);

		JPanel bottom_panel = new JPanel();
		bottom_panel.setBackground(Color.blue);
		bottom_panel.setBounds(0, 450, 600, 200);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(600,650);
		frame.setVisible(true);

//		top_panel.add(label1);

		frame.add(top_panel);
		frame.add(bottom_panel);

		if (difficulty == 0) {
			this.column = 5;
			this.row = 6;
			this.letterWidth = 50;
			this.spaceWidth = 10;
			this.keyword = new char[column];
			this.grid = new char[row][column];
			this.startcorner = (600 - (5 * letterWidth + 4 * spaceWidth))/2;
		}
		else if (difficulty == 1)
		{
			this.column = 7;
			this.row = 6;
			this.letterWidth = 30;
			this.spaceWidth = 10;
			this.keyword = new char[column];
			this.grid = new char[row][column];
			this.startcorner = (600 - (7 * letterWidth + 6 * spaceWidth))/2;
		}
		//create character array from String keyword
		for (int i = 0; i < key.length(); i++) {
			keyword[i] = key.toUpperCase().charAt(i);
		}
        keyString = key;
        
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
                top_panel.add(labelArray[j][i]); // do we put super. here???
                //increment next space
                xcoord += (letterWidth + spaceWidth);
                System.out.println("done one column");
            }
//            System.out.println("done 1 row");
            //increment y coordinate to next row
            ycoord += 50 + spaceWidth;
            //reset the column coordinate
            xcoord = startcorner;
            System.out.println("done one row");
        }
        System.out.println("done 1 grid");
		
		// adding the keyboard
		bottom_panel.setLayout(new GridLayout(3,1));
		String[] row1 = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
    	String[] row2 = {"A", "S", "D", "F", "G", "H", "J", "K", "L"};
    	String[] row3 = {"Enter", "Z", "X", "C", "V", "B", "N", "M", "Delete"};
		
    	JPanel p1 = new JPanel(new GridLayout(1, row1.length));
    	for (String b: row1) {
    		JButton button = new JButton(b); 
//    		button.setBounds(); - add measurement
    		p1.add(button);
    	}
    	bottom_panel.add(p1);
    	
    	JPanel p2 = new JPanel(new GridLayout(1, row2.length));
    	for (String b: row2) {
    		JButton button = new JButton(b); 
//    		button.setBounds(); - add measurement
    		p2.add(button);
    	}
    	bottom_panel.add(p2);
    	
    	JPanel p3 = new JPanel(new GridLayout(1, row3.length));
    	for (String b: row3) {
    		JButton button = new JButton(b); 
//    		button.setBounds(); - add measurement
    		p3.add(button);
    	}
    	bottom_panel.add(p3);
    	
    }
	public static void main(String[] args) {
		new Keyboard("crane", 0);
	}
}