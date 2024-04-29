package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_SilverChest extends SuperObject {

	public OBJ_SilverChest ()
	{
		
		name ="silver";
		try {
			
			image =ImageIO.read(getClass().getResourceAsStream("/objects/silverChest.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
