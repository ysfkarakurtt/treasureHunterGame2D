package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JPanel;

import entity.Entity;
import entity.NPC_DrHeinzDoofenshmirtz;
import entity.NPC_DrHeinzMachine;
import entity.Player;

import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

	
	
	final int scale =3;
	final int originalTileSize =16; 
	
	public final int tileSize= originalTileSize *scale;
	
	public final int maxScreenRow=12;
	public final int maxScreenCol=16;
	
	public final int screenWidth =tileSize *maxScreenCol;
	public final int screenHeight=tileSize *maxScreenRow;


	int FPS=60;
	
	Thread gameThread;
	TileManager tileManager=new TileManager(this);
	KeyHandler keyH=new KeyHandler();

	
	public CollisionCheck cCheck= new CollisionCheck(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui =new UI(this);
	public Player player =new Player(this,keyH);
	public NPC_DrHeinzDoofenshmirtz npc[ ]=new NPC_DrHeinzDoofenshmirtz[10];
	public NPC_DrHeinzMachine npc2[ ]=new NPC_DrHeinzMachine[10];
	public SuperObject  obj[] =new SuperObject[10];
	
	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true );
		this.addKeyListener(keyH);
		this.setFocusable(true);
	
	}
	
	public void setupGame()
	{
		aSetter.setObject();
		aSetter.setNPC();
	}
	public void startGameThread()
	{
		gameThread =new Thread(this);
		gameThread.start();
	}
	@Override
	public void run() {
		
			double drawInterval=1000000000/FPS; 
			
			double delta=0;
			long lastTime=System.nanoTime();
			long currentTime;
			long timer=0;
			int drawCount =0;
			
			
			while(gameThread !=null)
			{
				
				 currentTime=System.nanoTime();
				 
				 delta +=(currentTime- lastTime)/drawInterval;
				 timer +=(currentTime- lastTime);
				 lastTime=currentTime;
				 if(delta>=1) {
					
						update();
						
						repaint();
						delta--;
						drawCount++;
				 }
				 
				 if(timer>=1000000000)
						
				 {
					
					 drawCount=0;
					 timer=0;
				 }

				
			
			}
		
	}
	public void update()
	{
			player.update();
			
			
			for(int i=0; i< npc.length; i++)
			{
				if(npc[i] != null)
				{
					npc[i].update();
				}
			}
			
			for(int i=0; i< npc2.length; i++)
			{
				if(npc2[i] != null)
				{
					npc2[i].update();
				}
			}
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		
		tileManager.draw(g2);
		
		for (int i = 0; i < obj.length; i++) {
			
			if(obj[i] !=null)
			{
				obj[i].draw(g2,this);
			}
		}
		
		
		for(int i= 0; i<npc.length;i++)
		{
			if(npc[i] !=null)
			{
				npc[i].draw(g2);;
			}
		}
		
		for(int i= 0; i<npc2.length;i++)
		{
			if(npc2[i] !=null)
			{
				npc2[i].draw(g2);;
			}
		}
		
	
		player.draw(g2);
		
		ui.draw(g2);
		g2.dispose();
		
		
	}
	
	
	

		    
}
