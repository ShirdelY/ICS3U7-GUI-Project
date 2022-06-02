import javax.swing.*;
class Main extends JFrame{
  titleScreen() {
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(600, 1200);
    JButton mainMenu = new JButton("Main Menu");
    mainMenu.setBounds(200, 800, 200, 100);
    add(mainMenu);
  }
  public static void main(String[] args) {
    new titleScreen();
  }
}