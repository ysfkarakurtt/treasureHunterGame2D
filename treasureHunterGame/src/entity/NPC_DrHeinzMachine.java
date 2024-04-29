package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class NPC_DrHeinzMachine extends Entity {
	
	public boolean checkUpDown=true;
	
	public NPC_DrHeinzMachine(GamePanel gp)
	{
		super(gp);
		speed=1;
		getNpcImage();
	}

	public void getNpcImage()
	{
		try {
			
			walk=ImageIO.read(new File("res/npc/monster2.png"));
			//walk=ImageIO.read(getClass().getResourceAsStream(("/player/hunter.jpg")));
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2)
	{
		
		BufferedImage image =walk;
		
		 g2.drawImage(image, x, y,gp.tileSize,gp.tileSize,null);
	}
	
	
	public void setAction()
	{
		actionLockCounter ++;
		if (direction == null) {
	        direction = "right"; 
	    }
		if(actionLockCounter ==60)
		{
		
	
			
			
			if(checkUpDown ==true)
			{
				direction ="left";
				checkUpDown =false;
			}
			
			else if (checkUpDown ==false)
			{
				direction ="right";
				checkUpDown=true;
			}
		
			
			actionLockCounter =0; 
			
			}
		
	
	}

}
