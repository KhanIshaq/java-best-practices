/**
 * 
 */
package collections;

/**
 * @author ishaqkhan
 * Jacob Schrum
 */
public class BinarySearch { 

	public static void main(String[] args) {
		binarySearch(new Integer[] {5,10,15,23,31,56,73, 88, 91, 95}, 90);
	}
	
	public static <T extends Comparable<? super T>> int binarySearch(T[] array, T key){
		return binarySearch(array, 0, array.length-1, key);
	}
	
	//Recursive Approach
	public static <T extends Comparable<? super T>>  int binarySearch(T[] array, int low, int high, T key) {
		
		int result = -1;
		if(low <= high) {
			int mid = midpoint(low, high);
			if(array[mid].compareTo(key) < 0) {
				System.out.println("Searching right");
				result = binarySearch(array,mid + 1, high, key);
			}else if(array[mid].compareTo(key) > 0) {
				System.out.println("Searching left");
				result = binarySearch(array, low, mid-1, key);
			}else {
				result = mid;
			}
		}
		if(result == -1)System.out.println("Failure!");
		return result;
	}
	
	//Iterative Approach
	public static <T extends Comparable<? super T>> int iterativeBinarySearch(T[] array, T key) {
		int result = -1;
		int low = 0;
		int high = array.length - 1;
		while (low <= high && result == -1) {
			
			int mid = midpoint(low, high);
			if(array[mid].compareTo(key) < 0) {
				System.out.println("Searching right");
				low = mid + 1;
			}else if(array[mid].compareTo(key) > 0) {
				System.out.println("Searching left");
				high = mid - 1;
			}else {
				System.out.println("Found");
				result = mid;
			}
		}
		if(result == -1)System.out.println("Failure!");
		return result;
	}
	
	public static int midpoint(int low, int high) {
		return low + (high - low)/2;
	}
}
