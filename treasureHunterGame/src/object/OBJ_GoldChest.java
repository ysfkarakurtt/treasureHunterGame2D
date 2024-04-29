package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_GoldChest extends SuperObject{
	
	public OBJ_GoldChest()
	{
		name ="gold";
		try {
			
			image =ImageIO.read(getClass().getResourceAsStream("/objects/goldChest.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
