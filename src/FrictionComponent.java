import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

//Can I just say at this point that I really love the whole entity component thing
public class FrictionComponent
		extends
		Component
{

	private float frictionStrength;

	public FrictionComponent(Entity owner, float frictionStrength)
	{
		super(owner);
		this.frictionStrength = frictionStrength;
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{

		Moveable moveable = owner.getComponent(Moveable.class);
		
		Vector2f frictionVector = new Vector2f(moveable.getVelocity());
		
		frictionVector.x *= frictionStrength;
		frictionVector.y *= frictionStrength;
		
		moveable.setVelocity(moveable.getVelocity().sub(frictionVector));
		
	}

}
