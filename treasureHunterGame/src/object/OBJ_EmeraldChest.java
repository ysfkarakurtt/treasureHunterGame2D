package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_EmeraldChest extends SuperObject{

	
	public OBJ_EmeraldChest()
	{
		name ="emerald";
		try {
			
			image =ImageIO.read(getClass().getResourceAsStream("/objects/emeraldChest.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
