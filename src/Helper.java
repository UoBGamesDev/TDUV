import org.newdawn.slick.geom.Rectangle;


public class Helper
{
	public static String slickRectangleRepresentation(Rectangle r)
	{
		return "x: " + r.getX() + " y: " + r.getY() + " width: " + r.getWidth() + " height: " + r.getHeight();
	}
}
