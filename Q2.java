package resitcw;

import java.util.Arrays;

public class Q2 {
	
	    public static void inPlaceHeapSort(int[] arr) {
	        int n = arr.length;

	        // create max heap
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(arr, n, i);
	        }

	        // get elements from the heap in descending order
	        for (int i = n - 1; i > 0; i--) {
	            // move current root which is the maximum element to the end
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;

	            // heapify the reduced heap
	            heapify(arr, i, 0);
	        }
	    }

	    public static void heapify(int[] arr, int n, int i) {
	    	// set largest as root
	    	int largest = i;
	    	
	    	// left child
	    	int left = 2 * i + 1;
	    	
	    	// right child
	        int right = 2 * i + 2;

	        // if the left child is larger than the root
	        if (left < n && arr[left] > arr[largest]) {
	            largest = left;
	        }

	        // if the right child is larger than the largest so far
	        if (right < n && arr[right] > arr[largest]) {
	            largest = right;
	        }

	        // if the largest is not the root
	        if (largest != i) {
	            int swap = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = swap;

	            // using recursion heapify the affected sub-tree
	            heapify(arr, n, largest);
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
	        System.out.println("Original array: " + Arrays.toString(arr));

	        inPlaceHeapSort(arr);

	        System.out.println("Sorted array using in place heap sort: " + Arrays.toString(arr));
	    }
	}
