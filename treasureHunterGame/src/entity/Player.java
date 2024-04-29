package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	
	KeyHandler keyH;
	public int silverChestCount=0;
	public int goldChestCount=0;
	public int emeraldChestCount=0;
	public int copperChestCount=0;
	public int totalChest=4;
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);

		this.keyH = keyH;
		
		
		solidArea =new Rectangle();
		solidArea.x=8;
		solidArea.y=16;
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		solidArea.width=32;
		solidArea.height=32;
		setDefaultValues();
		getPlayerImage();
		
	}
	
	
	public void setDefaultValues() {
		x=100;
		y=100;
		speed=3;
	}
	
	public void getPlayerImage()
	{
		try {
			
			walk=ImageIO.read(new File("res/player/hunter.png"));
			//walk=ImageIO.read(getClass().getResourceAsStream(("/player/hunter.jpg")));
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void update()
	{
		
		if (direction == null) {
	        direction = " "; 
	    }
		   	if(keyH.upPressed == true || keyH.downPressed ==true ||
		   			keyH.leftPressed ==true || keyH.rightPressed)
		   	{
		   	
		   		
		   		
		   	if(keyH.upPressed)
		   	{
		   			direction ="up";
		   			
		   	}
			
			
			else if(keyH.leftPressed == true)
			{
				direction ="left";
				
			}
		   	
			else if(keyH.downPressed == true)
			{
				direction ="down";
				
			}
		   	
			else if(keyH.rightPressed ==true)
			{
				direction ="right";
				
			}
		   		
		   	}
		   
		   	
		   	collisionOn=false;
			
		   	if(x<=0 || x>=720 || y<=0 || y>=520)
		   	{
		   		if(x<=0)
		   		{
		   			x=0;
		   		}
		   		if(x>=720)
		   		{
		   			x=720;
		   		}
		   		if(y<=0)
		   		{
		   			y=0;
		   		}
		   		if(y>=520)
		   		{
		   			y=520;
		   		}
		   	
		   	}
		   	gp.cCheck.tileCheck(this);
		   	
		   	
		   	int objectIndex= gp.cCheck.ObjectCheck(this,true);
		   	objectPickUp(objectIndex);
		   	
		   	int npcIndex=gp.cCheck.checkNpc(this, gp.npc);
		   	interactWithNpc(npcIndex);
	
		   	
		   	
		   	//if collision is false,player can move
		   	if(collisionOn ==false)
		   	{ 
		   		
		   		switch(direction)
		   		{
		   			case"up":
		   				y-=speed;
		   				direction = " "; 
		   				break;
		   				
		   			case"left":
		   				x-=speed;
		   				direction = " "; 
		   				break;

		   			case"down":
		   				y +=speed;
		   				direction = " "; 
		   				break;

		   			

		   			case"right":
		   				x +=speed;
		   				direction = " "; 
		   				break;
		   		}
		   	}
		   	
		   	
		  
	}
	
	public void objectPickUp(int a)
	{
			if( a !=999)
			{
				String objectName=gp.obj[a].name;
				
				switch(objectName)
				{
				
					case "silver":
						totalChest--;
						silverChestCount++;
						if(silverChestCount >0)
						{
							
							gp.obj[a]=null;
							gp.ui.showMessage("Silver Chest is found! ( "+gp.player.x+","+" "+gp.player.y +" )");
							
						}
						if(totalChest==0)
						{
							gp.ui.gameFinished=true;
						}
						break;
						
					case "gold":
						totalChest--;
						goldChestCount++;
						if(goldChestCount >0)
						{
							
							gp.obj[a]=null;
							gp.ui.showMessage(" Gold Chest is found! ( "+gp.player.x+","+" "+gp.player.y +" )");						}
				
						if(totalChest==0)
						{
							gp.ui.gameFinished=true;
						}
						break;
						
					case "copper":
						totalChest--;
						copperChestCount++;
						if(copperChestCount >0)
						{
							
							gp.obj[a]=null;
							gp.ui.showMessage("Copper Chest is found! ( "+gp.player.x+","+" "+gp.player.y +" )");
						}
						if(totalChest==0)
						{
							gp.ui.gameFinished=true;
						}
				
						break;
						
					case "emerald":
						totalChest--;
						emeraldChestCount++;
						if(emeraldChestCount >0)
						{
							
							gp.obj[a]=null;
							gp.ui.showMessage("Emerald Chest is found! ( "+gp.player.x+","+" "+gp.player.y +" )");
						}
						if(totalChest==0)
						{
							gp.ui.gameFinished=true;
						}
						break;
				}
	}
				
			}
	
	
	public void interactWithNpc(int a)
	{
		if(a !=999)
		{

		}
	}
	public void draw(Graphics2D g2)
	{
		
		BufferedImage image =walk;
		
		 g2.drawImage(image, x, y,gp.tileSize,gp.tileSize,null);
	}
	
}
