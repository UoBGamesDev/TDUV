import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class EntityManager {

    private static EntityManager entityManager = new EntityManager();
    private static List<Entity>toDelete = new ArrayList<Entity>();

    private SortedList<Entity> entities = new SortedList<Entity>(
	    new EntityComparer());

    private EntityManager() {

    }

    public void update(GameContainer gc, int delta) throws SlickException {
	for (Entity entity : entities) {
	    entity.update(gc, delta);
	}
	
	for(Entity e : toDelete)
	{
	    entities.remove(e);
	}

    }

    public void addEntity(Entity entity) {
	entities.add(entity);
    }

    public void killEntity(Entity entity) {
	toDelete.add(entity);
    }

    public static EntityManager getEntityManager() {
	return entityManager;
    }
    
    	public SortedList<Entity> getEntities() {
		return entities;
	}
}
