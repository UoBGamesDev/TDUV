import java.awt.Rectangle;


public abstract class Camera {

	private static Camera currentCamera;

	public static Camera getCurrentCamera() {
		return currentCamera;
	}
	
	
	public abstract Rectangle getPosition();
	
}
