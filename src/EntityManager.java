import java.util.TreeSet;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;


public class EntityManager {

	private TreeSet<Entity>entities = new TreeSet<Entity>(new EntityComparer());
	
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
}
