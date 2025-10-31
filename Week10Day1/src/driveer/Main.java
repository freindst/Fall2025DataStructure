package driveer;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello world");
		
		Node node = new Node(1);
		
		System.out.println(node.toString());
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		System.out.println(list);
		
		System.out.println(list.Header);
	}

}
