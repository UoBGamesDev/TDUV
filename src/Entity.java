import java.util.LinkedList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


/**BANANA BANANA BANANA 
 * @author Joel Hoskin
 * How do you like these Apples Tristan?
 */

public abstract class Entity {
	
	protected List<Component>components = new LinkedList<Component>();
	
	protected Rectangle position = null;
	
	
	protected void add(Component c) {
		components.add(c);
	}
	
	public void update(GameContainer gc, int delta) throws SlickException
	{
		for(Component c : components)
		{
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
	
	//Please feel free to tidy this up if you can find a work around for Type Erasure
	@SuppressWarnings("unchecked")
	public <T> T getComponent(Class<T> componentType) throws SlickException
	{	
		for(Component c : components)
		{
			if(c.getClass() == componentType)
			{
				return (T) c;
			}
		}
		
		throw new SlickException("No component of type " + componentType + "found in " + this.getClass());
	}
	
}
