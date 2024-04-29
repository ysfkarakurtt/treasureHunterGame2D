package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
	
	public int x,y;
	public int speed;
	 
	 public BufferedImage walk;
		GamePanel gp;
	 public String direction;
	public Rectangle solidArea =new Rectangle(0,0,48,48);
	public int solidAreaDefaultX,solidAreaDefaultY;
	public int  actionLockCounter=0;
	public int  actionLockCounter2=0;
	public boolean collisionOn=false; 
	
	public Entity(GamePanel gp)
	{
		this.gp=gp;
	}
	
	public void draw(Graphics2D g2,GamePanel gp)
	{
		BufferedImage image =null; 
		
		g2.drawImage(image,x,y, gp.tileSize, gp.tileSize,null);
	}
	public  void setAction() {}
	
	public void update()
	{
		setAction();
		collisionOn=false;
		gp.cCheck.tileCheck(this);
		gp.cCheck.ObjectCheck(this, false);
		gp.cCheck.checkPlayer(this);
		
		if(collisionOn ==false)
	   	{ 
	   		
	   		switch(direction)
	   		{
	   			case"left":
   				x-=speed;
   				break;
   				
	   			case"down":
	   				y +=speed;
	   				break;
	   			
	   			case"up":
	   				y-=speed;
	   				break;
	  


	   			case"right":
	   				x +=speed;
	   				break;
	   		}
	   	}
	   	
	}
	
	
}
