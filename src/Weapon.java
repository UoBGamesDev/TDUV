import org.newdawn.slick.geom.Vector2f;


public abstract class Weapon {
    
    private Entity owner;
    
    public Weapon(Entity owner)
    {
	this.owner = owner;
    }
    
    public abstract void shootWeapon(Vector2f location);
}
