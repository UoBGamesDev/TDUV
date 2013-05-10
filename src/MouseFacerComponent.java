import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class MouseFacerComponent extends Component {

    
    
    public MouseFacerComponent(Entity owner) {
	super(owner);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
	
	Point cameraPosition = Camera.getCurrentCamera().getPosition();
	
	Vector2f mousePos = new Vector2f(gc.getInput().getMouseX() + cameraPosition.x, gc
		.getInput().getMouseY() + cameraPosition.y);
	Vector2f followerPos = new Vector2f(owner.getPosition().getX(), owner
		.getPosition().getY());

	double xDiff = mousePos.x - followerPos.x;
        double yDiff = mousePos.y - followerPos.y;
        owner.setRotation((float) Math.toDegrees(Math.atan2(yDiff, xDiff)) );
        
        System.out.println( Math.toDegrees(Math.atan2(yDiff, xDiff)));
    }

}