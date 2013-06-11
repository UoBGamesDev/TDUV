import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class Map extends Entity {

    public Map(TiledMap map) {
	add(new MapRender(this, map));
	addWalls(map);
    }

    @Override
    public int getUpdatePriority() {
	return 0;
    }
    
    private void addWalls(TiledMap map)
    {
    	final int WALL_COLLISION_LAYER = 0;
    	for(int i = 0; i < map.getObjectCount(WALL_COLLISION_LAYER); i++)
    	{
    		EntityManager.getEntityManager().addEntity(new Wall(getObjectLocation(map, WALL_COLLISION_LAYER, i)));
    	}
    	
    }
    
    private Rectangle getObjectLocation(TiledMap map, int layer, int id)
    {
    	//TODO: Pull the latest version of Slick and make some improvements to the TiledMap class, since the arguments aren't named and half the methods don't work
    	return new Rectangle(map.getObjectX(layer, id), map.getObjectY(layer, id), map.getObjectWidth(layer, id), map.getObjectHeight(layer, id));
    }

}
