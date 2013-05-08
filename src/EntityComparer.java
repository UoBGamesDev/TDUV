import java.util.Comparator;

public class EntityComparer implements Comparator<Entity> {

    @Override
    public int compare(Entity entity, Entity other) {
	if (entity.getUpdatePriority() > other.getUpdatePriority()) {
	    return 1;
	} else if (entity.getUpdatePriority() < other.getUpdatePriority()) {
	    return -1;
	} else {
	    return 0;
	}
    }

}