import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * An example of some JUnit
 * @author Joel Hoskin
 *
 */
public class SortedListTest {

	private SortedList<Entity> createEntityList() {
		SortedList<Entity> entities = new SortedList<Entity>(
				new EntityComparer());

		entities.add(new Entity() {

			@Override
			public int getUpdatePriority() {
				// TODO Auto-generated method stub
				return 0;
			}
		});

		entities.add(new Entity() {

			@Override
			public int getUpdatePriority() {
				// TODO Auto-generated method stub
				return 1;
			}
		});

		entities.add(new Entity() {

			@Override
			public int getUpdatePriority() {
				// TODO Auto-generated method stub
				return 2;
			}
		});

		entities.add(new Entity() {

			@Override
			public int getUpdatePriority() {
				// TODO Auto-generated method stub
				return -1;
			}
		});

		return entities;
	}

	@Test
	public void testInsertion() {
		SortedList<Entity> enTITies = createEntityList();
		Assert.assertTrue("Sorted list not sorted", sorted(enTITies));
	}

	private boolean sorted(List<Entity> e) {
		int previousInt = Integer.MIN_VALUE;

		for (Entity ent : e) {
			if (ent.getUpdatePriority() < previousInt) {
				return false;
			}
		}

		return true;
	}

	@Test
	public void testDeletion() {
		SortedList<Entity> enTITies = createEntityList();
		enTITies.remove(1);
		Assert.assertTrue(sorted(enTITies));
	}

}
