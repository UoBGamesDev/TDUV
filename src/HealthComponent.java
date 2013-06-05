import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

/**
 * 
 * A health component that stores the health of the entity. Once the health is
 * less than or equal to zero the entity is 'killed'.
 * 
 * @author James Shaw
 * 
 */

public class HealthComponent extends Component {

  private int health;
	private EntityManager entityManager = EntityManager.getEntityManager();
/**
 *  
 * @param owner -the entity that owns this component
 * @param health -initial health
 */
	public HealthComponent(Entity owner, int health) {
		super(owner);
		this.health = health;

	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		if (health <= 0) {
			entityManager.killEntity(owner);
		}

	}

}
