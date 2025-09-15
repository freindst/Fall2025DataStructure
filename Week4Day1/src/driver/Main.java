package driver;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		System.out.println("hello");

	}
	
	public static boolean unique(String input) {
		if (input.length() == 0) {
			return true;
		}
		ArrayList<Character> seen = new ArrayList<Character>();
		for(int i = 0; i < input.length(); i++) {
			if (i == 0) {
				seen.add(input.charAt(i));
			} else {
				if (charAt(seen, input.charAt(i)) == -1) {
					seen.add(input.charAt(i));
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean unique1(String input) {
		for(int i = 0; i < input.length(); i++) {
			Character cur = input.charAt(i);
			for(int j = i + 1; j < input.length(); j++) {
				if (cur == input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static int charAt(ArrayList<Character> list, Character input) {
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i) == input) {
				return i;
			}
		}
		return -1;
	}
	
	public static int occurrence(String source, String input) {
		//1 divide the string into array separated by non-alphabetic character
		String low_source = source.toLowerCase();
		ArrayList<String> words = new ArrayList<String>();
		String a_word = "";
		for(int i = 0; i < low_source.length(); i++) {
			if (isSeparator(low_source.charAt(i))) {
				if (a_word.length() > 0) {
					words.add(a_word);
					//reset
					a_word = "";
				}
			} else {
				a_word = a_word + low_source.charAt(i);
			}
		}
		if (a_word.length() > 0){
			words.add(a_word);
		}
		//how we define a separator
		//2 search and count the occurrences of the input in the string array generated in step 1 
		int count = 0;
		String low_input = input.toLowerCase();
		for(int i = 0; i < words.size(); i++) {
			if (words.get(i) == low_input) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean isSeparator(Character c) {
		String alphabetic = "abcedfghijklmnopqrstuvwxyz";
		if (alphabetic.indexOf(c) < 0) { //c is not in the alphabetic, so c is a separator
			return true;
		}
		return false;
	}

}
