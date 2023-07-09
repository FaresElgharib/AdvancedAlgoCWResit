package resitcw;

import java.util.ArrayList;
import java.util.List;

public class Q7 {
	
	static class Node {
	    int value;
	 
	    // list of children
	    List<Node> children;
	    
	    // constructor
	    public Node(int value) {
	        this.value = value;
	        this.children = new ArrayList<>();
	    }
	}

	class heightPrinter {
		// printing the node and its subtree height
	    public static void printNodeandHeight(Node node) {
	    	// gets the height of the subtree
	    	int height = getHeight(node);
	        System.out.println("Node value: " + node.value + ", Height: " + height);
	        
	        for (Node child : node.children) {
	            printNodeandHeight(child);
	        }
	    }
	    
	    // getting the height of the subtree of a specific node
	    public static int getHeight(Node node) {
	        if (node == null) {
	            return 0;
	        }
	        
	        int maxHeight = 0;
	        for (Node child : node.children) {
	        	// using recursion getting the height of each child node
	        	int childHeight = getHeight(child);
	        	// stores the maximum height of all the children nodes
	            maxHeight = Math.max(maxHeight, childHeight);
	        }
	        
	        return maxHeight + 1;
	    }
	}

	    public static void main(String[] args) {
	        // creation of tree and driver code
	        Node root = new Node(1);
	        Node node2 = new Node(2);
	        Node node3 = new Node(3);
	        Node node4 = new Node(4);
	        Node node5 = new Node(5);
	        Node node6 = new Node(6);
	     
	        // connect the nodes to their children
	        root.children.add(node2);
	        root.children.add(node3);
	        node2.children.add(node4);
	        node3.children.add(node5);
	        node4.children.add(node6);
	        
	        heightPrinter.printNodeandHeight(root);
	    }
	}
