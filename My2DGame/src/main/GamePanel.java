package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	//Screen settings
	final int originalTitleSize = 16;  // 16*16 title the box of the character
	final int scale= 3;
	final int tileSize = originalTitleSize * scale ; // 48*48 tilte 
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol ; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 556 pixels

	// FPS
	int FPS = 60;

	KeyHandler keyH = new KeyHandler ();
	Thread gameThread; //The thread responsible for running the game's main loop

	// set players default  position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;

	public GamePanel () {
		this.setPreferredSize(new Dimension (screenWidth, screenHeight) ); // set the size of this class 
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); // for better rendering performance
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	public void startGameThread () {
		gameThread = new Thread (this);
		gameThread.start();
	}
	// we will create a  game loop which will be the core of our game 
	@Override
	// first game loop SLEEP
	//	public void run() {
	//		double drawInterval = 1000000000/FPS;
	//		double nextDrawTime = System.nanoTime() + drawInterval;
	//		
	//		
	//		while (gameThread!= null) {
	//			//1 check the updates 
	//			update ();
	//			//2 draw the screen
	//			repaint (); // thats how we call painComponent
	//			
	//			try {			
	//				double remainingTime = nextDrawTime - System.nanoTime();
	//				remainingTime = remainingTime/1000000; // to convert it in miulisecond
	//				
	//				if(remainingTime< 0) remainingTime = 0;
	//				Thread.sleep((long) remainingTime); // pause the game loop
	//				
	//				nextDrawTime += drawInterval;
	//			} catch (InterruptedException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//		}
	//
	//
	//	}
	public void run () {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		while (gameThread!=null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if(delta >=1) {
			update ();
			repaint ();
			delta--;
			}
		}
	}
	//we change the player position
	public void update() {
		   if (keyH.upPressed) {
		        playerY -= playerSpeed; // Y decreases as we go up
		    }
		    if (keyH.downPressed) {
		        playerY += playerSpeed; // Y increases as we go down
		    }
		    if (keyH.leftPressed) {
		        playerX -= playerSpeed; // X decreases as we go left
		    }
		    if (keyH.rightPressed) {
		        playerX += playerSpeed; // X increases as we go right
		    }
		    if (keyH.upRightPressed) {
		        playerX += playerSpeed; // X increases as we go right
		        playerY -= playerSpeed; // Y decreases as we go up
		    }
		    if (keyH.upLeftPressed) {
		        playerX -= playerSpeed; // X decreases as we go left
		        playerY -= playerSpeed; // Y decreases as we go up
		    }
		    if (keyH.downRightPressed) {
		        playerX += playerSpeed; // X increases as we go right
		        playerY += playerSpeed; // Y increases as we go down
		    }
		    if (keyH.downLeftPressed) {
		        playerX -= playerSpeed; // X decreases as we go left
		        playerY += playerSpeed; // Y increases as we go down
		    }
	}
	public void paintComponent (Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;  // extends the graphic class to provide more sophisticated control over geometry, coordinate transformations, color managemment, and tesxt layout 
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize); // draw rectangle and fill the object 
		g2.dispose(); // to save some memory
	}
}
