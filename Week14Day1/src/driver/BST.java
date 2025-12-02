package driver;

public class BST {
	public Node Root;
	
	public BST() {
		this.Root = null;
	}
	
	//if the value is on the BST, return the node, otherwise., return null
	public Node Search(int Value) {
		return SearchHelper(Value, this.Root);
	}
	
	public Node SearchHelper(int Value, Node node) {
		if (node == null) {
			return null;
		} else if (node.Payload == Value) {
			return node;
		} else if (node.Payload > Value) {
			return SearchHelper(Value, node.LeftNode);
		} else {
			return SearchHelper(Value, node.RightNode);
		}
	}
	
	//0. if root is null, make the new node to be the root
	//1. check the node recursively. no node, add, equal, ignore, less, left, larger, right.
	public void Insert(int Value) {
		if (this.Root == null) {
			Node newNode = new Node();
			newNode.Payload = Value;
			this.Root = newNode;
		} else {
			InsertHelper(Value, this.Root);
		}
	}
	
	//node is the parent node
	public void InsertHelper(int Value, Node node) {
		if (node.Payload == Value) {
			return;
		} else {
			Node newNode = new Node();
			newNode.Payload = Value;
			if (node.Payload < Value) {
				if (node.LeftNode == null) {
					node.LeftNode = newNode;
				} else {
					InsertHelper(Value, node.LeftNode);
				}
			}
			else {
				if (node.RightNode == null) {
					node.RightNode = newNode;
				} else {
					InsertHelper(Value, node.RightNode);
				}
			}
		}
	}
	
	public void Delete(int Value) {
		//search the node of the value
		Node result = this.Search(Value);
		DeleteHelper(result);
	}
	
	//we already identified that the node is 
	public void DeleteHelper(Node node) {
		//go through all the conditions
	}

}
