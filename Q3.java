package resitcw;

public class Q3 {

	static class Node {
	    int value;
	    Node prev;
	    Node next;

	    public Node(int value) {
	        this.value = value;
	        this.prev = null;
	        this.next = null;
	    }
	}

	static class DoublyLinkedList {
		// header sentinel
		Node header;
		// trailer sentinel
	    Node trailer;

	    public DoublyLinkedList() {
	        header = new Node(-1);  
	        trailer = new Node(-1);
	        
	        // Connect header sentinel to trailer sentinel
	        header.next = trailer;
	        
	        // Connect trailer sentinel to header sentinel
	        trailer.prev = header;
	    }

	    public void addNode(int value) {
	        Node newNode = new Node(value);
	        Node lastNode = trailer.prev;

	        // connect last node to new node
	        lastNode.next = newNode;
	        
	        // connect new node to last node
	        newNode.prev = lastNode;
	        
	        // connect new node to trailer sentinel
	        newNode.next = trailer;
	        
	        // connect trailer sentinel to new node
	        trailer.prev = newNode;
	    }

	    public Node findMidNode() {
	    	// start at the node after the header sentinel
	    	Node Ptr = header.next;
	        Node fastPtr = header.next;

	        while (fastPtr != trailer && fastPtr.next != trailer) {
	        	// move slow pointer one node at a time
	        	Ptr = Ptr.next;
	        	
	        	// move fast pointer two nodes at a time
	            fastPtr = fastPtr.next.next;
	        }

	        // return the node pointed to by the regular pointer which is the middle node
	        return Ptr;
	    }
	}

	    public static void main(String[] args) {
	        // driver code
	    	DoublyLinkedList list = new DoublyLinkedList();

	        list.addNode(1);
	        list.addNode(2);
	        list.addNode(3);
	        list.addNode(4);
	        list.addNode(5);
	        list.addNode(6);
	        list.addNode(7);

	        Node middleNode = list.findMidNode();
	        System.out.println("Middle node value: " + middleNode.value);
	    }
}
