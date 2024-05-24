package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	//Screen settings
	final int originalTitleSize = 16;  // 16*16 title the box of the character
	final int scale= 3;
	final int titleSize = originalTitleSize * scale ; // 48*48 tilte 
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = titleSize * maxScreenCol ; // 768 pixels
	final int screenHeight = titleSize * maxScreenRow; // 556 pixels
	
	public GamePanel () {
		this.setPreferredSize(new Dimension (screenWidth, screenHeight) ); // set the size of this class 
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true); // for better rendering performance
		
	}
}
