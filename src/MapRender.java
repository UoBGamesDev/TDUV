import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

/**
 * 
 * @author Joel Hoskin
 * 
 */
public class MapRender extends Component {

    private TiledMapRender mapRenderer;

    public MapRender(Entity owner, TiledMap map) {
	super(owner);
	mapRenderer = new TiledMapRender(map);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
	Renderer.render(new DrawingInstruction(mapRenderer, new Rectangle(0, 0,
		0, 0), -1));
    }

}
