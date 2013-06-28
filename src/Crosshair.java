import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 * The player, or an enemy. Something that has health and can die.
 * 
 * 
 */

public class Crosshair extends Entity {

    public Crosshair() throws SlickException {
	add(new RenderComponent(this, new Sprite(new Image(
		"contents/crosshair.png"))));
	add(new MousePositionComponent(this));
	add(new Moveable(this));
	position = new Rectangle(200, 200, 200, 200);
    }

    @Override
    public int getUpdatePriority() {
	// TODO Auto-generated method stub
	return 0;
    }

}
