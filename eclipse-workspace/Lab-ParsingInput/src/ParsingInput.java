import java.util.Scanner;
public class ParsingInput {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("argument #" + i+ " " + args[i]);
			
			
		}
		Scanner in = new Scanner(System.in);
		String name;
		
		System.out.println("What is your name?");
		name = in.nextLine();
		System.out.println("Hello, " + name + "!");
		
		int age;
		System.out.println("How old are you?");
		age = in.nextInt();
		System.out.println("Dang, " + age + " is old");
	}

}
