package resitcw;

import java.util.ArrayList;
import java.util.List;

public class Q6 {

	static class Node {
	    int value;
	    
	    // list of children
	    List<Node> children;

	    public Node(int value) {
	        this.value = value;
	        this.children = new ArrayList<>();
	    }
	}

	    public static boolean isIsomorphic(Node root1, Node root2) {
	        // base cases
	    	
	    	// both trees are empty
	        if (root1 == null && root2 == null) {
	            return true; 
	        }
	        // one tree is empty and the other is not
	        if (root1 == null || root2 == null) {
	            return false; 
	        }
	        // roots have different number of subtrees
	        if (root1.children.size() != root2.children.size()) {
	            return false; 
	        }

	        // using recursion check if each subtree is isomorphic by running through the base cases
	        for (int i = 0; i < root1.children.size(); i++) {
	            if (!isIsomorphic(root1.children.get(i), root2.children.get(i))) {
	                return false;
	            }
	        }

	        // return true if trees are isomorphic
	        return true;
	    }

	    // driver code
	    public static void main(String[] args) {
	        // first tree
	        Node root1 = new Node(1);
	        Node child1a = new Node(2);
	        Node child1b = new Node(3);
	        Node child1c = new Node(4);
	        root1.children.add(child1a);
	        root1.children.add(child1b);
	        root1.children.add(child1c);

	        // second tree
	        Node root2 = new Node(1);
	        Node child2a = new Node(2);
	        Node child2b = new Node(3);
	        Node child2c = new Node(4);
	        Node child2d = new Node(5);
	        root2.children.add(child2a);
	        root2.children.add(child2b);
	        root2.children.add(child2c);
	        root2.children.add(child2d);

	        // check if the trees are isomorphic
	        boolean isIsomorphic = isIsomorphic(root1, root2);
	        System.out.println("Are the trees isomorphic? " + isIsomorphic);
	    }
	}
