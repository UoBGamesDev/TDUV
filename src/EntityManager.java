import java.util.TreeSet;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;


public class EntityManager {

	private SortedList<Entity>entities = new SortedList<Entity>(new EntityComparer());
	
	public void update(GameContainer gc, int delta) throws SlickException
	{
		for(Entity entity : entities)
		{
			entity.update(gc, delta);
		}
		
	}
	
	public void addEntity(Entity entity)
	{
		entities.add(entity);
	}
	
	public void killEntity(Entity entity)
	{
		entities.remove(entity);
	}
}
