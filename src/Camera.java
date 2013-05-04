import java.awt.Rectangle;


public abstract class Camera {

	private static Camera currentCamera;

	public static Camera getCurrentCamera() {
		return currentCamera;
	}
	
	public static void setCurrentCamera(Camera currentCamera) {
		Camera.currentCamera = currentCamera;
	}
	
	
	public abstract Rectangle getPosition();


	
	
	
	
}
