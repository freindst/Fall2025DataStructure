package driver;

public class LinkedList {
	public Node Header;
	
	public LinkedList() {
		this.Header = null;
	}
	
	public Node Search(int value) {
		Node node = this.Header;
		while(node != null) {
			if (node.Payload == value) {
				return node;
			} else {
				node = node.NextNode;
			}
		}
		return null;
	}
	
	public void Append(int value) {
		Node found = Search(value);
		if (found == null) {
			Node node = this.Header;
			if (node == null) {
				this.Header = new Node();
				this.Header.Payload = value;
			} else {
				while (node.NextNode != null) {
					node = node.NextNode;
				}
				Node newNode = new Node();
				newNode.Payload = value;
				node.NextNode = newNode;
			}
		}
	}
	
	public void Delete(int value) {
		Node node = this.Header;
		Node preNode = null;
		if (this.Header.Payload == value) {
			this.Header = null;
		} else {
			preNode = this.Header;
			node = this.Header.NextNode;
			while (node != null) {
				if (node.Payload == value) {
					preNode.NextNode = node.NextNode;
					node.NextNode = null;
				} else {
					preNode = node;
					node = node.NextNode;
				}
			}
		}
	}
}
