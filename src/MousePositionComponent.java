import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class MousePositionComponent extends Component {

    public MousePositionComponent(Entity owner) {
	super(owner);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
	Rectangle mousePos = new Rectangle(gc.getInput().getMouseX(), gc
		.getInput().getMouseY(), 0, 0);
	owner.setPosition(mousePos);
    }

}
