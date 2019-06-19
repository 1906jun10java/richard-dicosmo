
public class A {
	//instance variable
	private long id;
	
	//default constructor
	public A() {
		this(2L);
	}
	
	//alternate constructor
	public A(long id){
		initialize();
		this.id = id;
	}
	
	//get method
	public long getId() { return this.id; }
	
	//set method
	public void setId(long id2) { this.id = id; }
	
	//initialize method
	private void initialize() {
		System.out.println("initializing the class...");
	}
	
}
