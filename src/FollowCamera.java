import java.awt.Point;
import java.awt.Rectangle;

public class FollowCamera extends Camera {

    private Entity following;
    private Rectangle screenSize;
    private Rectangle mapSize;

    public FollowCamera(Entity following, Rectangle screenSize,
	    Rectangle mapSize) {
	super();
	this.following = following;
	this.screenSize = screenSize;
	this.mapSize = mapSize;
    }

    @Override
    public Point getPosition() {
	float[] whyDidTheyDoThis = following.getPosition().getCenter();
	Point point = new Point((int) whyDidTheyDoThis[0],
		(int) whyDidTheyDoThis[1]);

	point.x -= (screenSize.width / 2);
	point.y -= (screenSize.height / 2);

	point.x = MathHelper
		.clamp(point.x, 0, mapSize.width - screenSize.width);
	point.y = MathHelper.clamp(point.y, 0, mapSize.height
		- screenSize.height);

	// System.out.println(point.x + point);

	return point;

    }

}
