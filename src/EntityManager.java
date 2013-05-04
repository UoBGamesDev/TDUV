import java.util.TreeSet;

import org.newdawn.slick.GameContainer;


public class EntityManager {

	private TreeSet<Entity>entities = new TreeSet<>(new EntityComparer());
	
	public void update(GameContainer gc, int delta)
	{
		for(Entity entity : entities)
		{
			entity.update(gc, delta);
		}
		
		Renderer.flushRenderCache(this);
	}
	
	public void addEntity(Entity entity)
	{
		entities.add(entity);
	}
}
