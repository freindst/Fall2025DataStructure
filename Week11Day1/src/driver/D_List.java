package driver;

public class D_List {
	private D_Node Header;
	public D_Node getHeader() {
		return Header;
	}


	public void setHeader(D_Node header) {
		Header = header;
	}


	public D_Node getTail() {
		return Tail;
	}


	public void setTail(D_Node tail) {
		Tail = tail;
	}


	private D_Node Tail;	//is tail necessary? tail is not necessary, but convenient to have
	
	public D_List() {
		this.Header = null;
		this.Tail = null;
	}
	

	//append: add node to the end
	public void Append(D_Node node) {
		//when it is an empty list
		if (this.Header == null || this.Tail == null) {
			this.Header = node;
			this.Tail = node;
		} else {//when it is not an empty list
			this.Tail.setNextNode(node);
			node.setPreNode(this.Tail);
			this.setTail(node);
		}
	}
	
	//prepend
	public void Prepend(D_Node node) {
		//when it is empty
		if (this.Header == null) {
			this.Header = node;
			this.Tail = node;
		} else {
			//when not an empty list
			this.Header.setPreNode(node);
			node.setNextNode(this.Header);
			this.setHeader(node);
		}
	}
	
	//remove(value)
	//we implement search(value) first
	
	//remove(node)
	//removeAfter
	
	public boolean RemoveAfter(D_Node grandmaNode) {
		//when node is null
		if (grandmaNode == null) {
			return false;
		}
		if (grandmaNode.getNextNode() == null) {
			return true;
		}
		if (grandmaNode.getNextNode().getNextNode() == null) {
			D_Node sonNode = grandmaNode.getNextNode();
			grandmaNode.setNextNode(null);
			sonNode.setPreNode(null);
			this.setTail(grandmaNode);
			return true;
		} else {
			D_Node sonNode = grandmaNode.getNextNode();
			D_Node grandsonNode = sonNode.getNextNode();
			grandmaNode.setNextNode(grandsonNode);
			grandsonNode.setPreNode(grandmaNode);
			sonNode.setNextNode(null);
			sonNode.setPreNode(null);
			return true;
		}
	}
	//removeBefore
	
	//insert
	//insertAfter
	//insertBefore
	//make your code concise is a good programming skill, but do not hurt the readability
	public boolean InsertBefore(D_Node currentNode, D_Node newNode) {
		//currentNode is null: broken
		if (currentNode == null) {
			return false;
		}
		//currentNode.preNode is null: newNode will be the new Header
		if (currentNode.getPreNode() == null) {
			this.Header = newNode;
			newNode.setNextNode(currentNode);
			currentNode.setPreNode(newNode);
		} else {
		//currentNode.preNode is not null: the generic case
			D_Node preNode = currentNode.getPreNode();
			newNode.setNextNode(currentNode);
			newNode.setPreNode(preNode);
			preNode.setNextNode(newNode);
			currentNode.setPreNode(newNode);
		}
		return true;
	}
	
	//search, return the first matching node by the value
	//make your code looks cleaner and more concise is the driven power of polishing your coding
	//skills
	//beautiful
	//design patterns
	//better algorithm
	//standards/version/international standardization
	public D_Node SearchFromHeader(int value) {
		D_Node node = this.Header;
		while (node != null) {
			if (node.getPayload() == value) {
				return node;
			} else {
				node = node.getNextNode();
			}
		}
		return null;
	}
	
	//walk through every element in the data structure
	public int[] Traverse() {
		int total = 0;
		D_Node node = this.Header;
		while(node != null) {
			total++;
			node = node.getNextNode();
		}
		int[] result = new int[total];
		int counter = 0;
		if (total > 0) {
			node = this.Header;
			while(node != null) {
				result[counter] = node.getPayload();
				node = node.getNextNode();
			}
		}
		return result;
	}
}
