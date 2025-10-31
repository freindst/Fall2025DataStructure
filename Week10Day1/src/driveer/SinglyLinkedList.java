package driveer;

public class SinglyLinkedList {
	public Node Header;
	//public Node Tail;
	public Node Tail;
	
	public SinglyLinkedList() {
		this.Header = null;
	}
	
	//add a new node to the end to the list
	public boolean append(Node n) {
		if (n == null) {
			return false;
		}
		//if the header is null
		if (this.Header == null) {
			this.Header = n;
			return true;
		}
		//if the header is not null, we need to find the tail node, which the nextNode pointer is null
		else {
			Node tail = this.Header;
			while (tail.nextNode != null) {
				tail = tail.nextNode;
			}
			tail.nextNode = n;
			return true;
		}
	}
	
	//remove the last item
	public void removeTail() {
		//if preNode == null, ignore, nothing to delete
		if (this.Header == null) {
			return;	//there is nothing in the list, we just ignore this case;
		} else if (this.Header.nextNode == null) { //if preNode has nextNode, and nextNode is null
			//the list only contains one single item, which is the header
			this.Header = null;	//there is only one item, we just detach it
		} else {
			Node preNode = this.Header;	//this is the snapshot of the previous node of the tail node 
			Node nextNode = preNode.nextNode;	//we need to find the node that has no nextNode
			while (nextNode.nextNode != null) {
				preNode = nextNode;
				nextNode = preNode.nextNode;
			}
			preNode.nextNode = null;	//detach the tail from the preNode
		}
	}
	
	//insert newNode as the next node of preNode
	public boolean insertAfter(Node preNode, Node newNode) {
		if (preNode == null) {
			return false;	//it is a mistake, that you insert to an empty node
		}
		if (preNode.nextNode == null) {	//when preNode is the tail, just append newNode to preNode
			preNode.nextNode = newNode;
		} else {
			Node nextNode = preNode.nextNode;
			preNode.nextNode = newNode;
			newNode.nextNode = nextNode;
		}
		return true;
	}
	
	public boolean removeAfter(Node preNode) {
		if (preNode == null) {
			return false;
		}
		if (preNode.nextNode == null) {
			return true;
		} else {
			Node nextNode = preNode.nextNode;
			if (nextNode.nextNode == null) {
				preNode.nextNode = null;
				return true;
			} else {
				Node nextNextNode = nextNode.nextNode;
				preNode.nextNode = nextNextNode;
				nextNode.nextNode = null;	//why? it will be recognized by the garbage collector
				return true;
			}
		}
	}
	
	public boolean prepend(Node node) {
		//exception
		if (node == null) {
			return false;	//this is the C style of detection error
		}
		if (this.Header == null) {
			this.Header = node;
			return true;
		} else {
			//what if node is null
			node.nextNode = this.Header;	
			this.Header = node;
			return true;
		}
	}
	
	//search the value of the node
	//boolean: is the value on the list: 0 not on the list, 1 on the list
	//node: the item has the value. null not found, a valid object, first instance on the list. 
	//collection of the node: all the nodes have the value
	//linear search: array index
	//return the first matching value node
	public Node search(int value) {
		//case 1: list is empty
		if (this.Header == null) {
			return null;
		}
		//case 2l list is not empty
		Node node = this.Header;
		while (node != null && node.value != value) {
			node = node.nextNode;
		}
		return node;
	}
	
	//what is your choice in the algorithm
	//the best we know is the selection,which introduce least variables to implement
	public void sort() {
		
	}
	
	//get the node by 0-base index
	public Node get(int index) {
		//this will be O(n) operation
	}
	
	@Override 
	public String ToString(){
		if (this.Header == null) {
			print("empty");
		} else {
			//loop through one by one 
			string str = "";
			str = str + node.ToString();
		}
	}
}
