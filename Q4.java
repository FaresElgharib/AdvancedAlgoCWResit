package resitcw;

public class Q4 {

	static public class SimpTextEditor {
		// holds the text string
		private StringBuilder text;
		
		// holds the position of the cursor
		private int cursor;

	    public SimpTextEditor() {
	    	// create the text as empty string
	    	text = new StringBuilder();
	    	
	    	// set the starting cursor position to 0
	    	cursor = 0;  
	    }

	    public void left() {
	        // checks if cursor at the beginning
	    	if (cursor > 0) {
	    		// move cursor one position left if it's not at the beginning
	            cursor--;  
	        }
	    }

	    public void right() {
	    	// checks if cursor at the end
	    	if (cursor < text.length()) {
	    		// move cursor one position right if it's not at the end
	    		cursor++;  
	        }
	    }

	    public void add(char c) {
	    	// adds the character at current cursor position
	    	text.insert(cursor, c);  
	    	// move cursor one position right after adding character
	    	cursor++;  
	    }

	    public void remove() {
	        if (cursor > 0 && cursor <= text.length()) {
	        	// removes character left of current cursor position
	        	text.deleteCharAt(cursor - 1);
	        	// move cursor one position left after removing the character
	            cursor--;
	        }
	    }

	    public void display() {
	    	// output the text as a string
	    	System.out.println(text.toString());
	        System.out.print("Cursor: ");
	        for (int i = 0; i < cursor; i++) {
	        	// output dashes to represent the cursor position (every dash represents a character)
	        	System.out.print("-");
	        }
	        System.out.println("^");
	    }	    
	}
	
	public static void main(String[] args) {
        SimpTextEditor edit = new SimpTextEditor();
        edit.add('F');
        edit.add('a');
        edit.add('r');
        edit.add('e');
        edit.add('s');
        edit.display();
        edit.right();
        edit.right();
        edit.add('!');
        edit.display();
        edit.left();
        edit.display();
        edit.remove();
        edit.display();
        edit.left();
        edit.left();
        edit.left();
        edit.left();
        edit.display();
        edit.add('f');
        edit.display();
    }
}
