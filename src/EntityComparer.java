import java.util.Comparator;


public class EntityComparer implements Comparator<Entity>{

	@Override
	public int compare(Entity entity, Entity other) {
		return Integer.compare(entity.getUpdatePriority(), other.getUpdatePriority());
	}

	
}
