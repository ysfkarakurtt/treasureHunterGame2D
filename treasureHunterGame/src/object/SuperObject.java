package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {


	public String name;
	public Rectangle solidArea =new Rectangle(0,0,48,48);
	public int solidAreaDefaultX=0;
	public int solidAreaDefaultY=0;
	public int worldX,worldY;
	
	public boolean collision =false;
	public BufferedImage image;

	public void draw(Graphics2D g2,GamePanel gp)
	{
		
		g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize,null);
	}

}
