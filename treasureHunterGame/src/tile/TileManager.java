package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	
	public Tile[] tile;
	public int  mapTileNum[][];
	GamePanel gp;
	public  TileManager(GamePanel gp) {
		this.gp=gp; 
		tile =new Tile[20];
		
		mapTileNum=new int[gp.maxScreenCol][gp.maxScreenRow];
		getTileImage();
		String[] mapFiles = {"/maps/map01.txt", "/maps/map02.txt", "/maps/map03.txt","/maps/map04.txt","/maps/map05.txt"};
		Random random=new Random();
		 int randomIndex = random.nextInt(mapFiles.length);
		
		 String randomMapFile = mapFiles[randomIndex];
		 
	        loadMap(randomMapFile);
		 
	
	
	}
	
	public void getTileImage()
	{
		try {
			
			tile[0]=new Tile();
			tile[0].image=ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			

			tile[1]=new Tile();
			tile[1].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[1].collision=true;
			
			tile[2]=new Tile();
			tile[2].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tree (0_0).png"));

			tile[2].collision=true;
			
			tile[3]=new Tile();
			tile[3].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tree (0_1).png"));

			tile[3].collision=true;
			
			tile[4]=new Tile();
			tile[4].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tree (1_0).png"));

			tile[4].collision=true;
			
			tile[5]=new Tile();
			tile[5].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tree (1_1).png"));
		
			tile[5].collision=true;
			
			tile[6]=new Tile();
			tile[6].image=ImageIO.read(getClass().getResourceAsStream("/tiles/wallforgame.png"));
			
			tile[6].collision=true;
			
			tile[7]=new Tile();
			tile[7].image=ImageIO.read(getClass().getResourceAsStream("/tiles/mountain.jpg"));
			
			tile[7].collision=true;
			
			tile[8]=new Tile();
			tile[8].image=ImageIO.read(getClass().getResourceAsStream("/tiles/mountainwinter.jpg"));
			
			tile[8].collision=true;
			
			tile[9]=new Tile();
			tile[9].image=ImageIO.read(getClass().getResourceAsStream("/tiles/snowMountain(0_0).png"));
			
			tile[9].collision=true;
			
			tile[10]=new Tile();
			tile[10].image=ImageIO.read(getClass().getResourceAsStream("/tiles/snowMountain(0_1).png"));
			
			tile[10].collision=true;
			
			tile[11]=new Tile();
			tile[11].image=ImageIO.read(getClass().getResourceAsStream("/tiles/snowMountain(1_0).png"));
			
			tile[11].collision=true;
			
			tile[12]=new Tile();
			tile[12].image=ImageIO.read(getClass().getResourceAsStream("/tiles/snowMountain(1_1).png"));
			
			tile[12].collision=true;
			
			tile[13]=new Tile();
			tile[13].image=ImageIO.read(getClass().getResourceAsStream("/tiles/rock.png"));
			
			tile[13].collision=true;
			
			
			tile[14]=new Tile();
			tile[14].image=ImageIO.read(getClass().getResourceAsStream("/tiles/winterTree1.png"));
			
			tile[14].collision=true;
			
			tile[15]=new Tile();
			tile[15].image=ImageIO.read(getClass().getResourceAsStream("/tiles/snowRock.png"));
			tile[15].collision=true;
		}
		
		catch(IOException e)
		{
		e.printStackTrace();	
		}
	}
	
	public void loadMap(String filePath)
	{
		try {
			int col =0;
			int row=0;
			InputStream is =getClass().getResourceAsStream(filePath);	
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			
			while(col < gp.maxScreenCol &&row < gp.maxScreenRow) {
			
			String line=br.readLine();
			while (col <gp.maxScreenCol) {
				String numbers[]=line.split(" ");
				int number=Integer.parseInt(numbers[col]);
				mapTileNum [col][row] =number;
				col++;
				
				
			}
			if(col ==gp.maxScreenCol)
			{
				col=0;
				row++;
			}
			}
			br.close();
			
		}
		catch(Exception e)
		{
		
			
		}
	}
	public void draw(Graphics2D g2)
	{
		int row=0;
		int col=0;
		int x=0;
		int y=0;
		
		
		while(col < gp.maxScreenCol &&row < gp.maxScreenRow) {
			 		int tileNumber=mapTileNum[col][row];
			
					g2.drawImage(tile[tileNumber].image, x, y, gp.tileSize, gp.tileSize,null);
					col++;
					x +=gp.tileSize;
				if(col ==gp.maxScreenCol)
				{
					col=0;
					x=0;
					row++;
					y +=gp.tileSize;
				
				}
				
			
				
		}
		
	
	}
}
