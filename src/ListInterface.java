
public interface ListInterface<T> {
	//method headings which are the requirements for the class that
			//chooses to implement this interface
			
			public void add(T item);
			//Adds an item to the list
			
			public boolean remove(T item);
			//if this item exists on the list then remove it and return true
			//otherwise return false without changing the list
			
			public boolean find(T item);
			//if this item exists on the list return true
			//otherwise return false
			
			public String toString();
			//returns all items in the list as a String
			
}
