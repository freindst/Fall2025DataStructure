package driver;

public class Main {

	public static void main(String[] args) {
		int[] list = new int[] { 3, 5, 7, 1, 2, 6, 8, 0};
		printArray(list);
		quicksort_1(list, 0, list.length - 1);
		printArray(list);

	}
	
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" -> ");
		}
		System.out.println(" [end].");
	}
	
	public static void partition(int[] arr, int low, int high) {
		if (low == high) {
			return;
		}
		int low_index = low;
		int high_index = high;
		
		int pivot = (low + high) / 2;
		int pivot_value = arr[pivot];
		
		boolean done = false;
		
		while(!done) {
			//check the first item that the low index item is larger than the pivot value
			while(arr[low] < pivot_value) {
				low++;
			}
			
			//check until find the first item that the high index item is smalleer than the pivot value
			while(arr[high] > pivot_value) {
				high--;
			}
			
			//swap when it is necessary
			if (low < high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				
				low++;
				high--;
			} else {
				done = true;
			}
		}
		
		partition(arr, low_index, high); //recursively call the partition on the left side of the pivot
		partition(arr, high + 1, high_index);	//recursively call the partition on the right side of the pivot
	}
	
	public static int partition_1(int[] arr, int low, int high) {
		int pivot = arr[(low + high) / 2];
		int low_index = low;
		int high_index = high;
		
		boolean done = false;
		
		while (!done) {
			while (arr[low_index] < pivot) {
				low_index++;
			}
			
			while (arr[high_index] > pivot) {
				high_index--;
			}
			
			if (low_index < high_index) {
				int temp = arr[low_index];
				arr[low_index] = arr[high_index];
				arr[high_index] = temp;
				low_index++;
				high_index--;
			} else {
				done = true;
			}
		}
		
		return high_index;
	}
	
	public static void quicksort_1(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition_1(arr, start, end);
			printArray(arr);
			if (pivot > start) {
				quicksort_1(arr, start, pivot - 1);
			}
			if (end > pivot) {
				quicksort_1(arr, pivot + 1, end);
			}
		}
	}
	
	public static int func(int[] arr, int low, int high) {
		int mid = low;
		int pivot = arr[mid];
		while(mid <= high) {
			int temp = arr[mid];
			if (arr[mid] < pivot) {
				arr[mid] = arr[low];
				arr[low] = temp;
				low++;
				mid++;
			} else if (arr[mid] == pivot) {
				mid++;
			} else {
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}
		return low;
	}
	
	public static void quicksort_2(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = func(arr, start, end);
			printArray(arr);
			if (pivot > start) {
				quicksort_2(arr, start, pivot - 1);
			}
			if (end > pivot) {
				quicksort_2(arr, pivot + 1, end);
			}
		}
	}
}
