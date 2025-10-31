package driver;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[] {7, 3, 1, 0, 8, 2, 4, 5};
		merge_sort(arr, 0, arr.length - 1);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
	
	public static void merge_sort(int[] arr, int start, int end) {
		if (end > start) {
			int mid = (start + end) / 2; //the partition algorithm
			//recursively use the merge sort to sort the left part of the array
			merge_sort(arr, start, mid);
			//recursively use the merge sort to sort the right part of the array
			merge_sort(arr, mid + 1, end);
			//combine the left sort and right part together
			merging(arr, start, mid, end);
		}
	}
	
	public static void merging(int[] arr, int start, int mid, int end) {
		//complete it
		//left array will be from start to mid
		//right array will be from mid + 1 to end
		//create a temporary array to hold the sorted items
		int[] temp_array = new int[end - start + 1];	//what are the values here in the temp_array
		
		//we start the left array from index start, the right array from mid + 1, compare the value, and put down the smaller one,
		//if left array is the one move the value to temp array, left index increment, which is start + 1
		//if right array is the one, then mid + 1 + 1
		//when do we stop??????????????????????? when either left or right array has no elements??????????????????
		int left = start;
		int right = mid + 1;
		int counter = 0;
		while (left <= mid && right <= end) {
			if (arr[left] <= arr[right]) {
				temp_array[counter] = arr[left];
				counter++;
				left++;
			} else {
				temp_array[counter] = arr[right];
				counter++;
				right++;
			}
		}
		
		//we will have potentially left array is empty or right array is empty
		//when the left array is not empty?
		while(left <= mid) {
			temp_array[counter] = arr[left];
			counter++;
			left++;
		}
		
		//when the right array is not empty
		while(right <= end) {
			temp_array[counter] = arr[right];
			counter++;
			right++;
		}
		
		//all items from the array between start and end has been sorted
		//we need to copy all the items from the temp array to the arr
		for(int i = 0; i < end - start + 1; i++) {
			arr[start + i] = temp_array[i];
		}
	}

}
