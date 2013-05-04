import org.newdawn.slick.tiled.TiledMap;

public class Map extends Entity
{

	public Map(TiledMap map)
	{
		add(new MapRender(this, map));
	}
	
	@Override
	public int getUpdatePriority()
	{
		return 0;
	}




}
