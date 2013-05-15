import java.util.Vector;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * WASD control of an entity's position. Doesn't stop the entity moving when the
 * keys are let go of, that is handled by FrictionComponent
 * 
 * @author Joel
 * 
 */

public class KeyboardControlComponent extends Component {

    private float speed;
    private Entity owner;

    public KeyboardControlComponent(Entity owner, float speed) {
	super(owner);
	this.owner = owner;
	this.speed = speed;
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
	boolean keyPressed = false;

	Moveable moveable = owner.getComponent(Moveable.class);
	Vector2f velocity = moveable.getVelocity();

	if (gc.getInput().isKeyDown(Input.KEY_W)) {
	    keyPressed = true;
	    velocity.add(new Vector2f(0, -speed));
	}

	if (gc.getInput().isKeyDown(Input.KEY_S)) {
	    keyPressed = true;
	    velocity.add(new Vector2f(0, speed));
	}

	if (gc.getInput().isKeyDown(Input.KEY_A)) {
	    keyPressed = true;
	    velocity.add(new Vector2f(-speed, 0));
	}
	if (gc.getInput().isKeyDown(Input.KEY_D)) {
	    keyPressed = true;
	    velocity.add(new Vector2f(speed, 0));
	}

	if (keyPressed) {
	    moveable.setVelocity(VectorHelper.limit(velocity, speed));
	}
    }
}
