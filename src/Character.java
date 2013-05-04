import org.newdawn.slick.Image;


public class Character extends Entity {

	//SHRIMP SHRIMP SHRIMP
	public Character()
	{
		add(new RenderComponent(this, new Sprite(new Image(""))));
	}

	@Override
	public int getUpdatePriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
