import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Character extends Entity {

	//SHRIMP SHRIMP SHRIMP
	public Character() throws SlickException
	{
		add(new RenderComponent(this, new Sprite(new Image(""))));
	}

	@Override
	public int getUpdatePriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
