package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_CopperChest extends SuperObject {

	
	public OBJ_CopperChest()
	{
		name ="copper";
		try {
			
			image =ImageIO.read(getClass().getResourceAsStream("/objects/copperChest.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
