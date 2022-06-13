import java.awt.*;

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
public class Keyboard extends JFrame {
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
		frame.setSize(600, 650);
		pack();
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
    	String[] row3 = {"Z", "X", "C", "V", "B", "N", "M"};
		int keyxcoord = 128, keyycoord = 460;
    	JPanel p1 = new JPanel();
		JButton[] row1a = new JButton[10];
    	for (int b = 0; b < row1.length; b++) {
    		row1a[b] = new JButton(row1[b]);
			row1a[b].setBounds(keyxcoord, keyycoord, 30, 50);
			keyxcoord += 35;
    		p1.add(row1a[b]);
    	}
		keyxcoord = 128;
		keyycoord += 55;
		keyxcoord += 26;
    	bottom_panel.add(p1);

		JPanel p2 = new JPanel();
		JButton[] row2a = new JButton[9];
		for (int b = 0; b < row2.length; b++) {
			row2a[b] = new JButton(row2[b]);
			row2a[b].setBounds(keyxcoord, keyycoord, 30, 50);
			keyxcoord += 35;
			p2.add(row2a[b]);
		}
		keyxcoord = 128;
		keyycoord += 55;
		keyxcoord += 26;
		keyxcoord += 55;
		bottom_panel.add(p2);

		JPanel p3 = new JPanel();
		JButton[] row3a = new JButton[7];
		for (int b = 0; b < row3.length; b++) {
			row3a[b] = new JButton(row3[b]);
			row3a[b].setBounds(keyxcoord, keyycoord, 30, 50);
			keyxcoord += 35;
			p3.add(row3a[b]);
		}
	}
	public static void main(String[] args) {
		new Keyboard("crane", 0);
	}
}