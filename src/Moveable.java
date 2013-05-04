import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

public class Moveable
		extends
		Component
{

	private Vector2f velocity = new Vector2f(0, 0);

	public Moveable(Entity owner)
	{
		super(owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(GameContainer gc, int delta)
	{
		System.out.println(velocity);
		
		// In C# you can overload operators >_>
		owner.getPosition().setLocation(owner.getPosition().getX()
				+ velocity.x, owner.getPosition().getY()
				+ velocity.y);
	}

	public Vector2f getVelocity()
	{
		return velocity;
	}

	public void setVelocity(Vector2f velocity)
	{
		this.velocity = velocity;
	}

}
