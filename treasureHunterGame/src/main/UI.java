package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI {
	
	
	Font arial_20;
	Font arial_80;
	GamePanel gp;
	
	
	double playTime;
	DecimalFormat decimalFormat= new DecimalFormat("#0.00");
	public String  message ="";
	public boolean messageOn=false;
	int messageCounter=0;
	public boolean gameFinished=false;
	
	public UI(GamePanel gp)
	{
		this.gp=gp;
		arial_20= new Font("Arial",Font.PLAIN,20);
		
		arial_80= new Font("Arial",Font.BOLD,80);
	}
	
	public void showMessage(String text)
	{
		message=text;
		messageOn=true;
	}
	public void draw(Graphics2D g2)
	{
		
		if(gameFinished==true)
		{
			g2.setFont(arial_20);
			g2.setColor(Color.white);
			
			int x=gp.screenWidth/2;
			int y=gp.screenHeight/2;
			String textMessage;
			int textMessageLength;
			
			
			
			
			textMessage="You found all chests.";
			textMessageLength=(int)g2.getFontMetrics().getStringBounds(textMessage, g2).getWidth();
			
			x= x- (textMessageLength/2);
			y= y- (gp.tileSize*3);
			
			g2.drawString(textMessage, x, y);
			
			int a=gp.screenWidth/2;
			int b=gp.screenHeight/2;
			
			textMessage="Your Time is :"+decimalFormat.format(playTime)+"!";
			textMessageLength=(int)g2.getFontMetrics().getStringBounds(textMessage, g2).getWidth();
			
			a= a- (textMessageLength/2);
			b= b+ (gp.tileSize*4);
			
			g2.drawString(textMessage, a, b);
			
			int c=gp.screenWidth/2;
			int d=gp.screenHeight/2;
			
			g2.setFont(arial_80);
			g2.setColor(Color.yellow);
			
			
			textMessage="Congratulations!";
			textMessageLength=(int)g2.getFontMetrics().getStringBounds(textMessage, g2).getWidth();
			

			c= c- (textMessageLength/2);
			d= d+ (gp.tileSize*2);
			
			g2.drawString(textMessage, c, d);
			gp.gameThread=null;
		
		}
		else
		{
		g2.setFont(arial_20);
		g2.setColor(Color.white);
		
		
		playTime +=(double) 1/60;
		
		
		g2.drawString("Time :"+decimalFormat.format(playTime), gp.tileSize*13,65);
		
		if(messageOn== true)
		{
			g2.setFont(g2.getFont().deriveFont(20F));
			g2.drawString(message, gp.tileSize/3,gp.tileSize*3);
			
			messageCounter++;
			if(messageCounter>120)
			{
				messageCounter=0;
				messageOn=false;
			}
		}
		
			}
		
	}
}
