import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 * A behaviour e.g. moves back and forth, seeks out player etc. Belongs to an
 * entity.
 * 
 * @author Joel
 */

public abstract class Component {

    protected Entity owner;

    public Component(Entity owner) {
	this.owner = owner;
    }

    public abstract void update(GameContainer gc, int delta)
	    throws SlickException;

}
