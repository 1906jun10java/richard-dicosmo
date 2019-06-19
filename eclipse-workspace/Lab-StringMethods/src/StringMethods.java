
public class StringMethods {

	public static void main(String[] args) {
		String str = "Hello";
		String s = new String("Hello");
		
		//use the equals() method
		System.out.println(str.equals(s));
		
		//use the length() method
		System.out.println(str.length());
		
		//use the indexOf() method
		System.out.println(str.indexOf('H'));
		
		char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(char ltr: letters) {
			str = str.toLowerCase();
			if (str.indexOf(ltr) != -1) {
				System.out.println("The letter " + ltr + " is part of the string");
			}
		}
		
		String a = "5" + 3;
		System.out.println(a);
	}

}
