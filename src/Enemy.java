
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


/**
 * This class represents enemy having rendering, movement and frication components &
 * some AI implementation
 * @author Shahzad
 *
 */
public class Enemy extends Entity{
  
	public Enemy() throws SlickException {
		add(new RenderComponent(this, new Sprite(new Image("contents/enemy.png"))));
		add(new Moveable(this));
		add(new FrictionComponent(this, 0.1f));
		add(new AIBehaviorComponent(this,AIBehaviorComponent.BehaviorType.None));
		position = new Rectangle(500,80,40,40);
		
	    }
	public int getUpdatePriority(){
		
		return 0;
	}

}
