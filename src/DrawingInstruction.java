import org.newdawn.slick.geom.Rectangle;

/**
 * An instruction for the final rendering pass. Contains the position and
 * priority (i.e. layer) of the instruction, and an IDrawable (which can be a
 * sprite, a map, anything drawable basically)
 * 
 * @author Joel
 * 
 */
public class DrawingInstruction {

	private IDrawable drawable;
	private Rectangle position;
	private int priorty;

	public DrawingInstruction(IDrawable drawable, Rectangle position,
			int priorty) {
		this.drawable = drawable;
		this.priorty = priorty;
		this.position = position;
	}

	public IDrawable getDrawable() {
		return drawable;
	}

	public int getPriorty() {
		return priorty;
	}

	public Rectangle getPosition() {
		return position;
	}

}