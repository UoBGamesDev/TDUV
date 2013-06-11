import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 * The player, or an enemy. Something that has health and can die.
 * 
 * 
 */

public class Player extends Entity {

    public Player() throws SlickException {
	add(new RenderComponent(this, new Sprite(new Image(
		"contents/circle.png"))));
	add(new Moveable(this));
	add(new KeyboardControlComponent(this, 10f));
	add(new FrictionComponent(this, 0.1f));
	
	add(new MouseFacerComponent(this));
	
	position = new Rectangle(60, 60, 40, 40);
    }

    @Override
    public int getUpdatePriority() {
	// TODO Auto-generated method stub
	return 0;
    }

}
