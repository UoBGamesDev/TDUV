import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class CollisionEntity
		extends
		Entity
{

	@Override
	public int getUpdatePriority()
	{
		return 5;
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{

		for (Entity entity : EntityManager.getEntityManager().getEntities())
		{
			if (entity.hasComponent(Moveable.class))
			{
				for (Entity possibleCollision : EntityManager.getEntityManager().getEntities())
				{
					if (possibleCollision != entity && possibleCollision.position != null)
					{
						if (entity.position.intersects(possibleCollision.position))
						{
							Moveable moveable = entity.getComponent(Moveable.class);
							
							Rectangle entityPosition = entity.getPosition();
							
							entity.setPosition(new Rectangle(entityPosition.getX() - moveable.getVelocity().getX(), entityPosition.getY() - moveable.getVelocity().getY(), entityPosition.getWidth(), entityPosition.getHeight()));
							
							moveable.setVelocity(VectorHelper.zero());
							
							
						}
					}
				}
			}
		}
	}
	
	private static void printSlickRectangle(Rectangle r)
	{
		System.out.println("x: " + r.getX() + " y: " + r.getY() + " width: " + r.getWidth() + " height: " + r.getHeight());
	}
	{
		
	}

}
