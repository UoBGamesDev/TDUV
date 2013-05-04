import java.util.Vector;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class KeyboardControlComponent
		extends
		Component
{

	private float speed;
	private Entity owner;

	public KeyboardControlComponent(Entity owner, float speed)
	{
		super(owner);
		this.owner = owner;
		this.speed = speed;
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{
		boolean keyPressed = false;
		
		Moveable moveable = owner.getComponent(Moveable.class);
		Vector2f velocity = moveable.getVelocity();
		

		if (gc.getInput().isKeyDown(Input.KEY_UP))
		{
			keyPressed = true;
			velocity.add(new Vector2f(0, -speed));
		}

		if (gc.getInput().isKeyDown(Input.KEY_DOWN))
		{
			keyPressed = true;
			velocity.add(new Vector2f(0, speed));
		}

		if (gc.getInput().isKeyDown(Input.KEY_LEFT))
		{
			keyPressed = true;
			velocity.add(new Vector2f(-speed, 0));
		}
		if (gc.getInput().isKeyDown(Input.KEY_RIGHT))
		{
			keyPressed = true;
			velocity.add(new Vector2f(speed, 0));
		}

		if (keyPressed)
		{
			moveable.setVelocity(VectorHelper.limit(velocity, speed));
		}
	}

}
