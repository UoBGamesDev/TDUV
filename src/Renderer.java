import java.awt.Rectangle;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The final port of call for rendering stuff. Everything gets rendered in one
 * fell swoop as it's stored in the PriorityQueue (priority being layer) and
 * then popped off and actually drawn.
 * 
 * @author Joel
 * 
 */

public class Renderer {

	private static PriorityQueue<DrawingInstruction> drawingQueue = new PriorityQueue<DrawingInstruction>(
			1, new Comparator<DrawingInstruction>() {

				@Override
				public int compare(DrawingInstruction drawing,
						DrawingInstruction other) {
					return Double.compare(drawing.getPriorty(),
							other.getPriorty());
				}
			});

	private Renderer() {

	}

	/**
	 * Adds a drawing instruction to the queue. It'll be rendered when the final
	 * render call comes around at the end of each game loop.
	 * 
	 * @param d
	 */
	public static void render(DrawingInstruction d) {
		drawingQueue.add(d);
	}

	/**
	 * Don't call this method if you don't know what you're doing. This does the
	 * actual drawing and should only ever be called by the entity manager
	 * 
	 * I've given it a scary name to deter people from calling it
	 */
	public static void flushRenderCache() {

		Rectangle camera = Camera.getCurrentCamera().getPosition();

		while (!drawingQueue.isEmpty()) {

			DrawingInstruction drawingInstructions = drawingQueue.remove();

			// Object position is where the object is in the world view
			Rectangle objectPosition = convertToAWTRectangle(drawingInstructions
					.getPosition());

			Rectangle drawPosition = new Rectangle(objectPosition.x,
					objectPosition.y, objectPosition.width,
					objectPosition.height);

			drawingInstructions.getDrawable().render(drawPosition);
		}
	}

	// Slick and AWT have rectangles of the same name... helpful.
	private static Rectangle convertToAWTRectangle(
			org.newdawn.slick.geom.Rectangle rectangle) {
		return new Rectangle((int) rectangle.getX(), (int) rectangle.getY(),
				(int) rectangle.getWidth(), (int) rectangle.getHeight());
	}

}
