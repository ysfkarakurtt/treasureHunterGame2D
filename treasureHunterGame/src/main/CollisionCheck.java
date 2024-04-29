package main;

import entity.Entity;

public class CollisionCheck {
	
	
	GamePanel gp;
	public CollisionCheck(GamePanel gp)
	{
		this.gp=gp;
	}
	
	public void tileCheck(Entity entity)
	{
		int entityTopWorldY=entity.y+entity.solidArea.y ;
		
		int entityBottomWorldY=entity.y+entity.solidArea.y +entity.solidArea.height;
		
		int entityLeftWorldX =entity.x +entity.solidArea.x;
		
		int entityRightWorldX =entity.x +entity.solidArea.x +entity.solidArea.width;
		
		int tileNum1,tileNum2;
		
		int entityLeftCol= entityLeftWorldX/gp.tileSize;
		
		int entityTopRow =entityTopWorldY/gp.tileSize;
		
		int entityRightCol= entityRightWorldX/gp.tileSize;
		
		int entityBottomRow =entityBottomWorldY/gp.tileSize;
		
		
		
		switch(entity.direction)
		{
		
			case "down":
			entityBottomRow=(entityBottomWorldY -entity.speed)/gp.tileSize;
			tileNum2 =gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			tileNum1 =gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			
			if(gp.tileManager.tile[tileNum1].collision==true || gp.tileManager.tile[tileNum2].collision==true)
			{
				entity.collisionOn=true;
				
			}
			break;
			
			case "up":
				entityTopRow=(entityTopWorldY -entity.speed)/gp.tileSize;
				tileNum2 =gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
				tileNum1 =gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
				
				if(gp.tileManager.tile[tileNum1].collision==true || gp.tileManager.tile[tileNum2].collision==true)
				{
					entity.collisionOn=true;
					
				}
				
				break;
				
			
			case "right":
				entityRightCol=(entityRightWorldX +entity.speed)/gp.tileSize;
				tileNum2 =gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
				tileNum1 =gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
				
				if(gp.tileManager.tile[tileNum1].collision==true || gp.tileManager.tile[tileNum2].collision==true)
				{
					entity.collisionOn=true;
					
				}
				break;
				
			case "left":
				entityLeftCol=(entityLeftWorldX-entity.speed)/gp.tileSize;
				tileNum2 =gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
				tileNum1 =gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
				
				if(gp.tileManager.tile[tileNum1].collision==true || gp.tileManager.tile[tileNum2].collision==true)
				{
					entity.collisionOn=true;
					
				}
				break;
				
			
		}
	}
	
