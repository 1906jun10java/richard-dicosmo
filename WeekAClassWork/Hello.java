import java.util.Arrays; //imports elements from another class/Saves typing
public class Hello{

	public static void main(String[] args){
		funWithArrays(new Car(1997, "Mazda", "Sundance"), new Boat("blue", "Tracker"), new Car(2015, "Hyndai", "Elantra");
	}

	/*public static void checkTheOil(Car c) {
		if(c.getMilesSinceOilChange() >= Car.recommendedMilesBetweenOilChanges){
		System.out.println9Change your oil");
		} 
	}
	*/
	public static void funWithArrays(){
		//how to create an array
		String[] arr1 = {"this", "is", "an", "array"};
		String[] arr2 = new String[3]; //3 represents the length of the array which indexes as 0-2.
		arr2[0] = "also";
		arr2[1] = "an";
		arr2[2] = "array";
		//iterate through an array
		//regular for loop
		for(int i=0; i<arr1.length; i++){
			System.out.println(arr1[i]);
		}
		//ehnanced (augmented) for loop to iterate through Array or Iterable
		for(String s : arr2){
			System.out.println(s);
		}
		//For print arrays....
		System.out.println("toString from Array: " + arr2.toString());
		System.out.println("toString from Arrays utility class: " + Arrays.toString(arr2));
	}
	public static void init(){
		System.out.println("Hello World!");
		//Create a Marker Object
		Marker m1 = new Marker();	//default constructor
		m1.setInkColor("blue");
		m1.setMarkerType("permanent");
		System.out.println(m1);		//Prints the to string constructed for the method
		Marker m2 = new Marker();
		m2.setInkColor("green");
		m2.setMarkerType("dry-erase");
		System.out.println(m2);
	}

	public static void travel() {
		//Instantiate a new Boat
		Boat b = new Boat();
		b.setColor("green");
		b.setName("Stingray");

		//instantiate a new Boat with our new constructor
		Boat b2 = new Boat("gray", "Dolphin");

		//instantiate a new car
		Car c = new Car(1992, "Chrysler", "New Yorker");

		//make an array of Vehicles
		Vehicle[] vehicles = {b, b2, c};
		for (int i=0; i<vehicles.length; i++){
			vehicles[i].move();
		}
	}
}
