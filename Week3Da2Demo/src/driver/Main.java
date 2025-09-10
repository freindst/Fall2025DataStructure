package driver;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		//System.out.println(random.nextInt(0, 100));
		/*
		int[] arr = new int[] {3, 5, 9, 11, 2, 91, 56, 32, 18};
		int result1 = LinearSearch1(arr, 1);
		System.out.println(result1);
		int result2 = LinearSearch1(arr, 2);
		System.out.println(result2);
		*/
		int[] arr1 =  new int[] {1, 2, 3, 4, 5, 6, 7, 8, 10};
		System.out.println(BinarySearch(arr1, 9));
		System.out.println(BinarySearch(arr1, 3));
	}
	
	//instance method
	public int LinearSearch(int[] input, int target) {
		for(int i = 0; i < input.length; i++) {
			if (target == input[i]) {
				return i;
			}
		}
		return -1;
	}

	//class method/function
	//return the first item's position, which matches the target
	public static int LinearSearch1(int[] input, int target) {
		for(int i = 0; i < input.length; i++) {
			if (target == input[i]) {
				return i;
			}
		}
		return -1;
	}
	
	//return the item matches target
	//array is in ascending order
	public static int BinarySearch(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		int middle = (low + high) / 2;
		while (low != high) {
			if (array[middle] == target) {
				return middle;
			} else if (array[middle] < target) {
				low = middle + 1;
				middle = (low + high) / 2;
			} else {
				high = middle - 1;
				middle = (low + high) / 2;
			}
		}
		if (array[middle] == target) {
			return middle;
		} else {
			return -1;
		}
	}
	
}