	public int ObjectCheck(Entity entity,boolean player)
	{
		int objectIndex=999;
		
		for(int i=0; i< gp.obj.length;i++)
		{
			if( (gp.obj[i] !=null))
			{
				entity.solidArea.y=entity.y+ entity.solidArea.y;
				entity.solidArea.x=entity.x + entity.solidArea.x;
				
				gp.obj[i].solidArea.y=gp.obj[i].worldY+gp.obj[i].solidArea.y;
				gp.obj[i].solidArea.x=gp.obj[i].worldX+gp.obj[i].solidArea.x;
			
				switch(entity.direction)
				{
					case "up":
						entity.solidArea.y -=entity.speed;
						if(entity.solidArea.intersects(gp.obj[i].solidArea))
						{
							if(gp.obj[i].collision==true)
							{
								entity.collisionOn=true;
							}
							if(player==true)
							{
								objectIndex=i;
							}
						}
						break;
					
					
						
					case "left":
						entity.solidArea.x -=entity.speed;
						if(entity.solidArea.intersects(gp.obj[i].solidArea))
						{
							if(gp.obj[i].collision==true)
							{
								entity.collisionOn=true;
							}
							if(player==true)
							{
								objectIndex=i;
							}
						}
						break;
						
					case "down":
						entity.solidArea.y +=entity.speed;
						if(entity.solidArea.intersects(gp.obj[i].solidArea))
						{
							if(gp.obj[i].collision==true)
							{
								entity.collisionOn=true;
							}
							if(player==true)
							{
								objectIndex=i;
							}
						}
						break;
						
					case "right":
						entity.solidArea.x +=entity.speed;
						if(entity.solidArea.intersects(gp.obj[i].solidArea))
						{
							if(gp.obj[i].collision==true)
							{
								entity.collisionOn=true;
							}
							if(player==true)
							{
								objectIndex=i;
							}
						}
						break;
						
				
				}
			}
			entity.solidArea.y=entity.solidAreaDefaultY;
			entity.solidArea.x=entity.solidAreaDefaultX;
			
			 if(gp.obj[i] != null) {
		            
		            gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
		            gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
			 }
		}
		return objectIndex;
	}
	
	
	public int checkNpc(Entity entity,Entity [] dest)
	{
		
		int npcIndex=999;
		
		for(int i=0; i< dest.length;i++)
		{
			if( (dest[i] !=null))
			{
				entity.solidArea.y=entity.y+ entity.solidArea.y;
				entity.solidArea.x=entity.x + entity.solidArea.x;
				
				dest[i].solidArea.y=dest[i].y+dest[i].solidArea.y;
				dest[i].solidArea.x=dest[i].x+dest[i].solidArea.x;
			
				switch(entity.direction)
				{
					case "up":
						entity.solidArea.y -=entity.speed;
						if(entity.solidArea.intersects(dest[i].solidArea))
						{
							entity.collisionOn=true;
							npcIndex =i;
						}
						break;
					
					case "down":
						entity.solidArea.y +=entity.speed;
						if(entity.solidArea.intersects(dest[i].solidArea))
						{
							
								entity.collisionOn=true;
							
								npcIndex=i;
							
						}
						break;
						
					case "left":
						entity.solidArea.x -=entity.speed;
						if(entity.solidArea.intersects(dest[i].solidArea))
						{
							
								entity.collisionOn=true;
							
								npcIndex=i;
							
						}
						break;
						
					case "right":
						entity.solidArea.x +=entity.speed;
						if(entity.solidArea.intersects(dest[i].solidArea))
						{
							
								entity.collisionOn=true;
							
								npcIndex=i;
							
						}
						break;
						
				
				}
			}
			entity.solidArea.x=entity.solidAreaDefaultX;
			entity.solidArea.y=entity.solidAreaDefaultY;
			 if(dest[i] != null) {
				 dest[i].solidArea.x = dest[i].solidAreaDefaultX;
				 dest[i].solidArea.y = dest[i].solidAreaDefaultY;
		        }
		}
		return npcIndex;
	}

	public void checkPlayer(Entity entity)
	{
		entity.solidArea.y=entity.y+ entity.solidArea.y;
		entity.solidArea.x=entity.x + entity.solidArea.x;
		
		gp.player.solidArea.y=gp.player.y+gp.player.solidArea.y;
		gp.player.solidArea.x=gp.player.x+gp.player.solidArea.x;
	
		switch(entity.direction)
		{
			case "up":
				entity.solidArea.y -=entity.speed;
				if(entity.solidArea.intersects(gp.player.solidArea))
				{
					entity.collisionOn=true;
		
				}
				break;
			
			case "down":
				entity.solidArea.y +=entity.speed;
				if(entity.solidArea.intersects(gp.player.solidArea))
				{
					
						entity.collisionOn=true;
					
				
				}
				break;
				
			case "left":
				entity.solidArea.x -=entity.speed;
				if(entity.solidArea.intersects(gp.player.solidArea))
				{
					
						entity.collisionOn=true;
					
					
				}
				break;
				
			case "right":
				entity.solidArea.x +=entity.speed;
				if(entity.solidArea.intersects(gp.player.solidArea))
				{
					
						entity.collisionOn=true;
					
						
					
				}
				break;
				
		
		}
	
		
		
		entity.solidArea.y = entity.solidAreaDefaultY;
		entity.solidArea.x= entity.solidAreaDefaultX; 
		if(gp.player != null) {
			 
			 gp.player.solidArea.y = gp.player.solidAreaDefaultY;
			 gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		}
	}
	
	

}
