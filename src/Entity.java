import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 * Something in the game that has a behaviour, e.g. an enemy, a health pack, a
 * moving platform etc. Each of its components is a separate behaviour, and
 * updating the entity is equivalent to updating each one of its behaviours.
 * 
 * @author Joel Hoskin
 */

public abstract class Entity {

    protected List<Component> components = new LinkedList<Component>();

    protected Rectangle position = null;
    
    protected float rotation = 0;

    protected void add(Component c) {
	components.add(c);
    }

    public void update(GameContainer gc, int delta) throws SlickException {
	for (Component c : components) {
	    c.update(gc, delta);
	}
    }

    /**
     * Lower numbers are higher priority
     * @return
     */
    public abstract int getUpdatePriority();

    public Rectangle getPosition() {
	return position;
    }

    public void setPosition(Rectangle position) {
	this.position = position;
    }
    
    public float getRotation() {
	return rotation;
    }
    
    public void setRotation(float rotation) {
	this.rotation = rotation;
    }

    // Please feel free to tidy this up if you can find a work around for Type
    // Erasure
    /**
     * Debug Hint: This wont search for subclasses of the class you pass this
     * @param componentType
     * @return
     * @throws SlickException
     */
    @SuppressWarnings("unchecked")
    public <T> T getComponent(Class<T> componentType) throws SlickException {
	for (Component c : components) {
	    if (c.getClass() == componentType) {
		return (T) c;
	    }
	}

	throw new SlickException("No component of type " + componentType
		+ "found in " + this.getClass());
    }
    
    @SuppressWarnings("unchecked")
    public <T> boolean hasComponent(Class<T> componentType) throws SlickException {
	for (Component c : components) {
	    if (c.getClass() == componentType) {
		return true;
	    }
	}

	return false;
    }
    
    

}
