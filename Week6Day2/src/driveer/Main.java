package driveer;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] testArray = RandomArrayGenerator(0, 100000, 10000);
		int[] testBubble = copyArray(testArray);
		int[] testSelect = copyArray(testArray);
		int[] testInsert = copyArray(testArray);
		bubble_sort(testBubble);
		selection_sort(testSelect);
		insertion_sort(testInsert);
		
		//printArray(testBubble);
		//printArray(testSelect);
		//printArray(testInsert);
		
		
		long start = System.nanoTime();
		bubble_sort(testBubble);
		long end = System.nanoTime();
		System.out.println("Time is" );
		System.out.println(end - start);
		System.out.println(start);
		System.out.println(end);
	}
	
	public static int[] copyArray(int[] arr) {
		int[] result = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}
	
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" -> ");
		}
		System.out.println(" [end].");
	}
	
	public static void insertion_sort(int[] arr) {
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
	
	public static int[] selection_sort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int temp_largest_index = i;
			for(int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[temp_largest_index]) {
					temp_largest_index = j;
				}
			}
			if (temp_largest_index != i) {
				int temp = arr[i];
				arr[i] = arr[temp_largest_index];
				arr[temp_largest_index] = temp;
			}
		}
		return arr;
	}
	
	public static int[] bubble_sort(int[] arr) {
		//bubble sort
		//loop through all items, and sink the larger item to the larger index side
		for(int i = 0; i < arr.length - 1; i++) {
			boolean inOrder = true;
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					inOrder = false;
				}
			}
			//add a in order check so that we can potentially increase the speed
			if (inOrder) {
				//everything are in order
				break;
			}
		}
		
		return arr;
	}
	
	public static int[] RandomArrayGenerator(int start, int end, int count) {
		int[] body = new int[end - start + 1];
		for(int i = 0; i < end - start + 1; i++) {
			body[i] = start + i;
		}
		Random rand = new Random();
		//shuffle
		for(int i = 0; i < end - start + 1; i++) {
			int pos = rand.nextInt(0, end - start + 1);
			if (pos != i) {
				int temp = body[i];
				body[i] = body[pos];
				body[pos] = temp;
			}
		}
		int[] result = new int[count];
		for(int i = 0; i < count; i++) {
			result[i] = body[i];
		}
		return result;
	}
}
