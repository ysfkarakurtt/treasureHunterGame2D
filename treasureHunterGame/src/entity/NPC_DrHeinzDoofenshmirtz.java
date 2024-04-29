package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class NPC_DrHeinzDoofenshmirtz extends Entity {
	
	public  boolean checkUpDown=true;
	
	public NPC_DrHeinzDoofenshmirtz(GamePanel gp) {
		super(gp);
		speed=1;
		getNpcImage();
	}

	public void getNpcImage()
	{
		try {
			
			walk=ImageIO.read(new File("res/npc/monster1.png"));
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
	        direction = "up"; 
	    }
		if(actionLockCounter ==60*4)
		{
		
			
			if(checkUpDown ==true)
			{
				direction ="down";
				checkUpDown =false;
			}
			
			else if (checkUpDown ==false)
			{
				direction ="up";
				checkUpDown=true;
			}
		
			
			actionLockCounter =0; 
			
			}
					
		
		
	
	}

}
