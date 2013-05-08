import java.awt.Rectangle;

import org.newdawn.slick.tiled.TiledMap;

/**
 * A map and where to render it.
 * 
 * @author james
 * 
 */
public class TiledMapRender implements IDrawable {

    private TiledMap map;

    public TiledMapRender(TiledMap map) {
	this.map = map;
    }

    /**
     * Feed the position of the world in the topleft corner
     */
    @Override
    public void render(Rectangle position) {
	map.render(0 + position.x, 0 + position.y);
    }

}
