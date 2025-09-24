package driver;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println("hello");
		
		int[] testArray = new int[] {3, 4, 1, 5, 2, 6, 0};
		System.out.println("This is the original array");
		printArray(testArray);
		System.out.println("This is the sorted array");
		printArray(selection_sort(testArray));

	}
	
	//use bubble sort to return a new list which keep the number in ascending order
	public static int[] bubble_sort(int[] arr) {
		int[] result = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		
		//bubble sort
		//loop through all items, and sink the larger item to the larger index side
		for(int i = 0; i < arr.length - 1; i++) {
			boolean inOrder = true;
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if (result[j] > result[j + 1]) {
					int temp = result[j];
					result[j] = result[j + 1];
					result[j + 1] = temp;
					inOrder = false;
				}
			}
			//add a in order check so that we can potentially increase the speed
			if (inOrder) {
				//everything are in order
				break;
			}
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
	
	//making all the number in array in descending order
	public static int[] selection_sort(int[] arr) {
		int[] result = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		for(int i = 0; i < arr.length - 1; i++) {
			int temp_largest_index = i;
			for(int j = i + 1; j < arr.length; j++) {
				if (result[j] > result[temp_largest_index]) {
					temp_largest_index = j;
				}
			}
			if (temp_largest_index != i) {
				int temp = result[i];
				result[i] = result[temp_largest_index];
				result[temp_largest_index] = temp;
			}
		}
		return result;
	}

	//randomize [1,2,3,4,5,...,99,100]
	//shuffle
	//we go through 1 to 100
	//every time we generate another number from 1 to 100
	//swap the item between the i and the random position
	//after we go through all items, we made a "shuffle"
	//O(n)
	public static int[] shuffle(int[] arr) {
		Random random = new Random();
		for(int j = 0; j < 3; j++) {
			for(int i = 0; i < arr.length; i++) {
				int pos = random.nextInt(0, arr.length - 1);
				int temp = arr[i];
				arr[i] = arr[pos];
				arr[pos] = temp;
			}
		}
		return arr;
	}
	
	//we want to pick random 100 items from [1, 1000]
	//randomize[1, 1000]
	//pick first 100 items
	//O(n)
}
