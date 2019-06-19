import java.util.Scanner;

public class Palindrome {
	static String phrase = "";
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		phrase = s.nextLine();
		s.close();
		
		System.out.println(isPalindrome(phrase));

	}
	
	public static boolean isPalindrome(String input) {
		int length = phrase.length();
		int c = 0;
		while(c <= length/2) {
			if (c != (length - 1 - c)) {
				return false;
				
			}
		c = c + 1;	
		}
		return true;
	}

}
