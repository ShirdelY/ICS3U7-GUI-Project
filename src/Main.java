import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {
  public static JFrame frame = new JFrame();

  public static void main(String[] args){
    //create frame and set parameters
    makeFrame();
    //create title screen
    titleScreen();
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
  }

  static void easyMode() throws IOException{
    //Generator five = new Generator(5, "src\\5LetterKeyWords.txt");
    EasyMode game = new EasyMode("fives");
    frame.add(game);
  }
}