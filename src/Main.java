import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends JFrame {
  public static JFrame frame = new JFrame();
  private static File file5 = new File("src\\5LetterKeyWords.txt");
  private static final int FIVECOUNT = 586;
  private static final int SEVENCOUNT = 500;
  private static String[] words5 = new String[FIVECOUNT];
  private File file7 = new File("src\\7LetterKeyWords.txt");
  String[] words7 = new String[SEVENCOUNT];
  public static void main(String[] args) throws IOException{
    //create frame and set parameters
    makeFrame();
    //create title screen
    titleScreen();
    //import keywords
    Scanner five = new Scanner(file5);
    for (int i = 0; i < FIVECOUNT; i++)
    {
      words5[i] = five.nextLine();
    }
  }

  public static void makeFrame()
  {
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setSize(600,650);
  }
  static void titleScreen()
  {
    //create main menu button
    JButton mainMenu2 = new JButton("Main Menu");
    mainMenu2.setBounds(200, 500, 200, 50);
    mainMenu2.setBackground(Color.GRAY);
    frame.add(mainMenu2);
    //add action for main menu
    mainMenu2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {
        //clear the screen
        frame.getContentPane().removeAll();
        frame.repaint();
        //open main menu
        mainMenu();
      }
    });
  }

  static void mainMenu()
  {
    //create panel for buttons
    JPanel panel = new JPanel();
    panel.setBounds(50,50, 500, 500);
    panel.setBackground(Color.LIGHT_GRAY);
    frame.add(panel);

    //add option for easy mode
    JButton easy = new JButton("Easy Mode");
    easy.setBounds(100,100, 400, 50);
    easy.setBackground(Color.GRAY);
    frame.add(easy);

    //add action for easy mode
    easy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
        try
        {
          easyMode();
        }
        catch (Exception IO)
        {
          System.out.println("error");
        }
      }
    });

    //add option for tutorial
    JButton tutorial = new JButton("Tutorial");
    tutorial.setBounds(100,200, 400, 50);
    tutorial.setBackground(Color.GRAY);
    frame.add(tutorial);

    tutorial.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try
        {
          tutorialButton();
        }
        catch (Exception IO)
        {
          System.out.println("error");
        }
      }
    });
  }

  static void tutorialButton() {
    new Instructions();
  }
  static void easyMode() throws IOException{
    Generator five = new Generator(words5);
    new EasyMode(five.getRandom());
  }
}