import java.awt.Point;


public class StaticCamera extends Camera {

	private final Point position;
	
	public StaticCamera(Point position)
	{
		this.position = position;
	}
	
	@Override
	public Point getPosition() {
		return position;
	}


}
