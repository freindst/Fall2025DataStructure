package driver;

public class Main {

	public static void main(String[] args) {
		int[] testArray = new int[] {3, 6, 1, 4, 2, 5, 0};
		System.out.println("This is the original array");
		printArray(testArray);
		System.out.println("This is the sorted array");
		//InsertionSort(testArray);
		//InsertionSort(testArray, 2);
		//printArray(testArray);
		ShellSort(testArray, new int[] {2, 1});	//we have 2 shells
		printArray(testArray);

	}
	
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" -> ");
		}
		System.out.println(" [end].");
	}
	
	public static void InsertionSort(int[] arr) {
	    for (int i = 1; i < arr.length; i++) {
	        int current = i;
	        while (current > 0 && arr[current] < arr[current-1]) {
	            int temp = arr[current];
	            arr[current] = arr[current - 1];
	            arr[current - 1] = temp;
	            current--;
	        }
	    }
	}
	
	//generic insertion sort which use the round-robin fashion to partition the whole array into span parts, and the function sorted each partition using insertion sort
	public static void InsertionSort(int[] arr, int span) {
		for(int k = 0; k < span; k++) {
		    for (int i = k; i < arr.length; i = i + span) {
		        int current = i;
		        while ((current - span) >= 0 && arr[current] < arr[current-span]) {
		            int temp = arr[current];
		            arr[current] = arr[current - span];
		            arr[current - span] = temp;
		            current = current - span;
		        }
		    }
		}
	}
	
	//intervals = [3, 2, 1]
	//last 1 partition is required
	//intervals should be in descending order (10, 5, 1)
	public static void ShellSort(int[] arr, int[] intervales) {
		for(int k : intervales) {
			InsertionSort(arr, k);
		}
	}
	
	//binary way of creating intervals
	//[64, 32, 16, 8, 4, 2, 1].. 2^n  : 30
	//81, 27, 9, 3, 1
	public static void ShellSort(int[] arr) {
		
	}
}
