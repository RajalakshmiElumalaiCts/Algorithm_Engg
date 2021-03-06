package hw1.pojo;

public class Node {
	private int data;
	private Node nextNode;
	
	public Node() {
		
	}
	
	public Node(int dataField) {
		data = dataField;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "Node [data=" + data +  "]";
	}

}
