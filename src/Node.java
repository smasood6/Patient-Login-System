
public class Node<T> {

	private T data;
	private Node<T> link;
	
	public Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public Node<T> getLink(){
		return link;
	}
	
	public void setLink(Node<T> link) {
		this.link = link;
	}
}
