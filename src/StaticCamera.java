import java.awt.Rectangle;


public class StaticCamera extends Camera {

	private final Rectangle position;
	
	public StaticCamera(Rectangle position)
	{
		this.position = position;
	}
	
	@Override
	public Rectangle getPosition() {
		return position;
	}


}
