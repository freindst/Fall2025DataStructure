package driveer;

public class Node {
	//public static String name = "node1";	//global, class
	//properties, attributes
	public int value;	//instance, dynamic, heap
	//pointer to the next node
	public Node nextNode;
	
	//constructor: create new instance, also initiate the properties value
	public Node() {
		this.value = 0;
		this.nextNode = null;
	}
	
	
	public Node(int value) {
		this.value = value;
		this.nextNode = null;
	}
	
	@Override
	public String toString() {
		return "" + this.value;
	}
}
