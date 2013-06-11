import org.newdawn.slick.geom.Vector2f;

public class VectorHelper {
    public static Vector2f limit(Vector2f vector, float maxLength) {
	float length = vector.length();
	if (length > maxLength) {
	    vector.set(vector.normalise());
	    vector.x *= maxLength;
	    vector.y *= maxLength;
	}

	return vector;
    }

    public static Vector2f createVectorFromPolarCoordinate(float length,
	    float angle) {
	float x = (float) (length * Math.cos(angle));
	float y = (float) (length * Math.sin(angle));
	return new Vector2f(x, y);
    }
    
    public static Vector2f zero()
    {
    	return new Vector2f(0,0);
    }
}
