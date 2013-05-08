////Immutable because I'm cool
//public class Vector {
//	
//	public final float X;
//	public final float Y;
//	
//	public static final Vector ZERO = new Vector(0, 0);
//	
//	public Vector(float x, float y)
//	{
//		this.X = x;
//		this.Y = y;
//	}
//	
//    public PolarCoordinate toPolar()
//    {
//
//        float r = (float)Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
//        float origin = (float)Math.atan(Y / X);
//
//        //Corrects angle returned by Math.Atan
//        if (X < 0)
//        {
//            origin += Math.PI;
//        }
//
//
//        return new PolarCoordinate(r, origin);
//
//    }
//    
//    public Vector shorten(float maxLength)
//    {
//        if (vector.Length() > maxLength)
//        {
//            float currentOrigin = vector.toPolar().origin;
//
//            vector = new PolarCoordinate(maxLength, currentOrigin).toCartesian();
//        }
//
//        return vector;
//    }
// }
