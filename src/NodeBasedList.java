
public class NodeBasedList<T>implements ListInterface<T> {
	//instance variables
	private int numberOfItems;
	private Node<T> list;
	
	//default constructor
	public NodeBasedList() {
		super();
		numberOfItems = 0;
		list = null;
	}
	
	@Override
	public void add(T item) {
		// TODO Auto-generated method stub
		Node<T> currentNode = new Node<T>(item);
		if(numberOfItems == 0 && list == null) {
			list = currentNode;
			numberOfItems++;
		}
		else {
			currentNode.setLink(list);
			list = currentNode;
			numberOfItems++;
		}
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		boolean removed = false;
		Node<T> currentNode = locate(item);
		if(currentNode != null) {
			//delete the item from the list
			if(currentNode == list) {
				list = list.getLink();
				removed = true;
			}
			else {
				Node<T> previousNode = list;
				while(previousNode.getLink() != currentNode) {
					previousNode = previousNode.getLink();
				}
				previousNode.setLink(currentNode.getLink());
				currentNode.setLink(null);
				removed = true;
				numberOfItems--;
			}
		}
		return removed;
	}
	
	public Node<T> locate(T item) {
		boolean found = false;
		Node<T> currentNode = list;
		while(!found && currentNode != null) {
			if(currentNode.getData().equals(item)) {
				found = true;
			}
			else {
				currentNode = currentNode.getLink();
			}
		}
		return currentNode;
	}

	@Override
	public boolean find(T item) {
		// TODO Auto-generated method stub
		boolean found = false;
		Node<T> currentNode = locate(item);
		if(currentNode != null) {
			found = true;
		}
		return found;
	}
	
	public String toString() { 
		String allItems = "";
		Node<T> currentNode = list;
		while(currentNode != null) {
			allItems = allItems + currentNode.getData().toString();
			currentNode = currentNode.getLink();
		}
		return allItems;
	}
	
	public int numOfItems() {
		return numberOfItems;
	}
	
	public T get(int index) {
		if(index>numberOfItems) {
			return null;
		}
		else {
			int i = 0;
			T data = list.getData();
			Node<T> temp = list;
			while(i<index) {
				temp = temp.getLink();
				data = temp.getData();
				i++;
			}
			return data;
			
		}
	}

}
