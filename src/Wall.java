import org.newdawn.slick.geom.Rectangle;

/**
 * The most exciting and functionality full class you will EVER see
 * @author Joel Hoskin
 *
 */
public class Wall extends Entity
{

	public Wall(Rectangle position)
	{
		this.position = position;
	}
	
	@Override
	public int getUpdatePriority()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
