package resitcw;

public class Q1 {
	
	    public static void arrangeArray(int[] arr, int k) {
	        arrangeArrayHelper(arr, k, 0, arr.length - 1);
	    }

	    private static void arrangeArrayHelper(int[] arr, int k, int left, int right) {
	    	// if the partition has one or zero elements, no need to rearrange
	    	if (left >= right) {
	            return;
	        }

	    	// dividing the array into 2 partitions left and right and get the pivot index
	        int pivotIndex = partition(arr, k, left, right);

	     // using recursion arrange the elements to the left of the pivot
	        arrangeArrayHelper(arr, k, left, pivotIndex - 1);
	        
	     // using recursion arrange the elements to the right of the pivot
	        arrangeArrayHelper(arr, k, pivotIndex + 1, right);
	    }

	    private static int partition(int[] arr, int k, int left, int right) {
	    	// choosing the right element as the pivot
	    	int pivot = arr[right];
	        int i = left - 1;

	     // looping through the sub-array from left to right-1
	        for (int j = left; j <= right - 1; j++) {
	            if (arr[j] <= k) {
	            	// if the current element is less than or equal to k swap it with the element at index i+1
	                i++;
	                swap(arr, i, j);
	            }
	        }
	     // swap the pivot element with the element at index i+1
	        swap(arr, i + 1, right);
	     // return the new pivot index
	        return i + 1;
	    }

	 // function to swap two elements in the array
	    private static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

	    public static void main(String[] args) {
	     // driver code for the algorithm
	    	int[] arr = {5, 8, 2, 10, 3, 1, 7};
	        int k = 3;

	        arrangeArray(arr, k);

	      // printing the new array
	        System.out.println("New Array:");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
	}
