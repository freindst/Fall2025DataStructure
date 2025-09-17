package driver;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 4, 5, 6};
		printArray(array);
		int[] reversed = Reverse(0, array.length - 1, array);
		System.out.println("reversing....");
		printArray(reversed);

	}
	
	public static int Factorial(int n) {
		//initial value
		if (n == 1) {
			return 1;
		} else {
			//how to progressively build the value
			return n * Factorial(n - 1);
		}
	}
	
	public static int[] Reverse(int startIndex, int endIndex, int[] arr) {
		if (startIndex >= endIndex) {
			return arr;
		} else {
			int temp = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = temp;
			return Reverse(startIndex + 1, endIndex - 1, arr);
		}
	}
	
	public static int[] Reverse_loop(int[] arr) {
		int[] return_arr = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			return_arr[arr.length - 1 - i] = arr[i];
		}
		return return_arr;
	}
	
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" > ");
		}
		System.out.println("<end>");
	}
	
	public static int Fibnacci(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {
			return Fibnacci(n - 1) + Fibnacci(n - 2);
		}
	}
	
	//how to build the fibnacci number wihout recursion?
	public static int Fib(int n) {
		int fib_1 = 0;
		int fib_2 = 0;
		for(int i = 1; i <= n; i++) {
			//when fib(i)
			//we should use the fib(i-1) and fib(i -2)
			if (i == 1) {
				fib_2 = 1;
			} else if (i == 2) {
				fib_1 = 1;
			} else if (i < n) {
				int temp = fib_2 + fib_1;
				fib_2 = fib_1;
				fib_1 = temp;
			} else {
				return fib_2 + fib_1;
			}
		}
		return 0;
		
		//a better way is to build a cache array for all the fibnacci number
		//fib_arr[i] = fibnacci(i)
		//then we do not need to calculate the value again
	}

}
