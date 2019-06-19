package fizzbuzz2;

public class FizzBuzz {
	
	int r1;
	int r2;
	int d1;
	int d2;
	public FizzBuzz(int r1, int r2,int d1, int d2 ) {
		this.r1  = r1;
		this.r2 = r2;
		this.d1 = d1;
		this.d2 = d2;
	}
	public void doFizzbuzz(){
		for(int i = r1; i <r2; i++) {
			if(i%d1 == 0 & i%d2 == 0) {
				System.out.println("fizzbuzz");
			}
			else if(i%d1 == 0) {
				System.out.println("fizz");
			}
			else if(i%d2 == 0) {
				System.out.println("buzz");
			}
			else{
				System.out.println(i);
			}
		}
	}
}



