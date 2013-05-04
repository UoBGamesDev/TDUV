import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Character extends Entity {

	//SHRIMP SHRIMP SHRIMP
	public Character() throws SlickException
	{
		add(new RenderComponent(this, new Sprite(new Image("contents/circle.png"))));
		add(new Moveable(this));
		add(new KeyboardControlComponent(this, 2f));
		add(new FrictionComponent(this, 0.1f));
		position = new Rectangle(50, 50, 20, 20);
	}

	@Override
	public int getUpdatePriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
