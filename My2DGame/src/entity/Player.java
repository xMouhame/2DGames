package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	public Player (GamePanel gp , KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefaultvalues();
		getPlayerImage();
	}
	public void setDefaultvalues () {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage () {

		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));


		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update () {
		// if we dont want the player to move
		if(keyH.upPressed|| keyH.downPressed || keyH.leftPressed || keyH.rightPressed )
		{
			if (keyH.upPressed) {
				direction = "up";
				y -= speed; // Y decreases as we go up
			}
			if (keyH.downPressed) {
				direction = "down";
				y += speed; // Y increases as we go down
			}
			if (keyH.leftPressed) {
				direction = "left";

				x -= speed; // X decreases as we go left
			}
			if (keyH.rightPressed) {
				direction = "right";

				x += speed; // X increases as we go right
			}
			if (keyH.upRightPressed) {
				x += speed; // X increases as we go right
				y -= speed; // Y decreases as we go up
			}
			if (keyH.upLeftPressed) {
				x -= speed; // X decreases as we go left
				y -= speed; // Y decreases as we go up
			}
			if (keyH.downRightPressed) {
				x += speed; // X increases as we go right
				y += speed; // Y increases as we go down
			}
			if (keyH.downLeftPressed) {
				x -= speed; // X decreases as we go left
				y += speed; // Y increases as we go down
			}
			spriteCounter++;
			if(spriteCounter > 10) {
				if (spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
			
		
	}
	public void draw (Graphics2D g2) {
		//		g2.setColor(Color.white);
		//		g2.fillRect(x, y, gp.tileSize, gp.tileSize); // draw rectangle and fill the object 
		BufferedImage image = null;
		switch (direction) {
		case "up" : 
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down" : 
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left" : 
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2)
				image= left2;
			break;
		case "right" : 
			if(spriteNum == 1) {
				image = right1;}
			if (spriteNum == 2)
				image = right2;
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize,gp.tileSize,null);
	}
}
