import java.awt.Rectangle;
import java.util.Vector;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * It's going to have entity movement behavior most probably enemy class will
 * use it only or any other entities that have movement but no harm.
 * 
 * @author Shahzad
 * 
 */

public class AIBehaviorComponent extends Component {

  public enum BehaviorType {
		TopDown, LeftRight, AppraochEntity, AttackEntity, FollowEntity, None, Changing
	}

	private float speed;
	private Entity owner;
	private BehaviorType AIBehaviorType;

	/*
	 * Variables that will help implementing logic of different behaviors
	 */
	// **************************************************************//
	private boolean TopOrDown; // connected with TopDown Behavior, true stands
								// for moving top
	private float TopLimit;
	private float BottomLimit;

	// **************************************************************//
	public AIBehaviorComponent(Entity owner, BehaviorType b) {
		super(owner);
		this.owner = owner;
		AIBehaviorType = b;
	}

	public void SetAIBehaviorType(BehaviorType b) {
		AIBehaviorType = b;
		setTopOrDown(true);
	}

	public BehaviorType GetAIBehaviorType() {
		return AIBehaviorType;
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {

		Moveable moveable = owner.getComponent(Moveable.class);
		Vector2f velocity = moveable.getVelocity();

		if (AIBehaviorType == BehaviorType.None) {
			return;
		} else if (AIBehaviorType == BehaviorType.TopDown) {
			float y = owner.getPosition().getY();
			if (TopOrDown) {
				if (y > TopLimit) 
					velocity.add(new Vector2f(0, -speed));
				 else
					TopOrDown = false;
			} else {
				if (y < BottomLimit)
					velocity.add(new Vector2f(0, speed));
				else
					TopOrDown = true;
			}
			moveable.setVelocity(VectorHelper.limit(velocity, speed));
		}
		

	}

	public float getBottomLimit() {
		return BottomLimit;
	}

	public void setBottomLimit(float bottomLimit) {
		BottomLimit = bottomLimit;
	}

	/**
	 * @return the topLimit
	 */
	public float getTopLimit() {
		return TopLimit;
	}

	/**
	 * @param topLimit
	 *            the topLimit to set
	 */
	public void setTopLimit(float topLimit) {
		TopLimit = topLimit;
	}

	/**
	 * @return the topOrDown
	 */
	public boolean isTopOrDown() {
		return TopOrDown;
	}

	/**
	 * @param topOrDown
	 *            the topOrDown to set
	 */
	public void setTopOrDown(boolean topOrDown) {
		TopOrDown = topOrDown;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
