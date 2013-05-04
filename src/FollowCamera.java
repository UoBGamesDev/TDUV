import java.awt.Rectangle;


public class FollowCamera extends Camera
{
	private Entity following;
	private Rectangle screensize;
	
	public FollowCamera(Entity following, Rectangle screensize)
	{
		super();
		this.following = following;
		this.screensize = screensize;
	}



	@Override
	public Rectangle getPosition()
	{
		float[] playerPosition = following.getPosition().getCenter();
		
		
		int cameraX = (int) (playerPosition[0] - (screensize.getX() / 2));
		int cameraY = (int) (playerPosition[1] - (screensize.getY() / 2));
		
		
		return new Rectangle(cameraX, cameraY, screensize.width, screensize.height);
		
	}
	
	
}
