import java.security.acl.Owner;

import org.newdawn.slick.GameContainer;

public class RenderComponent extends Component {

    private IDrawable drawable;

    public RenderComponent(Entity owner, IDrawable drawable) {
	super(owner);
	this.drawable = drawable;
    }

    @Override
    public void update(GameContainer gc, int delta) {
	Renderer.render(new DrawingInstruction(drawable, owner.getPosition(), 0));
    }

}
