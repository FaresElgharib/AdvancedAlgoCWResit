package resitcw;

import java.util.Arrays;

public class Q5 {

	static class CuckooMap<K, V> {
	    private static final int INITIAL_CAPACITY = 16;
	    private static final int MAX_REHASH_ATTEMPTS = 10;

	    private K[] keys;
	    private V[] values;
	    private int size;

	    public CuckooMap() {
	        keys = (K[]) new Object[INITIAL_CAPACITY];
	        values = (V[]) new Object[INITIAL_CAPACITY];
	        size = 0;
	    }

	    public int size() {
	        return size;
	    }

	    public boolean isEmpty() {
	        return size == 0;
	    }

	    public boolean hasKey(K key) {
	        return getKey(key) != null;
	    }
	    
	    private int getIndex(K key, int hashFunction) {
	    	// gets the hash code for the key using the selected hash function
	        int hash = hashFunction == 1 ? key.hashCode() : ~key.hashCode();
	        
	        // maps the hash code to a valid index in the keys array
	        return Math.abs(hash) % keys.length;
	    }

	    public V getKey(K key) {
	    	// computes the two possible indices using the hash functions
	        int index1 = getIndex(key, 1);
	        int index2 = getIndex(key, 2);

	        // checks if the key is at either index
	        if (keys[index1] != null && keys[index1].equals(key)) {
	            return values[index1];
	        } else if (keys[index2] != null && keys[index2].equals(key)) {
	            return values[index2];
	        } else {
	            return null;
	        }
	    }

	    public void add(K key, V value) {
	        if (key == null) {
	            throw new IllegalArgumentException("Key cannot be null");
	        }

	        // checks if the load factor exceeds 0.5 and perform rehashing if it does
	        if (size >= keys.length * 0.5) {
	            rehashMap();
	        }

	        // computes the two possible indices using the hash functions
	        int index1 = getIndex(key, 1);
	        int index2 = getIndex(key, 2);

	        // check if either index is available for insertion
	        if (keys[index1] == null) {
	            keys[index1] = key;
	            values[index1] = value;
	            size++;
	        } else if (keys[index2] == null) {
	            keys[index2] = key;
	            values[index2] = value;
	            size++;
	        } else {
	        	// if both the indices are not free, call evictRehash
	            evictRehash(key, value);
	        }
	    }
	    
	    private void rehashMap() {
	    	// increase the capacity by doubling the array
	        int newCapacity = keys.length * 2;
	        K[] newKeys = Arrays.copyOf(keys, newCapacity);
	        V[] newValues = Arrays.copyOf(values, newCapacity);
	        keys = newKeys;
	        values = newValues;

	        // sets the size back to 0 then reinserts all key-value pairs in the new arrays
	        size = 0;
	        for (int i = 0; i < keys.length; i++) {
	            if (keys[i] != null) {
	                add(keys[i], values[i]);
	            }
	        }
	    }

	    private void evictRehash(K key, V value) {
	        int hashFunction = 1;
	        int attempts = 0;

	        // evicts and rehashing until a free position is found or the maximum attempts is reached (10)
	        while (attempts < MAX_REHASH_ATTEMPTS) {
	        	// evict the key-value pair from the current index and store them
	            K evictedKey = keys[getIndex(key, hashFunction)];
	            V evictedValue = values[getIndex(key, hashFunction)];

	            // inserts the new key-value pair into the current index
	            keys[getIndex(key, hashFunction)] = key;
	            values[getIndex(key, hashFunction)] = value;

	            // updates the key and value variables with the evicted pair for the next iteration
	            key = evictedKey;
	            value = evictedValue;

	            // switching to the other hash function for the next iteration
	            hashFunction = hashFunction == 1 ? 2 : 1;
	            attempts++;
	        }

	        // if the while loop is over that means rehashing failed, increases the capacity and reinserts the pair
	        rehashMap();
	        add(key, value);
	    }
	}
	
	public static void main(String[] args) {
		CuckooMap<String, Integer> map = new CuckooMap<>();
		map.add("one", 1);
		map.add("two", 2);
		map.add("three", 3);

		System.out.println(map.getKey("one"));    // output: 1
		System.out.println(map.getKey("two"));    // output: 2
		System.out.println(map.getKey("three"));  // output: 3
		System.out.println(map.getKey("four"));   // output: null

		System.out.println(map.size());        // output: 3
		System.out.println(map.isEmpty());     // output: false

		map.add("four", 4);
		map.add("five", 5);

		System.out.println(map.size());        // output: 5

		map.add("six", 6);  // rehashing
		map.add("seven", 7);
		
		System.out.println(map.size());        // output: 7
		System.out.println(map.getKey("six"));    // output: 6
		System.out.println(map.getKey("seven"));  // output: 7
	}
}
