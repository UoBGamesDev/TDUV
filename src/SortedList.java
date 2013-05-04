import java.util.ArrayList;
import java.util.Comparator;

/**
 * WARNING, I HAVN'T OVERRIDDEN ANY METHODS I'VE NOT USED
 * @author Joel Hoskin
 *
 * @param <T>
 */
public class SortedList<T> extends ArrayList<T>
{
	private Comparator<T> comparator;
	
	public SortedList(Comparator<T> comparator)
	{
		this.comparator = comparator;
	}
	
	@Override
	public boolean add(T e)
	{
		//Iterate list
		for(int i = 0; i < size(); i++)
		{
			//If it finds a larger element insert it before that element
			if(comparator.compare(e, get(i)) <= 0)
			{
				add(i, e);
				return true;
			}
		}
		
		//Otherwise insert it at the end
		return super.add(e);
		
	}
	
}
