package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{

	//Screen settings
	final int originalTitleSize = 16;  // 16*16 title the box of the character
	final int scale= 3;
	public int tileSize = originalTitleSize * scale ; // 48*48 tilte 
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol ; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 556 pixels

	// FPS
	int FPS = 60;

	KeyHandler keyH = new KeyHandler ();
	Thread gameThread; //The thread responsible for running the game's main loop
	Player player = new Player (this, keyH);
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
	
	// delta method 
	public void run () {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		while (gameThread!=null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >=1) {
			update ();
			repaint ();
			delta--;
			drawCount++;
			}
			if (timer>= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0 ;
			}
			
		}
	}
	//we change the player position
	public void update() {
		player.update();
	}
	public void paintComponent (Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;  // extends the graphic class to provide more sophisticated control over geometry, coordinate transformations, color managemment, and tesxt layout 
		player.draw(g2);
		g2.dispose(); // to save some memory
	}
}
