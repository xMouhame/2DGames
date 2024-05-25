package main;

//Add the import statement for JFrame
import javax.swing.JFrame;

public class Main {
 public static void main(String[] args) {
     JFrame window = new JFrame();
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // lets the window close ("x") button
     window.setResizable(false); // we cant resize the window
     window.setTitle("2D Advanture");
    
     GamePanel gamePanel = new GamePanel();
     window.add(gamePanel);
     window.pack(); // causes this window tto be sized to fit the preferrd size and lazyouts of its subcomponents (GamePanel)
     window.setLocationRelativeTo(null); // where we want the window to be displayed  if null at the center 
     window.setVisible(true);
     gamePanel.startGameThread();

 }
}