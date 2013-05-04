import java.awt.Rectangle;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Renderer {

	private static PriorityQueue<DrawingInstruction> drawingQueue = new PriorityQueue<DrawingInstruction>(0, new Comparator<DrawingInstruction>() {

		@Override
		public int compare(DrawingInstruction drawing, DrawingInstruction other) {
			return Double.compare(drawing.getPriorty(), other.getPriorty());
		}
	});
	
	private Renderer()
	{
		
	}
	
	public static void render(DrawingInstruction d)
	{
		drawingQueue.add(d);
	}
	
	/**
	 * Don't call this method if you don't know what you're doing
	 * This does the actual drawing and should only ever be called by the entity manager
	 * 
	 * I've given it a scary name to deter people from calling it
	 */
	public static void flushRenderCache(EntityManager entityManager)
	{
		Rectangle camera = Camera.getCurrentCamera().getPosition();
		
		while(!drawingQueue.isEmpty())
		{
			//POP POP POP POP
			DrawingInstruction drawingInstructions = drawingQueue.remove();
			
			//BANANA BANANA BANANA
			//Okay actual comment time .....
			//Object position is where the object is in the world view
			Rectangle objectPosition = convertToAWTRectangle(drawingInstructions.getPosition());
			
			//Draw position is where the object will be drawn on screen once camera is applied
			Rectangle drawPosition = new Rectangle(objectPosition.x - camera.x, objectPosition.y - camera.y, objectPosition.width, objectPosition.height);
			
			drawingInstructions.getDrawable().render(drawPosition);
			
		}
	}
	
	/**
	 * There's a really good reason for this
	 * @return
	 */
	
	private static Rectangle convertToAWTRectangle(org.newdawn.slick.geom.Rectangle rectangle)
	{
		return new Rectangle((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
	}
	
}
