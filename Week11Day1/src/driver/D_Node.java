package driver;

public class D_Node {
	private int Payload;
	private D_Node PreNode;
	private D_Node NextNode;
	
	public int getPayload() {
		return Payload;
	}
	public void setPayload(int payload) {
		Payload = payload;
	}
	public D_Node getPreNode() {
		return PreNode;
	}
	public void setPreNode(D_Node preNode) {
		PreNode = preNode;
	}
	public D_Node getNextNode() {
		return NextNode;
	}
	public void setNextNode(D_Node nextNode) {
		NextNode = nextNode;
	}
	
	//constructor: create new instance(memory) object of the class(no memory)
	//operating system use constructor to allocate memory space for a new class object
	//constructor is used to set the default value of the properties of the object
	public D_Node() {
		this.Payload = 0;
		this.NextNode = null;
		this.PreNode = null;
	}
	
}
