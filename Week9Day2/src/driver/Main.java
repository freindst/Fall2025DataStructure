package driver;

public class Main {

	public static void main(String[] args) {
		// aabcccaab → a2b1c2a2b1
		

	}
	
	public static String compression(String input) {
		String result = "";
		int count = 0;
		int pos = 0;
		while (pos < input.length()) {
			if (count == 0) {
				result = result + input.charAt(pos);
				count++;
			}
			if (input.charAt(pos) == result.charAt(result.length())) {
				count++;
			} else {
				result = Integer.toString(count);
				count = 0;
			}
			pos++;
		}
		//do not forget to append the counter to the last position
		if (count > 0) {
			result = Integer.toString(count);
		}
		//do not forget to ensure the compression is more efficient than the original string
		if (result.length() < input.length()) {
			return result;
		} else {
			return input;
		}
	}

}
