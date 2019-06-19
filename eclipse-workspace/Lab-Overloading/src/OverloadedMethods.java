
public class OverloadedMethods {

	public static void main(String[] args) {
		//create instance here
		OverloadedMethods om = new OverloadedMethods();
		om.print();
		
		//Second overloaded method
		om.print("second print method");
		
		//third overloaded method
		om.print("second", "third");

	}
	
	//overload methods here
	public void print() {
		System.out.println("original print method");
	}
	
	public void print(String str) {
		System.out.println(str);
	}
	
	public void print(String str, String str2) {
		System.out.println(str + " " + str2);
	}
	
}
