import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 * The player, or an enemy. Something that has health and can die.
 * 
 * 
 */

public class Character extends Entity {

	public Character() throws SlickException {
		add(new RenderComponent(this, new Sprite(new Image(
				"contents/circle.png"))));
		add(new Moveable(this));
		add(new KeyboardControlComponent(this, 10f));
		add(new FrictionComponent(this, 0.1f));
		position = new Rectangle(40, 40, 40, 40);
	}

	@Override
	public int getUpdatePriority() {
		// TODO Auto-generated method stub
		return 0;
	}

}
