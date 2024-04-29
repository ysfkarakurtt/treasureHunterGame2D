package main;

import entity.Entity;
import entity.NPC_DrHeinzDoofenshmirtz;
import entity.NPC_DrHeinzMachine;
import object.OBJ_CopperChest;
import object.OBJ_EmeraldChest;
import object.OBJ_GoldChest;
import object.OBJ_SilverChest;
public class AssetSetter {

	GamePanel gp;
	public AssetSetter(GamePanel gp)
	{
		this.gp=gp;
	}
	
	public void setObject()
	{
		gp.obj[0]=new OBJ_SilverChest();
		gp.obj[0].worldX =4 *gp.tileSize;
		gp.obj[0].worldY=7 *gp.tileSize;
		
		
		gp.obj[1]=new OBJ_GoldChest();
		gp.obj[1].worldX =3 *gp.tileSize;
		gp.obj[1].worldY=1 *gp.tileSize;
		
		gp.obj[2]=new OBJ_CopperChest();
		gp.obj[2].worldX =8 *gp.tileSize;
		gp.obj[2].worldY=2 *gp.tileSize;
		
		gp.obj[3]=new OBJ_EmeraldChest();
		gp.obj[3].worldX =8 *gp.tileSize;
		gp.obj[3].worldY=9 *gp.tileSize;
		
		
	}
	public void setNPC()
	{
		gp.npc[0] = new NPC_DrHeinzDoofenshmirtz(gp);
		gp.npc[0].x=gp.tileSize*8;
		gp.npc[0].y=gp.tileSize*7;
		gp.npc2[0] = new NPC_DrHeinzMachine(gp);
		gp.npc2[0].x=gp.tileSize*12;
		gp.npc2[0].y=gp.tileSize*10;
		
	}
}
