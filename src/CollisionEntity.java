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
							System.out.println("The Entity has collided at " + Helper.slickRectangleRepresentation(entity.position));
							
							Moveable moveable = entity.getComponent(Moveable.class);
							
							Rectangle entityPosition = entity.getPosition();
							
							//There is a massive reason why I'm doing it this precise way and I'm feeling nice so I'll tell you
							//All the components of the entity will have updated before the collisions are resolved. This is required because it's position has to be updated before collisions can be 
							//resolved BUT that means the renderer component will also have already called. But the position is an Object so it's a reference type this means we can update the position
							//and then have the Renderer read the updated position but what I originally did was reassign the entities position. This is very wrong since the renderer would have a reference
							//to the old position.
							entity.getPosition().setX(entityPosition.getX() - moveable.getVelocity().getX());
							entity.getPosition().setY(entityPosition.getY() - moveable.getVelocity().getY());
							
							moveable.setVelocity(VectorHelper.zero());
							
							
						}
					}
				}
			}
		}
	}
	
	{
		
	}

}
