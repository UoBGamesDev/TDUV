import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class CollisionComponent extends Component {

    private EntityManager entityManager = EntityManager.getEntityManager();

    private SortedList<Entity> entities = entityManager.getEntities();

    public CollisionComponent(Entity owner) {
	super(owner);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
	for (Entity entity : entities) {
	    // if the entity is not itself
	    if (!entity.equals(owner)) {
		System.out.println("halp");
		// if the entity intersects another entity
//		if (true) {
		    Moveable moveableColl = owner.getComponent(Moveable.class);
		    org.newdawn.slick.geom.Vector2f velocity = moveableColl
			    .getVelocity();
		    velocity.x = -velocity.x;
		    velocity.y = -velocity.y;
		    moveableColl.setVelocity(velocity);
//		}
	    }
	}

	/*
	 * for (entity that has Moveable Component) if(intersection occurs)
	 * movable entity previous position = -velocity
	 */

    }

}