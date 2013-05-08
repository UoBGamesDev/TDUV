import java.awt.Rectangle;

import org.newdawn.slick.Image;

/**
 * The image, and where to render it.
 * 
 * @author James Moulang
 */
public class Sprite implements IDrawable {

    private Image image;

    public Sprite(Image image) {
	this.image = image;
    }

    @Override
    public void render(Rectangle position) {
	image.draw(position.x, position.y, position.width, position.height);
    }

}
